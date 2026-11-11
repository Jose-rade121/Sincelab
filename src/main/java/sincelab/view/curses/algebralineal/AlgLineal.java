package sincelab.view.curses.algebralineal;

import java.awt.*;
import javax.swing.*;

import sincelab.storage.BancoPreguntas;
import sincelab.view.windows.Quizwindow;
import sincelab.view.utilities.Header;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.Themes;

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
        titulo.setBounds(0,110,500,50);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        
        JButton matriz = new JButton();
        matriz.setText("Matrices");
        matriz.setFocusPainted(false);
        matriz.setBorderPainted(false);
        matriz.setBackground(new Color(59,130,246));
        matriz.setForeground(new Color(255,255,255));
        matriz.setContentAreaFilled(true);
        matriz.setBounds(95,200,130,80);
        matriz.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 15));
        
        matriz.addActionListener(e -> {
            new Matrices();
            dispose();
        });
        
        JButton vectores = new JButton();
        vectores.setText("Vectores");
        vectores.setBorderPainted(false);
        vectores.setFocusPainted(false);
        vectores.setBackground(new Color(59,130,246));
        vectores.setForeground(new Color(255,255,255));
        vectores.setBounds(262,200,130,80);
        vectores.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 15));
        
        vectores.addActionListener(e -> {
            new Vectores();
            dispose();
        });
        
        JButton teoria = new JButton(); // En esta parte del codigo, podremos ver todo aplicado anteriormente en TeoriaAlg
        teoria.setText("Teoria");
        teoria.setBorderPainted(false);
        teoria.setFocusPainted(false);
        teoria.setBackground(new Color(59,130,246));
        teoria.setForeground(new Color(255,255,255));
        teoria.setBounds(178,300,130,80);
        teoria.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 15));
        
        teoria.addActionListener(e -> {
            new TeoriaAlg();
            dispose();
        });
        
         JButton quiz = new JButton();
        quiz.setText("Quiz");
        quiz.setBorderPainted(false);
        quiz.setFocusPainted(false);
        quiz.setContentAreaFilled(true);
        quiz.setBackground(new Color(59,130,246));
        quiz.setForeground(new Color(255,255,255));
        quiz.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 15));
        quiz.setBounds(178,410,130,80);
 
        quiz.addActionListener(e -> Quizwindow.abrir(
                this, "Algebra Lineal", BancoPreguntas.algebraLineal(), AlgLineal::new));
        
        zona.setLayout(null);
        zona.add(quiz);
        zona.add(vectores);
        zona.add(matriz);
        zona.add(teoria);
        zona.add(titulo);
        

        //Disposiciones de la ventana

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        setIconImage(icon.getImage());
        setTitle("ALGEBRA LINEAL"); //Le da un titulo.
        setSize(500,720);  // Genera el tamaño.
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
