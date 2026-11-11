package sincelab.view.curses.fisica1;

import java.awt.*;
import javax.swing.*;
import sincelab.view.curses.matematicas2.Matematicas2;
import sincelab.view.utilities.Header;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Themes;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.TheoryBlock;
import sincelab.view.windows.MainWindow;

/**
 *
 * @author josee
 */
public class Theoryf extends JFrame implements Themed{
    
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
    
    public Theoryf(){
        
        titulos = new String[]{
            "MRUA: conceptos y ecuaciones",
            "MRUA: ejemplos resueltos",
            "Segunda ley de Newton",
            "Caída libre: conceptos y ecuaciones",
            "Caída libre: ejemplos resueltos"
        };

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
         
        
        
        String cap1 = 
            """
            <html><body>
                    El <b>MRUA</b> (movimiento rectilíneo uniformemente acelerado) es el movimiento en línea recta con <b>aceleración constante</b>. También se le llama MUA.<br><br>
                    <b>Magnitudes:</b>
                    <ul>
                      <li>x<sub>0</sub>, x: posición inicial y final (m)</li>
                      <li>v<sub>0</sub>, v: velocidad inicial y final (m/s)</li>
                      <li>a: aceleración, constante (m/s<sup>2</sup>)</li>
                      <li>t: tiempo (s)</li>
                    </ul>
                    <b>Ecuaciones:</b><br>
                    1) v = v<sub>0</sub> + a &middot; t<br>
                    2) x = x<sub>0</sub> + v<sub>0</sub> &middot; t + (1/2) &middot; a &middot; t<sup>2</sup><br>
                    3) v<sup>2</sup> = v<sub>0</sub><sup>2</sup> + 2 &middot; a &middot; (x - x<sub>0</sub>)<br>
                    4) x - x<sub>0</sub> = [ (v<sub>0</sub> + v) / 2 ] &middot; t<br><br>
                    <b>Cómo elegir la ecuación:</b> usa la que no tenga la variable que no conoces ni necesitas. La 1 no tiene x, la 2 no tiene v, la 3 no tiene t y la 4 no tiene a.<br><br>
                    <b>Signos:</b> se escoge un sentido positivo. Si el cuerpo frena mientras avanza en sentido positivo, la aceleración es negativa.<br><br>
                    <b>Gráficas:</b>
                    <ul>
                      <li>v contra t: una recta cuya pendiente es la aceleración.</li>
                      <li>x contra t: una parábola.</li>
                      <li>a contra t: una recta horizontal.</li>
                      <li>El área bajo la gráfica de v contra t es el desplazamiento.</li>
                    </ul>
            </body></html>
            """;
        
        String cap2 = 
                """
                <html><body>
                        <b>Ejemplo 1:</b> un carro parte del reposo y acelera a 3 m/s<sup>2</sup> durante 5 s. ¿Qué velocidad alcanza y cuánto recorre?<br>
                        Datos: v<sub>0</sub> = 0, a = 3 m/s<sup>2</sup>, t = 5 s<br>
                        v = v<sub>0</sub> + a &middot; t = 0 + 3 &middot; 5 = <b>15 m/s</b><br>
                        x - x<sub>0</sub> = v<sub>0</sub> &middot; t + (1/2) &middot; a &middot; t<sup>2</sup> = (1/2) &middot; 3 &middot; 25 = <b>37.5 m</b><br><br>
                        <b>Ejemplo 2:</b> un auto va a 20 m/s y frena con a = -4 m/s<sup>2</sup>. ¿En cuánto tiempo se detiene y qué distancia recorre?<br>
                        Datos: v<sub>0</sub> = 20 m/s, v = 0, a = -4 m/s<sup>2</sup><br>
                        t = (v - v<sub>0</sub>) / a = (0 - 20) / (-4) = <b>5 s</b><br>
                        x - x<sub>0</sub> = (v<sup>2</sup> - v<sub>0</sub><sup>2</sup>) / (2a) = (0 - 400) / (-8) = <b>50 m</b><br><br>
                        <b>Ejemplo 3:</b> una moto pasa de 10 m/s a 30 m/s en 8 s. ¿Cuál es su aceleración y qué distancia recorre?<br>
                        a = (v - v<sub>0</sub>) / t = (30 - 10) / 8 = <b>2.5 m/s<sup>2</sup></b><br>
                        x - x<sub>0</sub> = [ (v<sub>0</sub> + v) / 2 ] &middot; t = 20 &middot; 8 = <b>160 m</b><br><br>
                        <b>Consejo:</b> escribe siempre los datos y la incógnita antes de elegir la ecuación, y revisa que las unidades sean del mismo sistema (m, s, m/s).
                </body></html>
                """;
        
        String cap3 =
                """
                <html><body>
                        <b>Segunda ley de Newton:</b> la aceleración de un cuerpo es proporcional a la fuerza neta que actúa sobre él e inversamente proporcional a su masa.<br><br>
                        <b>F<sub>neta</sub> = m &middot; a</b> &nbsp;&nbsp; o &nbsp;&nbsp; <b>a = F<sub>neta</sub> / m</b>
                        <ul>
                          <li>F<sub>neta</sub> es la suma vectorial de todas las fuerzas que actúan sobre el cuerpo (N).</li>
                          <li>La aceleración tiene la misma dirección y sentido que la fuerza neta.</li>
                          <li>Con la misma fuerza, a mayor masa, menor aceleración.</li>
                          <li>Si F<sub>neta</sub> = 0, la aceleración es 0: el cuerpo está en equilibrio (primera ley).</li>
                        </ul>
                        <b>Unidad:</b> 1 newton (N) = 1 kg &middot; m/s<sup>2</sup><br>
                        <b>Peso:</b> P = m &middot; g, con g = 9.8 m/s<sup>2</sup><br><br>
                        <b>Cómo resolver un problema:</b>
                        <ol>
                          <li>Dibuja el diagrama de cuerpo libre con todas las fuerzas.</li>
                          <li>Elige los ejes y el sentido positivo.</li>
                          <li>Suma las fuerzas de cada eje: F<sub>x</sub> = m &middot; a<sub>x</sub> y F<sub>y</sub> = m &middot; a<sub>y</sub>.</li>
                          <li>Despeja la incógnita.</li>
                        </ol>
                        <b>Ejemplo 1:</b> una caja de 10 kg se empuja con 50 N y la fricción es de 20 N.<br>
                        F<sub>neta</sub> = 50 - 20 = 30 N<br>
                        a = 30 / 10 = <b>3 m/s<sup>2</sup></b><br><br>
                        <b>Ejemplo 2:</b> un bloque de 5 kg cuelga de una cuerda y sube con a = 2 m/s<sup>2</sup>. ¿Cuál es la tensión?<br>
                        T - m &middot; g = m &middot; a<br>
                        T = m &middot; (g + a) = 5 &middot; (9.8 + 2) = <b>59 N</b>
                </body></html>
                """;
        
        String cap4 =
                """
                <html><body>
                        La <b>caída libre</b> es el movimiento vertical de un cuerpo que se mueve solo por la acción de la gravedad, sin resistencia del aire.
                        <ul>
                          <li>Es un MRUA con aceleración constante g = 9.8 m/s<sup>2</sup> (a veces se usa 9.81), dirigida hacia abajo.</li>
                          <li>Sin aire, todos los cuerpos caen con la misma aceleración, sin importar su masa.</li>
                          <li>Se aplica a cuerpos soltados, lanzados hacia arriba o lanzados hacia abajo.</li>
                        </ul>
                        <b>Signos:</b> con el eje y positivo hacia arriba, a = -g. Elige un sentido y mantenlo en todo el problema.<br><br>
                        <b>Ecuaciones</b> (eje y positivo hacia arriba):<br>
                        v = v<sub>0</sub> - g &middot; t<br>
                        y = y<sub>0</sub> + v<sub>0</sub> &middot; t - (1/2) &middot; g &middot; t<sup>2</sup><br>
                        v<sup>2</sup> = v<sub>0</sub><sup>2</sup> - 2 &middot; g &middot; (y - y<sub>0</sub>)<br><br>
                        <b>Si se suelta desde el reposo</b> (v<sub>0</sub> = 0, sentido positivo hacia abajo, h = altura recorrida):<br>
                        v = g &middot; t &nbsp;&nbsp; h = (1/2) &middot; g &middot; t<sup>2</sup> &nbsp;&nbsp; v = sqrt(2 &middot; g &middot; h)<br><br>
                        <b>Lanzamiento vertical hacia arriba:</b>
                        <ul>
                          <li>En el punto más alto, v = 0.</li>
                          <li>Tiempo de subida: t = v<sub>0</sub> / g</li>
                          <li>Altura máxima: h = v<sub>0</sub><sup>2</sup> / (2 &middot; g)</li>
                          <li>Tiempo total hasta volver al punto de lanzamiento: 2 &middot; v<sub>0</sub> / g</li>
                          <li>Al volver, la rapidez es igual a la inicial, pero hacia abajo.</li>
                        </ul>
                        <b>En la realidad:</b> el aire frena más a los objetos ligeros o con mucha superficie, como una hoja de papel. Por eso en el vacío una pluma y una piedra caen al mismo tiempo.
                </body></html>
                """;
        
        String cap5 =
                """
                <html><body>
                        Se usa g = 9.8 m/s<sup>2</sup>.<br><br>
                        <b>Ejemplo 1:</b> se suelta una piedra desde 45 m de altura. ¿Cuánto tarda en llegar al suelo y con qué velocidad llega?<br>
                        h = (1/2) &middot; g &middot; t<sup>2</sup> &nbsp;-&gt;&nbsp; t = sqrt(2h / g) = sqrt(90 / 9.8) = <b>3.03 s</b><br>
                        v = g &middot; t = 9.8 &middot; 3.03 = <b>29.7 m/s</b> hacia abajo<br><br>
                        <b>Ejemplo 2:</b> una pelota se lanza hacia arriba a 20 m/s. ¿Qué altura máxima alcanza y cuánto tarda en volver?<br>
                        Tiempo de subida: t = v<sub>0</sub> / g = 20 / 9.8 = <b>2.04 s</b><br>
                        Altura máxima: h = v<sub>0</sub><sup>2</sup> / (2 &middot; g) = 400 / 19.6 = <b>20.4 m</b><br>
                        Tiempo total: 2 &middot; 2.04 = <b>4.08 s</b><br><br>
                        <b>Ejemplo 3:</b> una pelota cae desde un edificio y tarda 2 s en llegar al suelo. ¿Qué altura tiene el edificio?<br>
                        h = (1/2) &middot; g &middot; t<sup>2</sup> = (1/2) &middot; 9.8 &middot; 4 = <b>19.6 m</b><br>
                        v = g &middot; t = 9.8 &middot; 2 = <b>19.6 m/s</b><br><br>
                        <b>Consejo:</b> en el lanzamiento hacia arriba, el signo de la velocidad cambia al pasar por el punto más alto. Define el sentido positivo desde el inicio y no lo cambies.
                </body></html>
                """;
        
        
        
        contenidos = new String[]{
            cap1,
            cap2,
            cap3,
            cap4,
            cap5
        };
        
        setLayout(new BorderLayout());
        /*Boton regreso*/
        JButton ret = new JButton("<-");
        ret.setBounds(380, 560, 60, 38);
        ret.setBackground(new Color(111, 94, 171));
        ret.setForeground(Color.WHITE);
        ret.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 14));
        ret.setFocusPainted(false);
        ret.addActionListener(e ->{
            new Fisica1();
            dispose();
        });
        
        
        
        Siguiente.setBounds(740,560,140,38);
        Siguiente.setBorderPainted(false);
        Siguiente.setFocusPainted(false);
        Siguiente.setForeground(new Color(255, 255, 255));
        Siguiente.setBackground(new Color(111, 94, 171));
        Siguiente.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 14));
        
        
        Siguiente.addActionListener(e -> mostrar(actual + 1));
        
        
        Atras.setBorderPainted(false);
        Atras.setFocusPainted(false);
        Atras.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 14));
        Atras.setForeground(new Color(255, 255, 255));
        Atras.setBackground(new Color(111, 94, 171));
        Atras.setBounds(220,560,140,38);
       
        
        Atras.addActionListener(e -> mostrar(actual - 1));
        
        
        
        setIconImage(icon.getImage());
        setTitle("SINCELAB - Teoria Fisica");
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
        
        JPanel pie = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        pie.setOpaque(false);
        pie.add(ret);
        pie.add(Atras);
        pie.add(Siguiente);
        add(pie, BorderLayout.SOUTH);
        
        mostrar(0);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
}
