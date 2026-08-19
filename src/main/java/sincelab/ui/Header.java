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
    
    private MainWindow mainWindow;
    
    
    private void changeTheme(JLabel title,JLabel about){
            title.setForeground(Themes.fontsBarC);
            about.setForeground(Themes.fontsBarC);  
            setBackground(Themes.titleBar);
    }
    

    
    public Header(MainWindow mainWindow){
        
        this.mainWindow = mainWindow;
        
        
        /* Codigo del modo claro/oscuro */
        
        ImageIcon colorMode = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/astronaunt-icon.png")
        );

        JPanel colorsPanel = new JPanel(
                new FlowLayout(FlowLayout.RIGHT,20,10)
        ); 

        JButton colors = new JButton();
        colors.setIcon(colorMode);       
        colors.setPreferredSize(new Dimension(40,40));
        colors.setBorderPainted(false);
        colors.setContentAreaFilled(false);
        colors.setFocusPainted(false);
        colors.setVerticalAlignment(colors.CENTER);
        
        colorsPanel.setOpaque(false);
        colorsPanel.add(colors);
        
        
        
       
        
 
        /*
            Codigo del Titulo
        */
        
        PrincipalFont fontType = new PrincipalFont();
        
        
        
        JLabel title = new JLabel();
        //Border border = BorderFactory.createLineBorder(new Color(59,130,246),3);
        title.setText("SINCELAB");
        title.setForeground(Color.WHITE);
        title.setFont(fontType.getFont(fontType.BESTIME, 0, 20)); //Selecciona la fuente.
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
        about.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 16));
        about.setHorizontalAlignment(about.RIGHT);
        about.setBorder(
                BorderFactory.createEmptyBorder(0, 0, 0, 100)
        );
        
        
        
        
        
        /*Especificaciones del header*/
        
        //Esto permite que no se remonte sobre los otros.
        setPreferredSize(new Dimension(1280,60)); //Aqui se le asigna el tamaño al panel
        setLayout(new BorderLayout());
        setBackground(new Color(59,130,246));
        add(title, BorderLayout.WEST);
        add(about);
        add(colorsPanel, BorderLayout.EAST);
        
        //Aqui lee si presiona el boton y hace el cambio de modo
        colors.addActionListener(e -> {
            
            if(!Themes.darkMode){
                Themes.blackMode();
            } else {
                Themes.lightMode();
            }
 
            changeTheme(title,about);  
            mainWindow.background();
        });
    }
}

    
    
   /*
        JPanel header = new JPanel(); //Crea un panel.
        Para redondear usa una libreria de graficos2D
        me da cosa que digan q fue con IA entonces mejor pa futuro.
        header.drawRoundRect(0,0,1280,70,20,20);
    */
       