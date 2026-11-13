package sincelab.tests;

import sincelab.storage.PuntajeDAO;
import sincelab.storage.UsuarioDAO;
import sincelab.storage.sesion.Users;
import sincelab.view.utilities.Sesion;

/**
 * Prueba de humo de la capa de datos, SIN interfaz:
 * registro, duplicado, login, clave incorrecta, puntajes y ranking.
 *
 * Ejecutar (con la base encendida y el esquema aplicado):
 *   mvn -q test-compile exec:java -Dexec.mainClass=sincelab.storage.DaoSmoke -Dexec.classpathScope=test
 */
public class DaoSmoke {

    private static int fallos = 0;

    public static void main(String[] args) throws Exception {
        String usuario = "smoke_" + System.currentTimeMillis();
        String nombre = "Prueba " + usuario;
        char[] clave = "clave-de-prueba-123".toCharArray();

        UsuarioDAO.Cuenta c = UsuarioDAO.registrar(usuario, nombre, "Sistemas", clave);
        check(c != null, "registro de cuenta nueva");

        check(UsuarioDAO.registrar(usuario, "Otro", "Otra", clave) == null,
                "usuario repetido detectado (error 1062)");

        check(UsuarioDAO.iniciarSesion(usuario, "incorrecta".toCharArray()) == null,
                "contrasena incorrecta rechazada");

        UsuarioDAO.Cuenta l = UsuarioDAO.iniciarSesion(usuario, clave);
        check(l != null && l.id() == c.id(), "login correcto");

        Sesion.iniciar(new Users(l.nombre(), l.carrera(), l.puntos()), l.id());
        PuntajeDAO.guardar("fisica", 60);
        PuntajeDAO.guardar("fisica", 40);        // menor: no debe bajar el puntaje
        PuntajeDAO.guardar("humanidades", 30);

        check(PuntajeDAO.totalActual() == 90, "total = mejor de fisica (60) + humanidades (30)");
        check(Sesion.actual().getPuntaje() == 90, "total actualizado en la sesion");

        boolean general = PuntajeDAO.ranking(null, 1000).stream()
                .anyMatch(p -> p.nombre().equals(nombre) && p.puntos() == 90);
        check(general, "aparece en el ranking general con 90");

        boolean fisica = PuntajeDAO.ranking("fisica", 1000).stream()
                .anyMatch(p -> p.nombre().equals(nombre) && p.puntos() == 60);
        check(fisica, "aparece en el ranking de fisica con 60");

        Sesion.cerrar();

        System.out.println();
        System.out.println("Limpieza (opcional): DELETE FROM usuarios WHERE usuario LIKE 'smoke\\_%';");
        System.exit(fallos == 0 ? 0 : 1);
    }

    private static void check(boolean ok, String descripcion) {
        System.out.println((ok ? "OK     " : "FALLO  ") + descripcion);
        if (!ok) {
            fallos++;
        }
    }
}
