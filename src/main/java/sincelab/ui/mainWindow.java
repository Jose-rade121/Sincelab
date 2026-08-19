package sincelab.ui;



import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;






//import java.awt.Graphics2D; -> pa luego.




/**
 *  
 *
 * 
 *
 * @author josee
 */

public final class MainWindow extends JFrame{
    
    private Header header;
    public static Color backgroundColor;
    
    public void background(){
        
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
        
    public MainWindow() {  
        
        header  = new Header(this);
       
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
