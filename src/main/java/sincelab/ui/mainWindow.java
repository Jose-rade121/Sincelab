package sincelab.ui;
import javax.swing.*;
import java.awt.Color;

/**
 * 
 *
 * @author josee
 */
public class mainWindow extends JFrame{
    
    public mainWindow() {  
        
        setTitle("SINCELAB"); //Le da un titulo.
        setSize(1280,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
        
        getContentPane().setBackground(new Color(226,230,235)); //Cambia el color del fondo
        
        setVisible(true); //Muestra la ventana.
        
    }

}
