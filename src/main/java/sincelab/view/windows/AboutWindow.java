package sincelab.view.windows;

import java.awt.*;
import javax.swing.*;

import sincelab.view.Header;
import sincelab.view.Themed;
import sincelab.view.Themes;

/**
 *
 * @author josee
 */
public final class AboutWindow extends JFrame implements Themed{
    
    private Header header;
    public static Color backgroundColor;
    
    @Override
    public void background(){
        
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    public AboutWindow(){
   
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        setIconImage(icon.getImage());
        setTitle("ABOUT"); //Le da un titulo.
        setSize(1100,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
          
        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        background();
        setLocationRelativeTo(null); //La centra en la pantalla
        setVisible(true); //Muestra la ventana.   
        
    }
}
