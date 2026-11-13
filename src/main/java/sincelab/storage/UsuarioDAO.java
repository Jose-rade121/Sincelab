package sincelab.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Crear cuentas e iniciar sesion contra la base de datos. */
public final class UsuarioDAO {

    /** Datos de una cuenta ya verificada (puntos = suma de todas sus materias). */
    public record Cuenta(int id, String nombre, String carrera, int puntos) {
    }

    private UsuarioDAO() {
    }

    /** Crea la cuenta. Devuelve null si el usuario ya existe. */
    public static Cuenta registrar(String usuario, String nombre, String carrera, char[] clave)
            throws SQLException {
        String sql = "INSERT INTO usuarios (usuario, nombre, carrera, password_hash) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.obtener();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, usuario);
            ps.setString(2, nombre);
            ps.setString(3, carrera);
            ps.setString(4, Seguridad.hashear(clave));
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                rs.next();
                return new Cuenta(rs.getInt(1), nombre, carrera, 0);
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {   // entrada duplicada: el usuario ya existe
                return null;
            }
            throw e;
        }
    }

    /** Verifica usuario y contrasena. Devuelve null si no coinciden. */
    public static Cuenta iniciarSesion(String usuario, char[] clave) throws SQLException {
        String sql = "SELECT u.id, u.nombre, u.carrera, u.password_hash, "
                + "COALESCE((SELECT SUM(p.puntos) FROM puntajes p WHERE p.usuario_id = u.id), 0) AS total "
                + "FROM usuarios u WHERE u.usuario = ?";

        try (Connection con = Conexion.obtener();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next() || !Seguridad.verificar(clave, rs.getString("password_hash"))) {
                    return null;
                }
                return new Cuenta(rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("carrera"), rs.getInt("total"));
            }
        }
    }
}
