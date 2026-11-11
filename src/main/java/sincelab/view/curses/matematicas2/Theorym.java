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
public class Theorym extends JFrame implements Themed{
    
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
    
    public Theorym(){

        /* Derivadas */
        
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
        
        String derProdyCos = 
                """
                 <html><body>
                        <b>Producto:</b> (f &middot; g)' = f' &middot; g + f &middot; g'<br>
                        <b>Cociente:</b> (f / g)' = (f' &middot; g - f &middot; g') / g<sup>2</sup>, con g distinta de 0<br><br>
                        <b>Ejemplo (producto):</b><br>
                        d/dx[x<sup>2</sup> &middot; sen(x)] = 2x &middot; sen(x) + x<sup>2</sup> &middot; cos(x)<br><br>
                        <b>Ejemplo (cociente):</b><br>
                        d/dx[ x / (x+1) ] = [ 1 &middot; (x+1) - x &middot; 1 ] / (x+1)<sup>2</sup> = 1 / (x+1)<sup>2</sup>
                </body></html>
                """;
        
        String derReCadena =
                """
                <html><body>
                        Para una función compuesta f(g(x)):<br>
                        <b>d/dx[ f(g(x)) ] = f'(g(x)) &middot; g'(x)</b><br><br>
                        En palabras: se deriva la función de afuera dejando el interior igual, y se multiplica por la derivada del interior.<br><br>
                        <b>Ejemplos:</b><br>
                        d/dx[ (3x+2)<sup>5</sup> ] = 5(3x+2)<sup>4</sup> &middot; 3 = 15(3x+2)<sup>4</sup><br>
                        d/dx[ sen(x<sup>2</sup>) ] = cos(x<sup>2</sup>) &middot; 2x<br>
                        d/dx[ e<sup>5x</sup> ] = 5 &middot; e<sup>5x</sup>
                </body></html>
                """;
        
        String derFunciComunes =
                """
                <html><body>
                        d/dx[ sen x ] = cos x<br>
                        d/dx[ cos x ] = -sen x<br>
                        d/dx[ tan x ] = sec<sup>2</sup> x<br>
                        d/dx[ e<sup>x</sup> ] = e<sup>x</sup><br>
                        d/dx[ a<sup>x</sup> ] = a<sup>x</sup> &middot; ln(a)<br>
                        d/dx[ ln x ] = 1 / x<br>
                        d/dx[ log<sub>a</sub> x ] = 1 / (x &middot; ln a)<br>
                        d/dx[ sqrt(x) ] = 1 / (2 &middot; sqrt(x))<br><br>
                        Los ángulos de las funciones trigonométricas van en radianes.
                </body></html>
                """;
        
        String derAplica =
                """
                <html><body>
                        <b>Recta tangente en x = a:</b><br>
                        y - f(a) = f'(a) &middot; (x - a)<br><br>
                        <b>Crecimiento:</b> si f'(x) &gt; 0 la función crece; si f'(x) &lt; 0 decrece.<br><br>
                        <b>Puntos críticos:</b> donde f'(x) = 0 o f'(x) no existe.<br><br>
                        <b>Criterio de la segunda derivada</b> (si f'(c) = 0):
                        <ul>
                          <li>f''(c) &gt; 0: mínimo local</li>
                          <li>f''(c) &lt; 0: máximo local</li>
                          <li>f''(c) = 0: el criterio no decide</li>
                        </ul>
                        <b>Concavidad:</b> f'' &gt; 0 es cóncava hacia arriba; f'' &lt; 0 es cóncava hacia abajo.<br><br>
                        <b>Ejemplo:</b> f(x) = x<sup>2</sup> - 4x + 3<br>
                        f'(x) = 2x - 4 = 0 &nbsp;-&gt;&nbsp; x = 2<br>
                        f''(x) = 2 &gt; 0 &nbsp;-&gt;&nbsp; mínimo en x = 2, con f(2) = -1
                </body></html>
                """;
        
        
        /* Integrales */
        
        
        String itDef =
                """
                <html><body>
                        La integral indefinida es la operación inversa de la derivada: busca una antiderivada F tal que F'(x) = f(x).<br><br>
                        <b>Notación:</b><br>
                        ∫ f(x) dx = F(x) + C<br><br>
                        C es la constante de integración: F(x) y F(x) + C tienen la misma derivada.<br><br>
                        <b>Ejemplo:</b><br>
                        ∫ 2x dx = x<sup>2</sup> + C, porque d/dx[x<sup>2</sup> + C] = 2x<br><br>
                        Siempre puedes comprobar tu resultado derivándolo.
                </body></html>
                """;
        
        String itInmed =
                """
                <html><body>
                        ∫ k dx = kx + C<br>
                        ∫ x<sup>n</sup> dx = x<sup>n+1</sup> / (n+1) + C, con n distinto de -1<br>
                        ∫ 1/x dx = ln|x| + C<br>
                        ∫ e<sup>x</sup> dx = e<sup>x</sup> + C<br>
                        ∫ a<sup>x</sup> dx = a<sup>x</sup> / ln(a) + C<br>
                        ∫ sen x dx = -cos x + C<br>
                        ∫ cos x dx = sen x + C<br>
                        ∫ sec<sup>2</sup> x dx = tan x + C<br><br>
                        <b>Linealidad:</b><br>
                        ∫ [ a &middot; f(x) + b &middot; g(x) ] dx = a &middot; ∫ f(x) dx + b &middot; ∫ g(x) dx<br><br>
                        <b>Ejemplo:</b><br>
                        ∫ (3x<sup>2</sup> + 4x - 1) dx = x<sup>3</sup> + 2x<sup>2</sup> - x + C
                        </body></html>
                
                """;
        
        String itSusti =
                """
                <html><body>
                        Sirve cuando en la integral aparece una función y su derivada (es la regla de la cadena al revés).<br><br>
                        <b>Pasos:</b>
                        <ol>
                          <li>Elegir u = g(x), normalmente lo que está adentro.</li>
                          <li>Calcular du = g'(x) dx.</li>
                          <li>Reescribir la integral en términos de u e integrar.</li>
                          <li>Volver a escribir el resultado en x.</li>
                        </ol>
                        <b>Ejemplo 1:</b><br>
                        ∫ 2x (x<sup>2</sup> + 1)<sup>3</sup> dx<br>
                        u = x<sup>2</sup> + 1, &nbsp;du = 2x dx<br>
                        ∫ u<sup>3</sup> du = u<sup>4</sup> / 4 + C = (x<sup>2</sup> + 1)<sup>4</sup> / 4 + C<br><br>
                        <b>Ejemplo 2:</b><br>
                        ∫ cos(3x) dx<br>
                        u = 3x, &nbsp;du = 3 dx<br>
                        (1/3) ∫ cos u du = (1/3) sen(3x) + C
                </body></html>
                """;
        
        String itPartes =
            """
                <html><body>        
                        <b>Fórmula</b> (viene de la regla del producto):<br>
                        ∫ u dv = u &middot; v - ∫ v du<br><br>
                        <b>Cómo elegir u (regla LIATE):</b> se toma como u la primera que aparezca en este orden:<br>
                        Logarítmicas, Inversas trigonométricas, Algebraicas, Trigonométricas, Exponenciales.<br><br>
                        <b>Ejemplo 1:</b><br>
                        ∫ x &middot; e<sup>x</sup> dx<br>
                        u = x, &nbsp;dv = e<sup>x</sup> dx &nbsp;-&gt;&nbsp; du = dx, &nbsp;v = e<sup>x</sup><br>
                        = x &middot; e<sup>x</sup> - ∫ e<sup>x</sup> dx = x &middot; e<sup>x</sup> - e<sup>x</sup> + C = e<sup>x</sup> (x - 1) + C<br><br>
                        <b>Ejemplo 2:</b><br>
                        ∫ ln x dx<br>
                        u = ln x, &nbsp;dv = dx &nbsp;-&gt;&nbsp; du = dx / x, &nbsp;v = x<br>
                        = x &middot; ln x - ∫ 1 dx = x &middot; ln x - x + C
                </body></html>
            """;  
        
        String itDef_tfc =
                """
                <html><body>
                        La integral definida de a hasta b se escribe:<br>
                        ∫<sub>a</sub><sup>b</sup> f(x) dx<br><br>
                        Representa el área neta entre la gráfica de f y el eje x. El área que queda debajo del eje cuenta como negativa.<br><br>
                        <b>Teorema fundamental del cálculo:</b>
                        <ul>
                          <li>Parte 1: d/dx [ ∫<sub>a</sub><sup>x</sup> f(t) dt ] = f(x)</li>
                          <li>Parte 2: si F'(x) = f(x), entonces ∫<sub>a</sub><sup>b</sup> f(x) dx = F(b) - F(a)</li>
                        </ul>
                        <b>Ejemplo:</b><br>
                        ∫<sub>1</sub><sup>3</sup> 2x dx = [ x<sup>2</sup> ] de 1 a 3 = 9 - 1 = 8<br><br>
                        <b>Propiedades:</b><br>
                        ∫<sub>a</sub><sup>a</sup> f(x) dx = 0<br>
                        ∫<sub>a</sub><sup>b</sup> f(x) dx = -∫<sub>b</sub><sup>a</sup> f(x) dx<br>
                        ∫<sub>a</sub><sup>b</sup> f(x) dx + ∫<sub>b</sub><sup>c</sup> f(x) dx = ∫<sub>a</sub><sup>c</sup> f(x) dx
                </body></html>
                """;
        
        String itAplicacio =
                """
                <html><body>
                        <b>Área bajo la curva</b> (si f(x) &gt;= 0 en [a, b]):<br>
                        A = ∫<sub>a</sub><sup>b</sup> f(x) dx<br><br>
                        <b>Área entre dos curvas</b> (si f(x) &gt;= g(x) en [a, b]):<br>
                        A = ∫<sub>a</sub><sup>b</sup> [ f(x) - g(x) ] dx<br><br>
                        <b>Ejemplo 1:</b> área bajo y = x<sup>2</sup> entre 0 y 3<br>
                        ∫<sub>0</sub><sup>3</sup> x<sup>2</sup> dx = [ x<sup>3</sup> / 3 ] de 0 a 3 = 9<br><br>
                        <b>Ejemplo 2:</b> área entre y = x y y = x<sup>2</sup>, entre 0 y 1<br>
                        ∫<sub>0</sub><sup>1</sup> (x - x<sup>2</sup>) dx = 1/2 - 1/3 = 1/6<br><br>
                        Si la función cambia de signo, se divide la integral en cada tramo y se suman los valores absolutos para obtener el área total.<br><br>
                        <b>Volumen de un sólido de revolución</b> (discos, giro alrededor del eje x):<br>
                        V = pi &middot; ∫<sub>a</sub><sup>b</sup> [ f(x) ]<sup>2</sup> dx<br><br>
                        Otras aplicaciones: desplazamiento a partir de la velocidad, trabajo, valor promedio de una función.
                </body></html>
                """;
        
        titulos = new String[]{
            "Derivadas: Definicion",
            "Derivadas: Reglas Basicas",
            "Derivadas: producto y cociente",
            "Derivadas: regla de la cadena",
            "Derivadas: funciones comunes",
            "Derivadas: aplicaciones",
            "Integrales: integral indefinida",
            "Integrales: integrales inmediatas",
            "Integrales: sustitución",
            "Integrales: integración por partes",
            "Integrales: integral definida y TFC",
            "Integrales: aplicaciones"
        };
        
        
        
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        
        
        contenidos = new String[]{
            derDefinicion,
            derReglasBas,
            derProdyCos,
            derReCadena,
            derFunciComunes,
            derAplica,
            itDef,
            itInmed,
            itSusti,
            itPartes,
            itDef_tfc,
            itAplicacio
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
        
        setLayout(new BorderLayout());
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
        setTitle("SINCELAB - Teoria Matematicas 2");
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
