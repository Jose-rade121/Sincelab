package sincelab.view.curses.humanidades;

import java.awt.*;
import javax.swing.*;
import sincelab.view.curses.matematicas2.Matematicas2;
import sincelab.view.utilities.Header;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Themes;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.TheoryBlock;

/**
 *
 * @author josee
 */
public class humanidadest extends JFrame implements Themed{
    
    private Header header;
    private TheoryBlock bloque;
    private String[] titulos;
    private String[] contenidos;
    private int actual = 0;
    private final JPanel centro = new JPanel(new BorderLayout());
    public static Color backgroundColor;
    private final JButton Atras = new JButton("Atras");
    private final JButton Siguiente = new JButton("Siguiente");
    
    public void background(){    
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    
    
    public void mostrar(int i){
        if(i < 0 || i >= titulos.length) return;
        actual = i;
        
        
        centro.removeAll();
        centro.add(new TheoryBlock(titulos[i], contenidos[i], 0,0,100,100),
                BorderLayout.CENTER);
        centro.revalidate();
        centro.repaint();
        
        //bloque.actualizar(titulos[i], contenidos[i]);
        Atras.setEnabled(i > 0);
        Siguiente.setEnabled(i < titulos.length - 1);
    }
    
    PrincipalFont fontType = new PrincipalFont();
    
    public humanidadest(){
        
        titulos = new String[]{
            
        };
        
        
        
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        
        
        contenidos = new String[]{
            
        };
        
        /*Boton regreso*/
        JButton ret = new JButton("<-");
        ret.setBounds(380, 560, 60, 38);
        ret.setBackground(new Color(111, 94, 171));
        ret.setForeground(Color.WHITE);
        ret.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 14));
        ret.setFocusPainted(false);
        ret.addActionListener(e ->{
            new Matematicas2();
            dispose();
        });
        add(ret);
        
        
        Siguiente.setBounds(740,560,140,38);
        Siguiente.setBorderPainted(false);
        Siguiente.setFocusPainted(false);
        Siguiente.setForeground(new Color(255, 255, 255));
        Siguiente.setBackground(new Color(111, 94, 171));
        Siguiente.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 14));
        add(Siguiente);
        
        Siguiente.addActionListener(e -> mostrar(actual + 1));
        
        
        Atras.setBorderPainted(false);
        Atras.setFocusPainted(false);
        Atras.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 14));
        Atras.setForeground(new Color(255, 255, 255));
        Atras.setBackground(new Color(111, 94, 171));
        Atras.setBounds(220,560,140,38);
        add(Atras);
        
        Atras.addActionListener(e -> mostrar(actual - 1));
        
        
        setLayout(new BorderLayout());
        setIconImage(icon.getImage());
        setTitle("HUMANIDADES");
        setSize(1100,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        background();
        header  = new Header(this, false);
        add(header, BorderLayout.NORTH);
   
        bloque = new TheoryBlock(titulos[0], contenidos[0], 0,0,100,100);
        centro.add(bloque, BorderLayout.CENTER);
        centro.setOpaque(false);
        centro.setBorder(BorderFactory.createEmptyBorder(20,40,10,40));
        add(centro, BorderLayout.CENTER);
        
        
        mostrar(0);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
}
