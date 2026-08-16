package sincelab.ui;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author josee
 */


public class Header extends JPanel{
    public Header(){
        setPreferredSize(new Dimension(1280,60));
 
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

          
        //Acomodarlo a la derecha
        JLabel about = new JLabel();
        about.setText("About");
        about.setForeground(Color.WHITE);
        about.setFont(fonttype.principalFont(fonttype.BESTIME, 0, 16));
        about.setHorizontalAlignment(about.RIGHT);
        about.setBorder(
                BorderFactory.createEmptyBorder(0, 0, 0, 100)
        );
        
        
        
        //Esto permite que no se remonte sobre los otros.
        setLayout(new BorderLayout());
        setBackground(new Color(59,130,246));
        add(title, BorderLayout.WEST);
        add(about);
    }

}

   /*
        JPanel header = new JPanel(); //Crea un panel.
        Para redondear usa una libreria de graficos2D
        me da cosa que digan q fue con IA entonces mejor pa futuro.
        header.drawRoundRect(0,0,1280,70,20,20);
    */
       