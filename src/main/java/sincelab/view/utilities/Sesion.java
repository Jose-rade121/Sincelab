package sincelab.view.utilities;
 
import sincelab.storage.sesion.Users;
 
/**
 * Responsabilidad: guarda en memoria al usuario que tiene la sesion iniciada y el id
 * de su cuenta en la base de datos. Las ventanas consultan aqui quien esta usando la
 * aplicacion.
 *
 * Plataforma JDK minima: 17.
 *
 * @author Angel
 * @version 1.0
 */
public class Sesion {
 
    private static Users actual;
    private static int usuarioId = -1;   // id de la cuenta en la base de datos
 
    private Sesion() {
    }
 
    /** Solo se llama despues de verificar la cuenta en la base de datos. */
    public static void iniciar(Users usuario, int id) {
        actual = usuario;
        usuarioId = id;
    }
 
    public static Users actual() {
        return actual;
    }
 
    public static int usuarioId() {
        return usuarioId;
    }
 
    public static boolean haySesion() {
        return actual != null && usuarioId > 0;
    }
 
    public static void cerrar() {
        actual = null;
        usuarioId = -1;
    }
}