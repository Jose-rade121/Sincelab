package sincelab.view.curses.humanidades;

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
            "Capitulo 1: ¿Qué son las humanidades?",
            "Capitulo 2: Pensamiento crítico",
            "Capitulo 3: Argumentación y falacias",
            "Capitulo 4: Comprensión lectora",
            "Capitulo 6: Escritura académica",
            "Capitulo 7: Historia, fuentes y método",
            "Capitulo 8: Filosofía, las grandes preguntas",
            "Capitulo 9: Ética y moral",
            "Capitulo 10: Cultura, identidad y sociedad",
            "Capitulo 11: Arte y literatura"
        };

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
         
        
        
        String cap1 = 
            """
            <html><body>
                Las <b>humanidades</b> son el conjunto de disciplinas que estudian al ser humano, sus ideas, su historia y su cultura.<br><br>
                <b>Disciplinas principales:</b>
                <ul>
                    <li>Filosofía: las grandes preguntas sobre el conocimiento, la existencia y la moral.</li>
                    <li>Historia: cómo y por qué cambian las sociedades.</li>
                    <li>Literatura y arte: cómo expresamos lo que pensamos y sentimos.</li>
                    <li>Lingüística: cómo funciona el lenguaje.</li>
                    <li>Ética: cómo decidimos lo que está bien o mal.</li>
                </ul>
                <b>¿Para qué sirven?</b><br>
                Para entender mejor a las personas y a la sociedad, argumentar con ideas claras, leer con criterio y tomar decisiones responsables, también en carreras técnicas.<br><br>
                <b>Para pensar:</b> ¿qué decisión de tu vida diaria depende más de valores que de cálculos?
            </body></html>
            """;
        
        String cap2 = 
                """
                <html><body>
                    El <b>pensamiento crítico</b> es la capacidad de analizar la información, evaluarla y decidir qué creer o qué hacer con base en razones.<br><br>
                    <b>Hecho, opinión e interpretación:</b>
                    <ul>
                         <li>Hecho: se puede comprobar.</li>
                        <li>Opinión: es un juicio personal.</li>
                        <li>Interpretación: es una explicación de los hechos.</li>
                    </ul>
                    <b>Preguntas clave ante cualquier información:</b>
                    <ul>
                        <li>¿Quién lo dice?</li>
                        <li>¿Con qué evidencia?</li>
                        <li>¿Qué intereses puede tener?</li>
                        <li>¿Hay otras explicaciones posibles?</li>
                        <li>¿Qué información falta?</li>
                    </ul>
                    <b>Sesgos frecuentes:</b>
                    <ul>
                        <li>De confirmación: buscamos solo lo que confirma lo que ya pensamos.</li>
                        <li>De autoridad: creemos algo solo porque lo dice alguien importante.</li>
                        <li>De anclaje: nos aferramos al primer dato que recibimos.</li>
                    </ul>
                    <b>Para pensar:</b> ¿cuál fue la última noticia que compartiste sin verificarla?
                </body></html>
                """;
        
        String cap3 =
                """
                <html><body>
                        Un <b>argumento</b> es un conjunto de premisas (razones) que apoyan una conclusión.<br><br>
                        <b>Ejemplo:</b><br>
                        Premisa 1: todos los seres humanos son mortales.<br>
                        Premisa 2: Sócrates es un ser humano.<br>
                        Conclusión: Sócrates es mortal.<br><br>
                        <b>Tipos de argumento:</b>
                        <ul>
                          <li>Deductivo: si las premisas son verdaderas, la conclusión necesariamente lo es.</li>
                          <li>Inductivo: de casos particulares se llega a una regla general, que es probable pero no segura.</li>
                        </ul>
                        <b>Falacias</b> (errores de razonamiento que parecen válidos):
                        <ul>
                          <li>Ad hominem: atacar a la persona y no a su argumento.</li>
                          <li>Hombre de paja: deformar el argumento del otro para refutarlo fácil.</li>
                          <li>Falsa dicotomía: presentar solo dos opciones cuando hay más.</li>
                          <li>Generalización apresurada: concluir a partir de muy pocos casos.</li>
                          <li>Apelación a la autoridad: es cierto porque lo dijo alguien famoso, aunque no sea experto.</li>
                          <li>Apelación a la mayoría: es cierto porque todos lo creen.</li>
                          <li>Pendiente resbaladiza: afirmar sin pruebas que un paso llevará a consecuencias desastrosas.</li>
                          <li>Post hoc: creer que, si B ocurrió después de A, entonces A fue la causa.</li>
                        </ul>
                </body></html>
                """;
        
        String cap4 =
                """
                <html><body>
                        Leer no es solo pasar los ojos por el texto: es entenderlo, interpretarlo y evaluarlo.<br><br>
                        <b>Niveles de comprensión:</b>
                        <ul>
                          <li>Literal: qué dice el texto.</li>
                          <li>Inferencial: qué quiere decir, lo que está implícito.</li>
                          <li>Crítico: qué opino de lo que dice y con qué argumentos.</li>
                        </ul>
                        <b>Estrategias:</b>
                        <ul>
                          <li>Antes: observa el título, los subtítulos y las imágenes; piensa qué sabes del tema y para qué vas a leer.</li>
                          <li>Durante: subraya las ideas principales, anota las palabras desconocidas e intenta deducir su sentido por el contexto.</li>
                          <li>Después: resume con tus palabras, identifica la tesis y evalúa los argumentos.</li>
                        </ul>
                        <b>Conceptos clave:</b><br>
                        Idea principal: lo más importante que dice un párrafo o un texto.<br>
                        Tesis: la idea que el autor defiende.<br><br>
                        <b>Tipos de texto:</b> narrativo, descriptivo, expositivo y argumentativo.<br><br>
                        <b>Para pensar:</b> ¿qué tesis defiende el último texto que leíste y estás de acuerdo con ella?
                </body></html>
                """;
        
        String cap5 =
                """
                <html><body>
                        La <b>escritura académica</b> comunica ideas con claridad, orden y respaldo en fuentes.<br><br>
                        <b>Estructura de un texto:</b>
                        <ul>
                          <li>Introducción: presenta el tema y la tesis.</li>
                          <li>Desarrollo: párrafos con una idea cada uno, apoyada en evidencia.</li>
                          <li>Conclusión: retoma la tesis y cierra el texto.</li>
                        </ul>
                        <b>Un buen párrafo:</b> idea principal + explicación + evidencia o ejemplo.<br><br>
                        <b>Coherencia y cohesión:</b><br>
                        Coherencia: las ideas tienen sentido en conjunto.<br>
                        Cohesión: las frases se conectan con conectores como además, sin embargo, por lo tanto o en consecuencia.<br><br>
                        <b>Citar las fuentes:</b><br>
                        Con las normas APA se cita con autor y año, por ejemplo (García, 2020).<br>
                        El plagio es presentar ideas ajenas como propias. Se evita citando y parafraseando bien.<br><br>
                        <b>Proceso:</b> planear, escribir un borrador, revisar y corregir.
                </body></html>
                """;
        
        String cap6 = 
                """
                <html><body>
                        La <b>historia</b> estudia el pasado humano para explicar el presente.<br><br>
                        <b>Tipos de fuentes:</b>
                        <ul>
                          <li>Primarias: producidas en la época, como cartas, diarios, leyes, fotografías y testimonios.</li>
                          <li>Secundarias: estudios posteriores que interpretan esas fuentes, como libros y artículos.</li>
                        </ul>
                        <b>Método histórico:</b>
                        <ol>
                          <li>Heurística: buscar y reunir las fuentes.</li>
                          <li>Crítica: verificar su autenticidad y confiabilidad (¿quién la hizo, cuándo y para qué?).</li>
                          <li>Interpretación y síntesis: explicar lo ocurrido y construir el relato.</li>
                        </ol>
                        <b>Conceptos útiles:</b> causa y consecuencia, cambio y continuidad, contexto.<br><br>
                        <b>Historia y memoria:</b> la historia se apoya en evidencia y método; la memoria es lo que un grupo recuerda y valora. Se influyen entre sí, pero pueden diferir.<br><br>
                        <b>Periodización tradicional:</b> Edad Antigua, Media, Moderna y Contemporánea. Nació en la tradición europea y no es la única forma de dividir el tiempo.<br><br>
                        <b>Para pensar:</b> ¿qué fuentes usarías para investigar la historia de tu ciudad?
                </body></html>
                """;
        
        String cap7 = 
                """
                <html><body>
                        La palabra <b>filosofía</b> viene del griego y significa amor a la sabiduría.<br><br>
                        <b>Ramas principales:</b>
                        <ul>
                          <li>Metafísica: ¿qué es lo real?</li>
                          <li>Epistemología: ¿qué podemos conocer y cómo?</li>
                          <li>Lógica: ¿cuándo un razonamiento es correcto?</li>
                          <li>Ética: ¿qué debemos hacer?</li>
                          <li>Estética: ¿qué es lo bello?</li>
                          <li>Filosofía política: ¿cómo debe organizarse la sociedad?</li>
                        </ul>
                        <b>Algunos filósofos:</b>
                        <ul>
                          <li>Sócrates: preguntar para examinar las ideas.</li>
                          <li>Platón: el mundo de las ideas.</li>
                          <li>Aristóteles: la lógica y la ética de las virtudes.</li>
                          <li>Descartes: la duda metódica y su famosa frase "pienso, luego existo".</li>
                          <li>Kant: los límites del conocimiento y el deber moral.</li>
                        </ul>
                        <b>Cómo se filosofa:</b> preguntar, definir, argumentar y responder objeciones.<br><br>
                        <b>Para pensar:</b> ¿cómo sabes que lo que percibes es real?
                </body></html>
                """;
        
        String cap8 =
                """
                <html><body>
                        <b>Moral:</b> conjunto de normas y valores que sigue una persona o una sociedad.<br>
                        <b>Ética:</b> reflexión filosófica sobre esas normas y sobre por qué actuamos como actuamos.<br><br>
                        <b>Teorías éticas:</b>
                        <ul>
                          <li>Deontología (Kant): actuar bien es cumplir el deber, sin importar el resultado.</li>
                          <li>Utilitarismo (Bentham y Mill): es correcto lo que produce el mayor bienestar para el mayor número de personas.</li>
                          <li>Ética de las virtudes (Aristóteles): lo importante es formar un buen carácter, con honestidad, valentía y justicia.</li>
                        </ul>
                        <b>Dilema moral:</b> situación en la que hay que elegir entre opciones con valores en conflicto. Por ejemplo, ¿avisar de un error grave de un compañero aunque eso lo perjudique?<br><br>
                        <b>Derechos humanos:</b> la Declaración Universal de los Derechos Humanos de la ONU (1948) reconoce derechos que tienen todas las personas.<br><br>
                        <b>Ética profesional:</b> responsabilidad, honestidad, respeto por los demás y uso responsable de la tecnología y de los datos de las personas.<br><br>
                        <b>Para pensar:</b> ¿qué teoría ética se parece más a cómo tomas tus decisiones?
                </body></html>
                """;
        
        String cap9 = 
                """
                <html><body>
                        <b>Cultura:</b> conjunto de conocimientos, creencias, costumbres, lenguaje, arte y formas de vida de un grupo.<br>
                        <b>Identidad:</b> cómo nos reconocemos y cómo nos reconocen los demás (región, lengua, familia, tradiciones, comunidad).<br><br>
                        <b>Diversidad cultural:</b> Colombia es un país pluriétnico y multicultural, y la Constitución de 1991 reconoce la diversidad étnica y cultural.<br><br>
                        <b>Dos formas de mirar otras culturas:</b>
                        <ul>
                          <li>Etnocentrismo: juzgar a otras culturas con los valores de la propia.</li>
                          <li>Relativismo cultural: entender cada cultura desde su propio contexto.</li>
                        </ul>
                        <b>Globalización:</b> intercambio mundial de información, mercancías e ideas.
                        <ul>
                          <li>Ventajas: acceso al conocimiento e intercambio cultural.</li>
                          <li>Riesgos: pérdida de tradiciones y desigualdad.</li>
                        </ul>
                        <b>Cultura digital:</b> las redes sociales influyen en cómo nos informamos, nos relacionamos y construimos nuestra identidad.<br><br>
                        <b>Para pensar:</b> ¿qué tradición de tu región te gustaría que no se perdiera?
                </body></html>
                """;
        
        String cap10 = 
                """
                <html><body>
                        El <b>arte</b> y la <b>literatura</b> expresan cómo una sociedad ve el mundo, lo recuerda y lo critica.<br><br>
                        <b>Géneros literarios:</b>
                        <ul>
                          <li>Lírico: expresa emociones, como la poesía.</li>
                          <li>Narrativo: cuenta historias, como la novela y el cuento.</li>
                          <li>Dramático: se escribe para ser representado, como el teatro.</li>
                        </ul>
                        <b>Elementos de una narración:</b> narrador, personajes, tiempo, espacio y trama.<br><br>
                        <b>Movimientos (visión general):</b>
                        <ul>
                          <li>Renacimiento (siglos XV y XVI)</li>
                          <li>Barroco (siglo XVII)</li>
                          <li>Romanticismo (finales del XVIII y siglo XIX)</li>
                          <li>Realismo (siglo XIX)</li>
                          <li>Vanguardias (inicios del siglo XX)</li>
                        </ul>
                        <b>Literatura latinoamericana:</b> el realismo mágico presenta lo extraordinario como algo normal. Gabriel García Márquez es su figura más conocida, con Cien años de soledad (1967) y el Premio Nobel de Literatura de 1982.<br><br>
                        <b>Cómo analizar una obra:</b> contexto (época y autor), tema, forma y recepción.<br><br>
                        <b>Para pensar:</b> ¿qué obra, canción o película cambió tu forma de ver algo?
                </body></html>
                """;
        
        contenidos = new String[]{
            cap1,
            cap2,
            cap3,
            cap4,
            cap5,
            cap6,
            cap7,
            cap8,
            cap9,
            cap10
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
            new MainWindow();
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
