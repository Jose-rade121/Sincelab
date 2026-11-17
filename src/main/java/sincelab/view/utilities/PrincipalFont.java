package sincelab.view.utilities;

import java.awt.Font;
import java.io.InputStream;

/**
 * Responsabilidad: carga las fuentes del proyecto (Bestime, Hey Comic, Stay With Me y
 * Nunito Black) desde los recursos y entrega copias con el estilo y el tamano pedidos.
 *
 * Plataforma JDK minima: 17.
 *
 * @author Equipo SINCELAB
 * @version 1.0
 */

public class PrincipalFont{
    
    public Font font = null;
    public String BESTIME = "/sincelab/assets/fonts/Bestime.ttf";
    public String HEY_COMIC = "/sincelab/assets/fonts/Hey_Comic.ttf";
    public String STAY_WITH_ME = "/sincelab/assets/fonts/Stay_With_Me.otf";
    public String NUNITO_BLACK = "/sincelab/assets/fonts/Nunito-Black.ttf";
    
    public Font getFont(String fontName, int style, float size){
     
        try{
            InputStream data = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, data);
            
        } catch(Exception e){
            
            font = new Font("Arial", Font.PLAIN, 20);
            
        }
        Font tfont = font.deriveFont(style, size);
        return tfont;
    }   
}