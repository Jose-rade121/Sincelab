/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.view.curses.algebralineal;

import javax.swing.*;
import java.awt.*;
import sincelab.view.utilities.Header;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.Themes;
import sincelab.view.utilities.TheoryBlock;
/**
 * 
 *
 * @author Angel 
 */
  public class TeoriaAlg extends JFrame implements Themed{
    
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
        
        Atras.setEnabled(i > 0);
        Siguiente.setEnabled(i < titulos.length - 1);
    }
    
    
    
    
    PrincipalFont fontType = new PrincipalFont();
    
    public TeoriaAlg(){
 
        /* Matrices */
        
        String matDef = 
                """
                <html><body>
                        Una matriz es una tabla de números ordenados en m filas y n columnas. Se dice que es de tamaño m x n.<br><br>
                        <b>Notación:</b> A = [a<sub>ij</sub>], donde a<sub>ij</sub> está en la fila i y en la columna j.<br><br>
                        <b>Ejemplo (2 x 3):</b><br>
                        A = [ 1 &nbsp; 2 &nbsp; 3 ; &nbsp; 4 &nbsp; 5 &nbsp; 6 ] &nbsp; (las filas se separan con punto y coma)<br>
                        Aquí a<sub>12</sub> = 2 y a<sub>23</sub> = 6.<br><br>
                        <b>Tipos importantes:</b>
                        <ul>
                          <li><b>Cuadrada:</b> igual número de filas y columnas (n x n). Solo ella tiene determinante e inversa.</li>
                          <li><b>Identidad (I):</b> cuadrada con 1 en la diagonal y 0 en el resto.</li>
                          <li><b>Diagonal:</b> solo tiene valores distintos de 0 en la diagonal.</li>
                          <li><b>Nula:</b> todos sus elementos son 0.</li>
                          <li><b>Triangular:</b> tiene ceros debajo (o encima) de la diagonal.</li>
                        </ul>
                </body></html>
                """;
        
        String matOper =
                """
                <html><body>
                        <b>Suma y resta:</b> solo entre matrices del mismo tamaño, elemento a elemento.<br>
                        <b>Por un escalar:</b> se multiplica cada elemento por el número.<br>
                        <b>Transpuesta A<sup>T</sup>:</b> las filas pasan a ser columnas.<br><br>
                        <b>Producto A &middot; B:</b> se puede hacer si las columnas de A son iguales a las filas de B.
                        Si A es m x n y B es n x p, el resultado es m x p.<br>
                        c<sub>ij</sub> = (fila i de A) por (columna j de B), sumando los productos.<br><br>
                        <b>Ejemplo:</b> A = [ 1 &nbsp; 2 ; &nbsp; 3 &nbsp; 4 ] y B = [ 0 &nbsp; 1 ; &nbsp; 1 &nbsp; 0 ]<br>
                        A + B = [ 1 &nbsp; 3 ; &nbsp; 4 &nbsp; 4 ]<br>
                        2A = [ 2 &nbsp; 4 ; &nbsp; 6 &nbsp; 8 ]<br>
                        A &middot; B = [ 2 &nbsp; 1 ; &nbsp; 4 &nbsp; 3 ]<br>
                        B &middot; A = [ 3 &nbsp; 4 ; &nbsp; 1 &nbsp; 2 ]<br><br>
                        El producto de matrices <b>no es conmutativo</b>: en general A &middot; B es distinto de B &middot; A.
                </body></html>
                """;
        
        String matDet = 
                """
                <html><body>
                        La determinante es un número que se calcula a partir de una matriz cuadrada. Se escribe det(A) o |A|.<br><br>
                        <b>Matriz 2 x 2:</b><br>
                        det [ a &nbsp; b ; &nbsp; c &nbsp; d ] = a &middot; d - b &middot; c<br>
                        Ejemplo: det [ 1 &nbsp; 2 ; &nbsp; 3 &nbsp; 4 ] = 1 &middot; 4 - 2 &middot; 3 = -2<br><br>
                        <b>Matriz 3 x 3 (por cofactores, primera fila):</b><br>
                        det(A) = a<sub>11</sub>(a<sub>22</sub>a<sub>33</sub> - a<sub>23</sub>a<sub>32</sub>) - a<sub>12</sub>(a<sub>21</sub>a<sub>33</sub> - a<sub>23</sub>a<sub>31</sub>) + a<sub>13</sub>(a<sub>21</sub>a<sub>32</sub> - a<sub>22</sub>a<sub>31</sub>)<br>
                        Ejemplo: A = [ 1 &nbsp; 2 &nbsp; 3 ; &nbsp; 0 &nbsp; 1 &nbsp; 4 ; &nbsp; 5 &nbsp; 6 &nbsp; 0 ]<br>
                        det(A) = 1(0 - 24) - 2(0 - 20) + 3(0 - 5) = -24 + 40 - 15 = 1<br><br>
                        <b>Propiedades:</b>
                        <ul>
                          <li>Si det(A) = 0, la matriz es singular y no tiene inversa.</li>
                          <li>Si se intercambian dos filas, la determinante cambia de signo.</li>
                          <li>En una matriz triangular, es el producto de la diagonal.</li>
                          <li>det(A &middot; B) = det(A) &middot; det(B) y det(A<sup>T</sup>) = det(A).</li>
                        </ul>
                </body></html>
                """;
        
        String matInv =
                """
                <html><body>
                        La inversa de una matriz cuadrada A es la matriz A<sup>-1</sup> que cumple:<br>
                        <b>A &middot; A<sup>-1</sup> = A<sup>-1</sup> &middot; A = I</b><br><br>
                        Solo existe si det(A) es distinta de 0.<br><br>
                        <b>Matriz 2 x 2:</b><br>
                        A<sup>-1</sup> = 1 / (a &middot; d - b &middot; c) &middot; [ d &nbsp; -b ; &nbsp; -c &nbsp; a ]<br><br>
                        <b>Ejemplo:</b> A = [ 1 &nbsp; 2 ; &nbsp; 3 &nbsp; 4 ], det(A) = -2<br>
                        A<sup>-1</sup> = (1 / -2) &middot; [ 4 &nbsp; -2 ; &nbsp; -3 &nbsp; 1 ] = [ -2 &nbsp; 1 ; &nbsp; 1.5 &nbsp; -0.5 ]<br><br>
                        <b>Método de Gauss-Jordan (cualquier tamaño):</b>
                        <ol>
                          <li>Escribir la matriz ampliada [ A | I ].</li>
                          <li>Hacer operaciones entre filas hasta obtener [ I | A<sup>-1</sup> ].</li>
                          <li>Si en el proceso aparece una fila de ceros, no hay inversa.</li>
                        </ol>
                        <b>Aplicación:</b> en el sistema A &middot; X = B, la solución es X = A<sup>-1</sup> &middot; B.
                </body></html>
                """;
        
        /* Vectores */
        
        String vecDef =
                """
                <html><body>
                        Un vector en 3D se escribe v = (x, y, z). Se puede ver como una flecha con <b>magnitud</b> y <b>dirección</b>.<br><br>
                        <b>Magnitud:</b> |v| = sqrt(x<sup>2</sup> + y<sup>2</sup> + z<sup>2</sup>)<br>
                        <b>Vector unitario:</b> v / |v|, tiene magnitud 1 y la misma dirección.<br><br>
                        <b>Operaciones:</b>
                        <ul>
                          <li>Suma: (a, b, c) + (d, e, f) = (a+d, b+e, c+f)</li>
                          <li>Resta: se restan las componentes una a una.</li>
                          <li>Por un escalar: k &middot; (x, y, z) = (kx, ky, kz)</li>
                        </ul>
                        <b>Ejemplo:</b> v = (2, 3, 6)<br>
                        |v| = sqrt(4 + 9 + 36) = sqrt(49) = 7<br>
                        Vector unitario = (2/7, 3/7, 6/7)
                </body></html>
                """;
        
        String vecPunto =
                """
                <html><body>
                        <b>Producto punto</b> (el resultado es un número):<br>
                        u &middot; v = u<sub>1</sub>v<sub>1</sub> + u<sub>2</sub>v<sub>2</sub> + u<sub>3</sub>v<sub>3</sub><br><br>
                        También se cumple: u &middot; v = |u| &middot; |v| &middot; cos(theta), con theta el ángulo entre los vectores.<br><br>
                        <b>Ejemplo:</b><br>
                        (1, 2, 3) &middot; (4, -5, 6) = 4 - 10 + 18 = 12<br><br>
                        <b>Qué dice el resultado:</b>
                        <ul>
                          <li>u &middot; v = 0: los vectores son perpendiculares (ortogonales).</li>
                          <li>u &middot; v &gt; 0: el ángulo es agudo (menor de 90 grados).</li>
                          <li>u &middot; v &lt; 0: el ángulo es obtuso (mayor de 90 grados).</li>
                        </ul>
                        Además, u &middot; u = |u|<sup>2</sup>.
                </body></html>
                """;
        
        String vecAngulo =
                """
                <html><body>
                        Despejando theta del producto punto se obtiene el ángulo entre dos vectores:<br><br>
                        <b>cos(theta) = (u &middot; v) / ( |u| &middot; |v| )</b><br>
                        <b>theta = arccos [ (u &middot; v) / ( |u| &middot; |v| ) ]</b><br><br>
                        <b>Pasos:</b>
                        <ol>
                          <li>Calcular u &middot; v.</li>
                          <li>Calcular |u| y |v|.</li>
                          <li>Dividir y aplicar arccos (resultado en grados).</li>
                        </ol>
                        <b>Ejemplo:</b> u = (1, 0, 0) y v = (1, 1, 0)<br>
                        u &middot; v = 1, &nbsp; |u| = 1, &nbsp; |v| = sqrt(2)<br>
                        cos(theta) = 1 / sqrt(2) &nbsp;-&gt;&nbsp; theta = 45 grados<br><br>
                        <b>Ejemplo 2:</b> (1, 0, 0) y (0, 1, 0) dan u &middot; v = 0, es decir theta = 90 grados.<br><br>
                        Ninguno de los dos vectores puede ser el vector cero, porque no tendría dirección.
                </body></html>
                """;
        
        String vecCruz =
                """
                <html><body>
                        <b>Producto cruz</b> (el resultado es otro vector, solo en 3D):<br>
                        u &times; v = ( u<sub>2</sub>v<sub>3</sub> - u<sub>3</sub>v<sub>2</sub> , &nbsp; u<sub>3</sub>v<sub>1</sub> - u<sub>1</sub>v<sub>3</sub> , &nbsp; u<sub>1</sub>v<sub>2</sub> - u<sub>2</sub>v<sub>1</sub> )<br><br>
                        <b>Propiedades:</b>
                        <ul>
                          <li>u &times; v es perpendicular a u y a v (regla de la mano derecha).</li>
                          <li>|u &times; v| = |u| &middot; |v| &middot; sen(theta)</li>
                          <li>u &times; v = -(v &times; u), no es conmutativo.</li>
                          <li>u &times; u = (0, 0, 0)</li>
                        </ul>
                        <b>Ejemplo 1:</b> (1, 0, 0) &times; (0, 1, 0) = (0, 0, 1)<br><br>
                        <b>Ejemplo 2:</b> (1, 2, 3) &times; (4, 5, 6)<br>
                        = ( 2&middot;6 - 3&middot;5 , &nbsp; 3&middot;4 - 1&middot;6 , &nbsp; 1&middot;5 - 2&middot;4 ) = (-3, 6, -3)<br>
                        Comprobación: (-3, 6, -3) &middot; (1, 2, 3) = -3 + 12 - 9 = 0, es perpendicular.
                </body></html>
                """;
        
        String aplica =
                """
                <html><body>
                        <b>Área de un paralelogramo</b> con lados u y v: A = |u &times; v|<br>
                        <b>Área de un triángulo:</b> A = |u &times; v| / 2<br>
                        Ejemplo: u = (1, 0, 0) y v = (0, 2, 0) &nbsp;-&gt;&nbsp; u &times; v = (0, 0, 2), el área es 2.<br><br>
                        <b>Perpendicularidad:</b> dos vectores son ortogonales si su producto punto es 0.<br><br>
                        <b>Trabajo de una fuerza:</b> W = F &middot; d (producto punto).<br><br>
                        <b>Sistemas de ecuaciones:</b> A &middot; X = B se resuelve con X = A<sup>-1</sup> &middot; B, si det(A) es distinta de 0.<br><br>
                        <b>La determinante como área o volumen:</b> en una matriz 2 x 2 es el área (con signo) del paralelogramo formado por sus filas; en una 3 x 3, el volumen del paralelepípedo.<br><br>
                        Otras aplicaciones: gráficos 3D, física (fuerzas, velocidades), ingeniería y análisis de datos.
                </body></html>
                """;
        
        titulos = new String[]{
            "Matrices: definicion y tipos",
            "Matrices: operaciones",
            "Matrices: determinante",
            "Matrices: inversa",
            "Vectores: definicion y magnitud",
            "Vectores: producto punto",
            "Vectores: angulo entre vectores",
            "Vectores: producto cruz",
            "Aplicaciones"
        };
        
        
        
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        
        
        contenidos = new String[]{
            matDef,
            matOper,
            matDet,
            matInv,
            vecDef,
            vecPunto,
            vecAngulo,
            vecCruz,
            aplica
        };
        
        /*Boton regreso*/
        JButton ret = new JButton("<-");
        ret.setBounds(380, 560, 60, 38);
        ret.setBackground(new Color(111, 94, 171));
        ret.setForeground(Color.WHITE);
        ret.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 14));
        ret.setFocusPainted(false);
        ret.addActionListener(e ->{
            new AlgLineal();
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
        setTitle("SINCELAB - Teoria Algebra Lineal");
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
