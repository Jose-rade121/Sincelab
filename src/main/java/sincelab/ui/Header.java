package sincelab.ui;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author josee
 */


public class Header extends JPanel{
    
            
    public String background = null;
    public String fonts_c = null;
    public String panels = null;
    
    public static void light_m(){
        
    }
    
    
    public static void black_m(){
        
    }
    
    
    public Header(){
      
        /* Codigo del modo claro/oscuro */
        
        ImageIcon Colormode = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/moon_white.png")
        );
        
        
        JPanel colorspanel = new JPanel(
                new FlowLayout(FlowLayout.RIGHT,20,10)
        ); 

        JButton colors = new JButton();
        colors.setIcon(Colormode);       
        colors.setPreferredSize(new Dimension(60,40));
        colors.setBorderPainted(false);
        colors.setContentAreaFilled(false);
        colors.setFocusPainted(false);
        colors.setVerticalAlignment(colors.CENTER);
        colors.setBorder(
                BorderFactory.createEmptyBorder(0,0,0,20)
        );
        colorspanel.setOpaque(false);
        colorspanel.add(colors);
        
        
       
        setPreferredSize(new Dimension(1280,60)); //Aqui se le asigna el tamaño al panel
 
        /*
            Codigo del Titulo
        */
        
        principalFont fonttype;
        fonttype = new principalFont();
        
        
        
        JLabel title = new JLabel();
        //Border border = BorderFactory.createLineBorder(new Color(59,130,246),3);
        title.setText("SINCELAB");
        title.setForeground(Color.WHITE);
        title.setFont(fonttype.principalFont(fonttype.BESTIME, 0, 20)); //Selecciona la fuente.
        title.setBorder(
                BorderFactory.createEmptyBorder(0,20,0,0)
        );
        
        /*
            Codigo del about
        */ 
        //Acomodarlo a la derecha
        JLabel about = new JLabel();
        about.setText("About");
        about.setForeground(Color.WHITE);
        about.setFont(fonttype.principalFont(fonttype.HEY_COMIC, 0, 16));
        about.setHorizontalAlignment(about.RIGHT);
        about.setBorder(
                BorderFactory.createEmptyBorder(0, 0, 0, 100)
        );
        
        /*Especificaciones del header*/
        
        //Esto permite que no se remonte sobre los otros.
        setLayout(new BorderLayout());
        setBackground(new Color(59,130,246));
        add(title, BorderLayout.WEST);
        add(about);
        add(colorspanel, BorderLayout.EAST);
    }

}

   /*
        JPanel header = new JPanel(); //Crea un panel.
        Para redondear usa una libreria de graficos2D
        me da cosa que digan q fue con IA entonces mejor pa futuro.
        header.drawRoundRect(0,0,1280,70,20,20);
    */
       