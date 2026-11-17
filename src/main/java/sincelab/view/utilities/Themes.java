package sincelab.view.utilities;
import java.awt.Color;

/**
 * Responsabilidad: guarda los colores del tema actual (fondo, texto de la barra y
 * barra de titulo) y permite cambiarlos entre modo claro, oscuro y verde.
 *
 * Plataforma JDK minima: 17.
 *
 * @author josee
 * @version 1.0
 */
public class Themes {
             
    public static Color backgroundC;
    public static Color fontsBarC;
    public static Color titleBar;
    public static boolean darkMode;
    public static boolean flowerMode;
    
    public static void lightMode(){
        darkMode = false;
        backgroundC = new Color(226,230,235);
        fontsBarC = Color.WHITE;
        titleBar = new Color(59,130,246);
    }
    
    
    public static void blackMode(){
        darkMode = true;
        backgroundC = new Color(130,160,188);//61,59,59
        fontsBarC = Color.WHITE;
        titleBar = new Color(48,77,109); //45,45,45
    }
    
    public static void greenMode(){
        backgroundC = new Color(122,158,126);
        fontsBarC = new Color(232,241,242);
        titleBar = new Color(49,73,60);
    }
    
}
