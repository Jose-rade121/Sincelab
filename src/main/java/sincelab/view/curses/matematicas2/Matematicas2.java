package sincelab.view.curses.matematicas2;

/**
 *
 * @author Angel
 */
import java.awt.*;
import javax.swing.*;

import sincelab.view.utilities.Header;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.Themes;

public class Matematicas2 extends JFrame implements Themed{
    
    private Header header;
    
    public void background(){
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    public Matematicas2(){
        PrincipalFont fontType = new PrincipalFont();
        
        JPanel zona = new JPanel();
        
        JLabel titulo = new JLabel();
        titulo.setText("Matematicas 2");
        titulo.setForeground(new Color(59,130,246));
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0 ,30));
        titulo.setBounds(0,110,500,50);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        
        
        JButton derivada = new JButton();
        derivada.setText("Derivada");
        derivada.setBorderPainted(false);
        derivada.setFocusPainted(false);
        derivada.setContentAreaFilled(true);
        derivada.setBackground(new Color(59,130,246));
        derivada.setForeground(new Color(255,255,255));
        derivada.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 15));
        derivada.setBounds(95,200,130,80);
 
        derivada.addActionListener(e -> {
            new Derivadas();
            dispose();
        });
        
        JButton integral = new JButton();
        integral.setText("Integrales");
        integral.setBorderPainted(false);
        integral.setFocusPainted(false);
        integral.setContentAreaFilled(true);
        integral.setBackground(new Color(59,130,246));
        integral.setForeground(new Color(255,255,255));
        integral.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 15));
        integral.setBounds(262,200,130,80);
        
        integral.addActionListener(e -> {
            
            new Integrales();
            dispose();
        });
        
        zona.setLayout(null);
        zona.add(derivada);
        zona.add(integral);
        zona.add(titulo);
        
        ImageIcon icon = new ImageIcon(
            getClass().getResource("/sincelab/assets/icons/icon.png")
        );
 
        setIconImage(icon.getImage());
        setTitle("MATEMATICAS 2");
        setSize(500,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
 
        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        add(zona);
        background();
        setLocationRelativeTo(null);
        setVisible(true);
    }
        
 }
    
    
    

