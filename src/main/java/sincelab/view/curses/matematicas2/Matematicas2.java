/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.view.curses.matematicas2;

/**
 *
 * @author Admin
 */
import java.awt.*;
import javax.swing.*;

import sincelab.view.Header;
import sincelab.view.PrincipalFont;
import sincelab.view.Themed;
import sincelab.view.Themes;

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
        
         JLabel titulo = new JLabel("Matematicas 2", JLabel.CENTER);
        titulo.setForeground(new Color(59, 130, 246));
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0, 30));
        titulo.setBounds(0, 95, 1280, 60);
 
        JButton derivada = new JButton();
        derivada.setText("Derivada");
        derivada.setBorderPainted(false);
        derivada.setFocusPainted(true);
        derivada.setContentAreaFilled(true);
        derivada.setBounds(390, 280, 110, 80);
 
        derivada.addActionListener(e -> {
            new Derivadas();
            dispose();
        });
        
        JButton integral = new JButton();
        integral.setText("Integrales");
        integral.setBorderPainted(false);
        integral.setFocusPainted(true);
        integral.setBounds(760, 280, 110, 80);
        
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
        setSize(1280, 720);
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
    
    
    

