package sincelab.view;



import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;






//import java.awt.Graphics2D; -> pa luego.



/**
 *  
 *
 * 
 *
 * @author josee
 */

public final class MainWindow extends JFrame implements Themed{

    private Header header;
    public static Color backgroundColor;
    
    public void background(){    
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
        
    public MainWindow() {  
   
        PrincipalFont fontType = new PrincipalFont();
 
        /*Icono*/
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        
        /*Texto debajo del header*/
        
        JPanel programas = new JPanel(
            new FlowLayout(FlowLayout.LEFT,15,10)
        );
        
        
        JLabel program = new JLabel();
        program.setText("Programas");
        program.setForeground(Color.BLACK);
        program.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 14));
        
        programas.setOpaque(false);
        programas.add(program);
        
               
        
        /*Rectangulos de las Unidades*/

        JPanel matematicas1 = new JPanel();
        matematicas1.setPreferredSize(new Dimension(350,250));
        //matematicas1.getBorder();
        
        JLabel titM1 = new JLabel();
        titM1.setText("Programas");
        titM1.setForeground(Color.BLACK);
        titM1.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 14));
        
        
        
        matematicas1.add(titM1);
        
        add(matematicas1);
        
        
        JPanel fisica1 = new JPanel();
        fisica1.setPreferredSize(new Dimension(350,250));

        
        JPanel humanidades = new JPanel();
        humanidades.setPreferredSize(new Dimension(350,250));
       
        JPanel algLineal = new JPanel();
        algLineal.setPreferredSize(new Dimension(350,250));
        
        JPanel puntuaciones = new JPanel();
        puntuaciones.setPreferredSize(new Dimension(350,250));
        
        
        //Relacionadas a la ventana:
        
        setIconImage(icon.getImage());
        setTitle("SINCELAB");   //Le da un titulo.
        setSize(1280,720);      // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
          

        header  = new Header(this, false);
        add(header, BorderLayout.NORTH);
        add(programas);
        background();
        setLocationRelativeTo(null); //La centra en la pantalla
        setVisible(true); //Muestra la ventana.   
  
    }
}
