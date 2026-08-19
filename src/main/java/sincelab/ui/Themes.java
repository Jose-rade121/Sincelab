package sincelab.ui;
import java.awt.Color;

/**
 *
 * @author josee
 */
public class Themes {
             
    public static Color backgroundC;
    public static Color fontsBarC;
    public static Color titleBar;
    public static boolean darkMode;
    
    public static void lightMode(){
        darkMode = false;
        backgroundC = new Color(226,230,235);
        fontsBarC = Color.WHITE;
        titleBar = new Color(59,130,246);
    }
    
    
    public static void blackMode(){
        darkMode = true;
        backgroundC = new Color(61,59,59);
        fontsBarC = Color.WHITE;
        titleBar = new Color(45,45,45); 
    }
    
}
