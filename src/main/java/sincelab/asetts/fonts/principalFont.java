package sincelab.asetts.fonts;

import java.awt.Font;
import java.io.InputStream;


public class principalFont{
    
    public Font font = null;
    public String BESTIME = "Bestime.ttf";
    
    public Font principalFont(String fontName, int style, float size){
     
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