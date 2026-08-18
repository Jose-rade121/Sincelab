package sincelab.ui;



import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;





//import java.awt.Graphics2D; -> pa luego.




/**
 *  
 *
 * 
 *
 * @author josee
 */
private Header header;


public final class mainWindow extends JFrame{
    
    public static Color background_color;
    
    public void background(){
        
        getContentPane().setBackground(Themes.background_c);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
        
    public mainWindow() {  
        
        Header header = new Header(this);
       
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        setIconImage(icon.getImage());
        setTitle("SINCELAB"); //Le da un titulo.
        setSize(1280,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
          
        
        add(header, BorderLayout.NORTH);
        background();
        setVisible(true); //Muestra la ventana.   
    }
}
