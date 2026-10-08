package sincelab.storage;


import java.util.Properties;
import java.io.File;
import java.util.ArrayList;


/**
 *
 * @author josee
 */
public class Archive extends Users{
    
    ArrayList<Users> Data = new ArrayList<>();
    

    public Archive(String name, String carrer){
        super(name,carrer);
    }

    public static void FolderCreate(){
    
        File folder = new File(System.getProperty("user.home") + "/.sincelab");
 
    
        if(!folder.exists()){
           folder.mkdir();
        }

    }   
    
    public File newRegistration(){
       
        //Users User = new Users(,); -> Faltan los dos datos
        
        
        return null;
    }
    
    
    public static void main(String[]args){
        FolderCreate();
    }
      
}
