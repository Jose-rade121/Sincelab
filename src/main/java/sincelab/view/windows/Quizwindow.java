/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.view.windows;


import java.awt.*;
import java.util.List;
import javax.swing.*;
 
import sincelab.storage.BancoPreguntas;
import sincelab.view.utilities.Pregunta;
import sincelab.view.utilities.Sesion;
import sincelab.storage.sesion.Users;
import sincelab.view.utilities.Header;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.Themes;
/**
 *
 * @author Angel
 */
public class Quizwindow extends JFrame implements Themed {
 
    private static final String[] LETRAS = {"A", "B", "C", "D"};
    private static final Color COLOR_OPCION = new Color(245, 245, 250);
    private static final Color COLOR_ACIERTO = new Color(200, 235, 205);
    private static final Color COLOR_ERROR = new Color(250, 215, 215);
 
    private Header header;
 
    private final String materia;
    private final List<Pregunta> preguntas;
    private final Runnable volver;
 
    private JPanel vistaPregunta, vistaResultado;
    private JLabel lblEstado, lblPregunta;
    private JLabel lblAciertos, lblPuntos, lblTotal;
    private JTextArea explicacion;
    private final JButton[] botones = new JButton[4];
    private JButton siguiente;
 
    private int indice;
    private int aciertos;
    private int[] orden;
    private boolean respondida;
    private boolean terminado;
 
