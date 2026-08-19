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
        backgroundC = new Color(172,173,188);
        fontsBarC = new Color(155,158,206);
        titleBar = new Color(71,59,240);
    }
    
    
    public static void blackMode(){
        darkMode = true;
        backgroundC = new Color(61,59,59);
        fontsBarC = Color.WHITE;
        titleBar = new Color(45,45,45); 
    }
    
}
