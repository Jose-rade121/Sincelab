package sincelab.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



/**
 *
 * @author josee
 */
public class UiLogin extends JFrame implements Themed{
    
    public void background(){    
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    public UiLogin(){
        
         ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/guardado.png")
        ); 
        
        
        PrincipalFont fontType = new PrincipalFont();
        
        JPanel loginPanel = new JPanel(null); 
        
        JLabel title = new JLabel();
        title.setText("REGISTRATE");
        title.setForeground(Color.BLACK);
        title.setFont(fontType.getFont(fontType.BESTIME, 0 , 20));
        title.setHorizontalAlignment(title.CENTER);
        title.setBounds(30,30,260,30);
        
        /*
            Campo de ingreso nombre
        */
        JLabel lblnombre = new JLabel("Nombre: ");
        lblnombre.setForeground(Color.BLACK);
        lblnombre.setFont(fontType.getFont(fontType.HEY_COMIC, 0 , 14));
        lblnombre.setBounds(30,65,260,30);
        
        JTextField nombre = new JTextField();
        nombre.setBounds(30,95,260,30);
        
        
        /*
            Campo de ingreso carrera
        */
        JLabel lblcarrera = new JLabel("Carrera: ");
        lblcarrera.setForeground(Color.BLACK);
        lblcarrera.setFont(fontType.getFont(fontType.HEY_COMIC, 0 , 14));
        lblcarrera.setBounds(30,130,260,30);
        
        JTextField carrera = new JTextField();
        carrera.setBounds(30,160,260,30);
        
        
        
     
        loginPanel.setPreferredSize(new Dimension(640,210));
        loginPanel.setOpaque(false);
        loginPanel.add(title);
        loginPanel.add(lblcarrera);
        loginPanel.add(lblnombre);
        loginPanel.add(carrera);
        loginPanel.add(nombre);
        
        loginPanel.setVisible(true);
        
        setIconImage(icon.getImage());
        setTitle("Nuevo Registro");
        setSize(640,420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        add(loginPanel, BorderLayout.WEST);
        background();
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
}