    public void background() {
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
 
    /**
     * Abre el quiz. Si todavia no hay usuario registrado, primero abre el registro
     * y el quiz empieza cuando la persona lo envia. La ventana de origen solo se
     * cierra cuando el quiz realmente se abre.
     */
    public static void abrir(JFrame origen, String materia, List<Pregunta> preguntas, Runnable volver) {
        Runnable iniciar = () -> {
            new Quizwindow(materia, preguntas, volver);
            origen.dispose();
        };
        
        
        if (Sesion.actual() == null) {
            new UiLogin(iniciar);
        } else {
            iniciar.run();
        }
        
    }
 
    /* Panel blanco con borde redondeado */
    private JPanel panelBlanco() {
        JPanel p = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 12, 12);
                g2.setColor(new Color(60, 60, 60));
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 12, 12);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        p.setOpaque(false);
        return p;
    }
 
    /* Texto con saltos de linea automaticos dentro de un JLabel o JButton */
    private static String html(String s, int ancho) {
        String t = s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
        return "<html><div style='width:" + ancho + "px'>" + t + "</div></html>";
    }
 
    private JLabel etiqueta(JPanel panel, Font fuente, Color color, int x, int y, int w, int h) {
        JLabel l = new JLabel();
        l.setFont(fuente);
        l.setForeground(color);
        l.setBounds(x, y, w, h);
        panel.add(l);
        return l;
    }
 
    public Quizwindow(String materia, List<Pregunta> preguntas, Runnable volver) {
 
        this.materia = materia;
        this.preguntas = preguntas;
        this.volver = volver;
 
        PrincipalFont fontType = new PrincipalFont();
        Font fTitulo = fontType.getFont(fontType.BESTIME, 0, 28);
        Font fPregunta = fontType.getFont(fontType.NUNITO_BLACK, 0, 18);
        Font fOpcion = fontType.getFont(fontType.NUNITO_BLACK, 0, 15);
        Font fBoton = fontType.getFont(fontType.NUNITO_BLACK, 0, 14);
        Font fResultado = fontType.getFont(fontType.NUNITO_BLACK, 0, 22);
        Font fExplica = fontType.getFont(fontType.STAY_WITH_ME, 0, 20);
        Color morado = new Color(32, 17, 82);
 
        /* Tarjeta principal */
        JPanel tarjeta = panelBlanco();
        tarjeta.setPreferredSize(new Dimension(1100, 520));
 
        JLabel titulo = new JLabel("Quiz - " + materia);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(fTitulo);
        titulo.setBounds(45, 25, 650, 40);
        tarjeta.add(titulo);
 
        lblEstado = new JLabel("", JLabel.RIGHT);
        lblEstado.setFont(fBoton);
        lblEstado.setForeground(morado);
        lblEstado.setBounds(655, 32, 400, 25);
        tarjeta.add(lblEstado);
 
        /* Vista de pregunta */
        vistaPregunta = new JPanel(null);
        vistaPregunta.setOpaque(false);
        vistaPregunta.setBounds(0, 70, 1100, 390);
 
        JPanel cajaPregunta = panelBlanco();
        cajaPregunta.setBounds(45, 10, 1010, 80);
        lblPregunta = etiqueta(cajaPregunta, fPregunta, morado, 20, 5, 970, 70);
        vistaPregunta.add(cajaPregunta);
 
        int[][] posiciones = {{45, 105}, {560, 105}, {45, 177}, {560, 177}};
        for (int k = 0; k < 4; k++) {
            final int opcion = k;
            JButton b = new JButton();
            b.setBounds(posiciones[k][0], posiciones[k][1], 495, 62);
            b.setFont(fOpcion);
            b.setHorizontalAlignment(SwingConstants.LEFT);
            b.setMargin(new Insets(8, 14, 8, 14));
            b.setFocusPainted(false);
            b.setOpaque(true);
            b.setContentAreaFilled(true);
            b.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(150, 150, 170)),
                    BorderFactory.createEmptyBorder(4, 12, 4, 12)));
            b.addActionListener(e -> responder(opcion));
            botones[k] = b;
            vistaPregunta.add(b);
        }
 
        explicacion = new JTextArea();
        explicacion.setBounds(45, 255, 1010, 120);
        explicacion.setLineWrap(true);
        explicacion.setWrapStyleWord(true);
        explicacion.setEditable(false);
        explicacion.setOpaque(false);
        explicacion.setFont(fExplica);
        vistaPregunta.add(explicacion);
 
        tarjeta.add(vistaPregunta);
 
        /* Vista de resultado */
        vistaResultado = new JPanel(null);
        vistaResultado.setOpaque(false);
        vistaResultado.setBounds(0, 70, 1100, 390);
        vistaResultado.setVisible(false);
 
        JPanel resumen = panelBlanco();
        resumen.setBounds(45, 10, 1010, 270);
 
        JLabel fin = etiqueta(resumen, fTitulo, Color.BLACK, 30, 20, 950, 40);
        fin.setText("Quiz terminado");
        lblAciertos = etiqueta(resumen, fResultado, morado, 30, 85, 950, 32);
        lblPuntos = etiqueta(resumen, fResultado, morado, 30, 125, 950, 32);
        lblTotal = etiqueta(resumen, fResultado, morado, 30, 165, 950, 32);
        vistaResultado.add(resumen);
 
        tarjeta.add(vistaResultado);
 
        /* Boton regreso */
        JButton ret = new JButton("<-");
        ret.setBounds(390, 475, 60, 34);
        ret.setBackground(new Color(111, 94, 171));
        ret.setForeground(Color.WHITE);
        ret.setFont(fBoton);
        ret.setFocusPainted(false);
        ret.addActionListener(e -> salir());
        tarjeta.add(ret);
 
        /* Boton Siguiente / Finalizar / Reintentar */
        siguiente = new JButton("Siguiente");
        siguiente.setBounds(470, 475, 160, 34);
        siguiente.setBackground(new Color(190, 211, 250));
        siguiente.setForeground(new Color(60, 90, 160));
        siguiente.setFont(fBoton);
        siguiente.setFocusPainted(false);
        siguiente.setBorder(BorderFactory.createLineBorder(new Color(110, 140, 210)));
        siguiente.addActionListener(e -> {
            if (terminado) {
                reiniciar();
            } else {
                avanzar();
            }
        });
        tarjeta.add(siguiente);
 
        /* Boton de ayuda */
        JButton ayuda = new JButton("?");
        ayuda.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 28));
        ayuda.setBorderPainted(false);
        ayuda.setContentAreaFilled(false);
        ayuda.setFocusPainted(false);
        ayuda.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Elige una respuesta por pregunta.\n"
                + "Cada respuesta correcta vale " + BancoPreguntas.PUNTOS_POR_PREGUNTA + " puntos.\n"
                + "Al terminar el quiz, los puntos se suman a tu usuario.",
                "Ayuda", JOptionPane.INFORMATION_MESSAGE));
 
        JPanel centro = new JPanel(new GridBagLayout());
        centro.setOpaque(false);
        centro.add(tarjeta);
 
        JPanel pie = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 0));
        pie.setOpaque(false);
        pie.add(ayuda);
 
        JPanel zona = new JPanel(new BorderLayout());
        zona.setOpaque(false);
        zona.add(centro, BorderLayout.CENTER);
        zona.add(pie, BorderLayout.SOUTH);
 
        // Especificaciones de la ventana
 
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        );
 
        setIconImage(icon.getImage());
        setTitle("QUIZ - " + materia.toUpperCase());
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
 
        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        add(zona, BorderLayout.CENTER);
        getRootPane().setDefaultButton(siguiente);
        background();
        setLocationRelativeTo(null);
 
        mostrarPregunta();
        setVisible(true);
    }
 
    private void mostrarPregunta() {
        Pregunta p = preguntas.get(indice);
        orden = p.ordenMezclado();   // las opciones se mezclan en cada intento
 
        lblPregunta.setText(html(p.getEnunciado(), 950));
        for (int k = 0; k < 4; k++) {
            botones[k].setText(html(LETRAS[k] + ") " + p.getOpcion(orden[k]), 440));
            botones[k].setBackground(COLOR_OPCION);
        }
 
        explicacion.setText("");
        respondida = false;
        siguiente.setEnabled(false);
        siguiente.setText(indice == preguntas.size() - 1 ? "Finalizar" : "Siguiente");
        actualizarEstado();
    }
 
    private void actualizarEstado() {
        lblEstado.setText("Pregunta " + (indice + 1) + "/" + preguntas.size()
                + "     Puntos: " + aciertos * BancoPreguntas.PUNTOS_POR_PREGUNTA);
    }
 
    private void responder(int k) {
        if (respondida || terminado) {
            return;
        }
        respondida = true;
 
        Pregunta p = preguntas.get(indice);
        boolean acierto = orden[k] == p.getCorrecta();
 
        int posCorrecta = 0;
        for (int j = 0; j < 4; j++) {
            if (orden[j] == p.getCorrecta()) {
                posCorrecta = j;
            }
        }
 
        botones[posCorrecta].setBackground(COLOR_ACIERTO);
        if (acierto) {
            aciertos++;
            explicacion.setText("Correcto! +" + BancoPreguntas.PUNTOS_POR_PREGUNTA
                    + " puntos\n" + p.getExplicacion());
        } else {
            botones[k].setBackground(COLOR_ERROR);
            explicacion.setText("Incorrecto. La respuesta era la " + LETRAS[posCorrecta]
                    + ".\n" + p.getExplicacion());
        }
 
        actualizarEstado();
        siguiente.setEnabled(true);
        siguiente.requestFocusInWindow();
    }
 
    private void avanzar() {
        if (indice < preguntas.size() - 1) {
            indice++;
            mostrarPregunta();
        } else {
            terminar();
        }
    }
 
    private void terminar() {
        terminado = true;
 
        int puntos = aciertos * BancoPreguntas.PUNTOS_POR_PREGUNTA;
        Users usuario = Sesion.actual();
 
        vistaPregunta.setVisible(false);
        vistaResultado.setVisible(true);
        lblEstado.setText("");
        siguiente.setText("Reintentar");
        siguiente.setEnabled(true);
 
        lblAciertos.setText("Respuestas correctas: " + aciertos + " / " + preguntas.size());
        lblPuntos.setText("Puntos ganados: " + puntos);
 
        if (usuario == null) {
            lblTotal.setText("No hay un usuario registrado: los puntos no se sumaron.");
            return;
        }
 
        usuario.sumarPuntaje(puntos);
        lblTotal.setText("Puntaje de " + usuario.getNombre() + ": " + usuario.getPuntaje());
    }
 
    private void reiniciar() {
        terminado = false;
        indice = 0;
        aciertos = 0;
        vistaResultado.setVisible(false);
        vistaPregunta.setVisible(true);
        mostrarPregunta();
    }
 
    private void salir() {
        if (!terminado && (indice > 0 || respondida)) {
            int r = JOptionPane.showConfirmDialog(this,
                    "Si sales ahora no se suman puntos. Quieres salir?",
                    "Salir del quiz", JOptionPane.YES_NO_OPTION);
            if (r != JOptionPane.YES_OPTION) {
                return;
            }
        }
        volver.run();
        dispose();
    }
}