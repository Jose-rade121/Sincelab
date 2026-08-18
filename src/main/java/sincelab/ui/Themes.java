package sincelab.ui;
import java.awt.Color;

/**
 *
 * @author josee
 */
public class Themes {
             
    public static Color background_c;
    public static Color fonts_bar_c;
    public static Color title_bar;
    public static Boolean Darkmode;
    
    public static void light_m(){
        Darkmode = false;
        background_c = new Color(61,59,59);
        fonts_bar_c = Color.WHITE;
        title_bar = new Color(59,130,246);
    }
    
    
    public static void black_m(){
        Darkmode = true;
        background_c = new Color(226,230,235);
        fonts_bar_c = Color.WHITE;
        title_bar = new Color(45,45,45); 
    }
    
}
