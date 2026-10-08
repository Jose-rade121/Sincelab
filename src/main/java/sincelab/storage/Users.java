package sincelab.storage;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author josee
 */
public class Users {

    private String name = null;
    private String carrer = null;
    private int points;
      
    public Users(String name, String carrer){
        this.name = name;
        this.carrer = carrer;
    }
    
    
    /* Metodos Get*/
    public void getName(String name) {this.name = name;}
    public void getCarrer(String carrer) {this.carrer = carrer;}
    
    /* Metodos Set*/
    public String setName(){return name;}
    public String setCarrer(){return carrer;}
       
}
