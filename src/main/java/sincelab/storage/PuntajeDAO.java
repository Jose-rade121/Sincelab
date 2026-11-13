package sincelab.storage;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sincelab.view.utilities.Sesion;
 
/**
 * Guarda puntajes y arma el ranking.
 * El usuario siempre sale de Sesion (quien inicio sesion), nunca de un texto escrito.
 */
public final class PuntajeDAO {
 
    public record Posicion(String nombre, int puntos) {
    }
 
    private PuntajeDAO() {
    }
 
    /**
     * Guarda el puntaje de la persona con sesion iniciada en esa materia
     * (si ya tenia uno, se conserva el mayor) y actualiza el puntaje total
     * que muestra la sesion (Sesion.actual().getPuntaje()).
     */
    public static void guardar(String materia, int puntos) throws SQLException {
        if (!Sesion.haySesion()) {
            throw new IllegalStateException("No hay sesion iniciada");
        }
        String sql = "INSERT INTO puntajes (usuario_id, materia, puntos) VALUES (?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE puntos = GREATEST(puntos, VALUES(puntos))";
 
        try (Connection con = Conexion.obtener();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Sesion.usuarioId());
            ps.setString(2, materia);
            ps.setInt(3, puntos);
            ps.executeUpdate();
        }
 
        // El total sale de la base de datos, asi no se suma de mas si repite el quiz
        Sesion.actual().setPuntaje(totalActual());
    }
 
    /** Suma de los puntos de la persona con sesion iniciada. */
    public static int totalActual() throws SQLException {
        if (!Sesion.haySesion()) {
            return 0;
        }
        String sql = "SELECT COALESCE(SUM(puntos), 0) FROM puntajes WHERE usuario_id = ?";
 
        try (Connection con = Conexion.obtener();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Sesion.usuarioId());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }
 
    /** Ranking de mayor a menor. materia = null para el ranking general. */
    public static List<Posicion> ranking(String materia, int limite) throws SQLException {
        String sql = "SELECT u.nombre, SUM(p.puntos) AS total "
                + "FROM puntajes p JOIN usuarios u ON u.id = p.usuario_id "
                + "WHERE (? IS NULL OR p.materia = ?) "
                + "GROUP BY u.id, u.nombre "
                + "ORDER BY total DESC, u.nombre ASC "
                + "LIMIT ?";
 
        List<Posicion> lista = new ArrayList<>();
 
        try (Connection con = Conexion.obtener();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, materia);
            ps.setString(2, materia);
            ps.setInt(3, limite);
 
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Posicion(rs.getString("nombre"), rs.getInt("total")));
                }
            }
        }
        return lista;
    }
}
 