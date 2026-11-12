package sincelab.storage.sesion;
 
/**
 * Datos de la persona con sesion iniciada.
 *
 * Es solo un modelo: NO habla con la base de datos.
 *  - Crear cuenta / iniciar sesion:  UsuarioDAO
 *  - Guardar puntos de un quiz:      PuntajeDAO.guardar(materia, puntos)
 *
 * @author josee
 */
public class Users {
 
    private String nombre;
    private String carrera;
    private int puntaje;   // suma de los puntos guardados de todas las materias
 
    public Users(String nombre, String carrera, int puntaje) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.puntaje = puntaje;
    }
 
    public String getNombre() { return nombre; }
    public String getCarrera() { return carrera; }
    public int getPuntaje() { return puntaje; }
 
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    public void setPuntaje(int puntaje) { this.puntaje = puntaje; }
    public void sumarPuntaje(int puntos) { this.puntaje += puntos; }
}