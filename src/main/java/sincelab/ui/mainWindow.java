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


public final class mainWindow extends JFrame{
   
    public mainWindow() {  
        
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        setIconImage(icon.getImage());
        setTitle("SINCELAB"); //Le da un titulo.
        setSize(1280,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
        getContentPane().setBackground(new Color(226,230,235)); //Cambia el color del fondo.
          
        
        add(new Header(), BorderLayout.NORTH);
        setVisible(true); //Muestra la ventana.
    }
}
