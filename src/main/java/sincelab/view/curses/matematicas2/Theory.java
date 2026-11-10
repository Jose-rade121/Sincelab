package sincelab.view.curses.matematicas2;

import javax.swing.*;
import java.awt.*;
import sincelab.view.utilities.Header;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.Themes;
import sincelab.view.utilities.TheoryBlock;

/**
 *
 * @author josee
 */
public class Theory extends JFrame implements Themed{
    
    private Header header;
    public static Color backgroundColor;
    
    public void background(){    
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    PrincipalFont fontType = new PrincipalFont();
    
    public Theory(){
        
        
        String titulos[] = new String[]{
            "Derivadas: Definicion",
            "Derivadas: Reglas Basicas"
        };
        
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        String derDefinicion = 
                """
                <html><body>
                        La derivada de f en x mide qué tan rápido cambia f(x) cuando x cambia.<br><br>
                        <b>Definición:</b><br>
                        f'(x) = lim<sub>h-&gt;0</sub> [ f(x+h) - f(x) ] / h<br><br>
                        <b>Interpretación geométrica:</b> f'(a) es la pendiente de la recta tangente a la gráfica en el punto (a, f(a)).<br><br>
                        <b>Interpretación física:</b> si s(t) es la posición, s'(t) es la velocidad.<br><br>
                        <b>Notaciones:</b> f'(x), dy/dx, d/dx[f(x)].<br><br>
                        Si una función es derivable en un punto, también es continua allí. Lo contrario no siempre es cierto: |x| es continua en x = 0, pero no es derivable.
                </body></html>              
                """;
        
        
        String derReglasBas =
                """
                <html><body>
                        <b>Constante:</b> d/dx[c] = 0<br>
                        <b>Potencia:</b> d/dx[x<sup>n</sup>] = n &middot; x<sup>n-1</sup><br>
                        <b>Constante por función:</b> d/dx[c &middot; f(x)] = c &middot; f'(x)<br>
                        <b>Suma y resta:</b> d/dx[f(x) &plusmn; g(x)] = f'(x) &plusmn; g'(x)<br><br>
                        <b>Ejemplo:</b><br>
                        f(x) = 3x<sup>4</sup> - 5x<sup>2</sup> + 7<br>
                        f'(x) = 12x<sup>3</sup> - 10x
                </body></html>
                """;
        
        String contenidos[] = new String[]{
            derDefinicion,
            derReglasBas
        };
        
        
        
        add(new TheoryBlock("Derivadas", derDefinicion, 220,105,660,400));
        
        JButton Siguiente = new JButton();
        Siguiente.setBounds(740,520,140,38);
        Siguiente.setText("Siguiente");
        Siguiente.setBorderPainted(false);
        Siguiente.setFocusPainted(false);
        add(Siguiente);
        JButton Atras = new JButton();
        
        
        setLayout(new BorderLayout());
        setIconImage(icon.getImage());
        setTitle("SINCELAB - Teoria Matematicas 2");
        setSize(1100,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        background();
        header  = new Header(this, false);
        add(header, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
}
