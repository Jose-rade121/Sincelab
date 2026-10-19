/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.view.curses.algebralineal;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sincelab.view.Header;
import sincelab.view.Themed;
import sincelab.view.Themes;

/**
 *
 * @author josee
 */
public class Vectores extends JFrame implements Themed {
    
    private Header header;
    public static Color backgroundColor;
    
    public void background(){
        
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    public Vectores(){
        
        JPanel posiciones = new JPanel();
        
        
        
        JLabel v1 = new JLabel();
        v1.setText("V = ");
        v1.setBounds(180,200,40,20);
        
        // vector canonico i <x, 0 , 0>
        JTextField i = new JTextField();
        i.setBounds(200,200,20,20);
        
        // vector canonico j <0 , y, 0>
        JTextField j = new JTextField();
        j.setBounds(220,200,20,20);
        
        //Vector canonico k < 0 , 0, z>
        JTextField k = new JTextField();
        k.setBounds(240,200,20,20);
        
        posiciones.setLayout(null);
        posiciones.add(i);      
        posiciones.add(j);
        posiciones.add(k);
        posiciones.add(v1);
        add(posiciones);
        
        //Especificaciones del Header
        
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        setIconImage(icon.getImage());
        setTitle("VECTORES"); //Le da un titulo.
        setSize(1280,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
          
        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        background();
        setLocationRelativeTo(null); 
        setVisible(true);
        
    }
    
}
