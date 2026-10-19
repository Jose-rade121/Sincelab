package sincelab.view.curses.algebralineal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import sincelab.view.Header;
import sincelab.view.PrincipalFont;
import sincelab.view.Themed;
import sincelab.view.Themes;

/**
 *
 * @author josee
 */
public class AlgLineal extends JFrame implements Themed{
    
    private Header header;
    public static Color backgroundColor;
    
    public void background(){
        
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    public AlgLineal(){
        
        
        PrincipalFont fontType = new PrincipalFont();

        JPanel zona = new JPanel();
        
   
        JLabel titulo = new JLabel();
        titulo.setText("Algebra Lineal");
        titulo.setForeground(new Color(59,130,246));
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0 ,30));
        titulo.setBounds(500,95,880,180);

        
        JButton matriz = new JButton();
        matriz.setText("Matrices");
        matriz.setBorderPainted(false);
        matriz.setFocusPainted(true);
        matriz.setContentAreaFilled(true);
        matriz.setBounds(390,280,110,80);
        
        matriz.addActionListener(e -> {
            new Matrices();
            dispose();
        });
        
        JButton vectores = new JButton();
        vectores.setText("Vectores");
        vectores.setBorderPainted(false);
        vectores.setFocusPainted(true);
        vectores.setContentAreaFilled(true);
        vectores.setBounds(760,280,110,80);
        
        vectores.addActionListener(e -> {
            new Vectores();
            dispose();
        });
        
        zona.setLayout(null);
        zona.add(vectores);
        zona.add(matriz);
        zona.add(titulo);
        

        //Disposiciones de la ventana

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        setIconImage(icon.getImage());
        setTitle("ALGEBRA LINEAL"); //Le da un titulo.
        setSize(1280,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
          
        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        add(zona);
        //setLayout(new BorderLayout());
        background();
        setLocationRelativeTo(null); 
        setVisible(true);
        
    }
    
}
