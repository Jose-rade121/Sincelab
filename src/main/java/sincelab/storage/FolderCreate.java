package sincelab.storage;


import java.util.Properties;
import java.io.File;


/**
 *
 * @author josee
 */
public class FolderCreate {
  
    public FolderCreate(){
    
        File folder = new File(System.getProperty("user.home") + "/.sincelab");
 
    
        if(!folder.exists()){
           folder.mkdir();
        }

    }   
    
    
 /*   
    Esto se aplicara en su momento cuando existan los botones de
    registro
   
    public File newRegistration(){
       
        Users NewUser = new Users();
        
        
        return null;
    }
 */   
}
