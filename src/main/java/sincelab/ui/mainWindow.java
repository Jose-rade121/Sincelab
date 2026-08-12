package sincelab.ui;
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
public final class mainWindow extends JFrame{
    
    public mainWindow() {  
        
        setTitle("SINCELAB"); //Le da un titulo.
        setSize(1280,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
        getContentPane().setBackground(new Color(226,230,235)); //Cambia el color del fondo
        
        header();
        
        setVisible(true); //Muestra la ventana. 
    }
    
    public void header(){

        JPanel header = new JPanel(); //Crea un panel
        header.setBackground(new Color(59,130,246));
        getContentPane().setLayout(null); 
        //Esto permite que no se remonte sobre los otros
        header.setBounds(0,0,1280,60);//Altera el tamaño del panel
        
        /*
        * Para redondear usa una libreria de graficos2D
        * me da cosa que digan q fue con IA entonces mejor pa futuro.
        *
        * header.drawRoundRect(0,0,1280,70,20,20);
        */
        
        
        
        
        
        add(header);//Añade el valor a pantalla
    }
}
