package sincelab.view.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import sincelab.view.PrincipalFont;
import sincelab.view.Themed;
import sincelab.view.Themes;



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
        
        JPanel loginPanel = new JPanel(null){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255,255,255,190));
                g2.fillRoundRect(10,15,getWidth() - 20, 305, 25, 25);
                g2.dispose();
                super.paintComponent(g);
            }
        }; 
       
        
        JLabel title = new JLabel();
        title.setText("REGISTRATE");
        title.setForeground(new Color(32, 17, 82));
        title.setFont(fontType.getFont(fontType.BESTIME, 0 , 20));
        title.setHorizontalAlignment(title.CENTER);
        title.setBounds(30,30,260,30);
        
        /*
            Campo de ingreso nombre
        */
        JLabel lblnombre = new JLabel("Nombre: ");
        lblnombre.setForeground(new Color(32, 17, 82));
        lblnombre.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0 , 15));
        lblnombre.setBounds(30,90,260,30);
        /*
        lblnombre.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(111,94,171)),
            BorderFactory.createEmptyBorder(0,8,0,8)
        ));
        */
        JTextField nombre = new JTextField();
        nombre.setBounds(30,120,260,30);
        
 
        /*
            Campo de ingreso carrera
        */
        JLabel lblcarrera = new JLabel("Carrera: ");
        lblcarrera.setForeground(new Color(32, 17, 82));
        lblcarrera.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0 , 15));
        lblcarrera.setBounds(30,170,260,30);
        
        JTextField carrera = new JTextField();
        carrera.setBounds(30,200,260,30);
        
       
        /*
            Boton de enviar
        */
       
        JButton enviar = new JButton();
        //enviar.setPreferredSize(new Dimension(140,150));
        enviar.setText("Enviar");
        enviar.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 15));
        enviar.setForeground(new Color(255, 255, 255));
        enviar.setBackground(new Color(111, 94, 171));
        enviar.setBorderPainted(false);
        enviar.setFocusPainted(false);
        enviar.setBounds(95,260,140,38);
       
        
        
        loginPanel.setOpaque(false);
        loginPanel.add(title);
        loginPanel.add(lblcarrera);
        loginPanel.add(lblnombre);
        loginPanel.add(carrera);
        loginPanel.add(nombre);
        loginPanel.add(enviar);
        loginPanel.setVisible(true);
        
        /*
            Segunda mitad (Imagen)
        */
       
        ImageIcon astrona = new ImageIcon(
                new ImageIcon(getClass().getResource("/sincelab/assets/icons/Astronauta.png"))
                .getImage().getScaledInstance(220, -1, Image.SCALE_SMOOTH)
        );
        
        ImageIcon Fondo = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/fondo.jfif")
        ); 
        
        JPanel fondo = new JPanel(new GridLayout(1,2)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        
        };
        setContentPane(fondo);
        
        JPanel loginPanel2 = new JPanel(null);
        loginPanel2.setOpaque(false);
        
        JLabel img = new JLabel(astrona);
        img.setBounds((320 - astrona.getIconWidth())/ 2, 15 , astrona.getIconWidth(), astrona.getIconHeight());
        loginPanel2.add(img);
       
        
        setIconImage(icon.getImage());
        setTitle("Nuevo Registro");
        setSize(640,420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        add(loginPanel, BorderLayout.WEST);
        add(loginPanel2);
        background();
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
}
