package sincelab.view.windows;



import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.util.HashSet;
import java.util.Set;
import sincelab.view.Header;
import sincelab.view.Themed;
import sincelab.view.Themes;
import sincelab.view.PrincipalFont;
import sincelab.view.curses.algebralineal.AlgLineal;




//import java.awt.Graphics2D; -> pa luego.



/**
 *  
 *
 * 
 *
 * @author josee
 */

public final class MainWindow extends JFrame implements Themed{

    private Header header;
    public static Color backgroundColor;
    
    public void background(){    
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
            
    
    public MainWindow() {  
        
        
   
        PrincipalFont fontType = new PrincipalFont();
 
        /*Icono*/
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        
        /*Texto debajo del header*/
        
        JPanel programas = new JPanel(
            new FlowLayout(FlowLayout.LEFT,15,10)
        );
        
        
        JLabel program = new JLabel();
        program.setText("Programas");
        program.setForeground(Color.BLACK);
        program.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 14));
        
        programas.setOpaque(false);
        programas.add(program);

        
        /*Rectangulos de las Unidades*/

        JPanel matematicas1 = new JPanel();
        //matematicas1.setPreferredSize(new Dimension(350,250));
        matematicas1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        matematicas1.setBounds(40,105,310,255);
        matematicas1.setLayout(null);
        
        JLabel mat = new JLabel();
        mat.setText("Matematicas 2");
        mat.setBounds(15,25,300,20);
        mat.setFont(fontType.getFont(fontType.BESTIME, 0, 20));    
        matematicas1.add(mat);
        

        JPanel fisica1 = new JPanel();
        fisica1.setPreferredSize(new Dimension(350,250));
        //matematicas1.setPreferredSize(new Dimension(350,250));
        fisica1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        fisica1.setBounds(40,400,310,255);
        fisica1.setLayout(null);
        
        JLabel fis = new JLabel();
        fis.setText("Fisica 1");
        fis.setBounds(15,25,300,20);
        fis.setFont(fontType.getFont(fontType.BESTIME, 0, 20));    
        fisica1.add(fis);
        
        JPanel humanidades = new JPanel();
        //humanidades.setPreferredSize(new Dimension(350,250));
        humanidades.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        humanidades.setBounds(400,105,310,255);
        humanidades.setLayout(null);
        
        JLabel hum = new JLabel();
        hum.setText("Humanidades");
        hum.setBounds(15,25,300,20);
        hum.setFont(fontType.getFont(fontType.BESTIME, 0, 20));    
        humanidades.add(hum);
        
        
        
        JPanel algLineal = new JPanel();
        //algLineal.setPreferredSize(new Dimension(350,250));
        algLineal.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        algLineal.setBounds(400,400,310,255);
        algLineal.setLayout(null);
 
        JLabel algl = new JLabel();
        algl.setText("Algebra Lineal");
        algl.setBounds(15,25,300,20);
        algl.setFont(fontType.getFont(fontType.BESTIME, 0, 20));    
        algLineal.add(algl);
        
        JButton alg = new JButton();
        alg.setText("Iniciar");
        alg.setBorderPainted(false);
        alg.setFocusPainted(false);
        alg.setForeground(new Color(255, 255, 255));
        alg.setBackground(new Color(111, 94, 171));
        alg.setBounds(15,300,140,38);
        algLineal.add(alg);
        
        alg.addActionListener(e ->{
            new AlgLineal();
            dispose();
        });
        
        
        JPanel puntuaciones = new JPanel();
        puntuaciones.setPreferredSize(new Dimension(350,250));
        
        
        //Relacionadas a la ventana:
        
        setIconImage(icon.getImage());
        setTitle("SINCELAB");   //Le da un titulo.
        setSize(1100,720);      // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
          
        add(matematicas1);
        add(fisica1);
        add(humanidades);
        add(algLineal);

        header  = new Header(this, false);
        add(header, BorderLayout.NORTH);
        add(programas);
        background();
        setLocationRelativeTo(null); //La centra en la pantalla
        setVisible(true); //Muestra la ventana.   
  
    }
}
