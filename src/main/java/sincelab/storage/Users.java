package sincelab.storage;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author josee
 */
public class Users {

    private String Nombre;
    private String Carrera;
    private int Puntaje;
    
    public Users(String Nombre, String Carrera, int Puntaje){
        this.Nombre = Nombre;
        this.Carrera = Carrera;
        this.Puntaje = Puntaje;
    }
    
    public String getNombre(){return Nombre;}
    public String getCarrera() {return Carrera;}
    public int getPuntaje() {return Puntaje;}

    public void setNombre(String Nombre) {this.Nombre = Nombre;}
    public void setCarrera(String Carrera) {this.Carrera = Carrera;}
    public void setPuntaje(int Puntaje) {this.Puntaje = Puntaje;}
    
    //Aqui faltan alguno cambios para el envio de datos, aun no ejecuten!!!
    
    
    public void guardar(){
         
        Dotenv env = Dotenv.load();
        
        String url = env.get("DB_URL");
        String user = env.get("DB_USER");
        String pass = env.get("DB_APP_PASSWORD");
        
        String sql = "INSERT INTO Estudiantes (nombre, carrera, puntaje) VALUES (?,?,?)";
        
        try(Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, this.Nombre);
            ps.setString(2, this.Carrera);
            ps.setInt(3, this.Puntaje);
            System.out.println("Filas insertadas: " + ps.executeUpdate());
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
  
}
