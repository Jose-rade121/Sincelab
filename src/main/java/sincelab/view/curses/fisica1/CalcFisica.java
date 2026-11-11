package sincelab.view.curses.fisica1;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

import sincelab.storage.polinomio;
import sincelab.view.Header;
import sincelab.view.PrincipalFont;
import sincelab.view.Themed;
import sincelab.view.Themes;

/**
 * Lo que comparten las 3 calculadoras de fisica: los campos, el resultado y
 * los botones. Cada calculadora solo pone sus formulas en calcular().
 *
 * @author alejo
 */
public abstract class CalcFisica extends JFrame implements Themed {

    private static final int MAX_CALCULOS = 5; // los que caben en la ventana de Resultados //

    private Header header;
    private final String[] botones;     // texto de los botones de arriba, uno por cada cosa que se puede calcular //
    private final String[][] nombres;   // los campos que pide cada boton //
    private final JButton[] selector;
    private final JLabel[] etiquetas;
    private final JTextField[] campos;
    private final JTextArea resultado;
    private final List<String> calculos = new ArrayList<>();
    private final Map<String, String> guardados = new HashMap<>(); // lo escrito en cada campo, asi no se borra al cambiar de boton //
    private int modo = 0;
    private int numero = 0; // cuantos calculos se han hecho desde el ultimo Reiniciar //

    public void background() {
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    /* Aqui va la formula de cada calculadora, modo es el boton elegido y los datos llegan en el orden de sus campos */
    protected abstract void calcular(int modo, double[] datos);

    /* Por defecto todo campo es obligatorio, una calculadora puede dejar alguno libre */
    protected boolean opcional(int modo, int campo) {
        return false;
    }

    /* Panel blanco con borde redondeado */
    private JPanel PanelBlanco() {
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

    private void CalcFis(JPanel panel, int i, int y, PrincipalFont f) {
        etiquetas[i] = new JLabel();
        etiquetas[i].setFont(f.getFont(f.NUNITO_BLACK, 0, 13));
        etiquetas[i].setForeground(new Color(32, 17, 82));
        etiquetas[i].setBounds(30, y, 175, 30);
        campos[i] = new JTextField();
        campos[i].setBounds(210, y, 170, 30);
        panel.add(etiquetas[i]);
        panel.add(campos[i]);
    }

    private JButton Boton(String texto, int x, PrincipalFont f) {
        JButton b = new JButton(texto);
        b.setBounds(x, 375, 160, 34);
        b.setBackground(new Color(190, 211, 250));
        b.setForeground(new Color(60, 90, 160));
        b.setFont(f.getFont(f.NUNITO_BLACK, 0, 14));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(new Color(110, 140, 210)));
        return b;
    }

    /* Cambia los campos segun el boton elegido y pinta ese boton de azul fuerte */
    private void cambiarModo(int nuevo) {
        guardarDatos();
        modo = nuevo;
        String[] n = nombres[modo];
        for (int i = 0; i < campos.length; i++) {
            boolean usado = i < n.length;
            etiquetas[i].setVisible(usado);
            campos[i].setVisible(usado);
            if (usado) {
                etiquetas[i].setText(n[i]);
                campos[i].setText(guardados.getOrDefault(n[i], ""));
            }
        }
        for (int i = 0; i < selector.length; i++) {
            selector[i].setBackground(i == modo ? new Color(59, 130, 246) : new Color(190, 211, 250));
            selector[i].setForeground(i == modo ? Color.WHITE : new Color(60, 90, 160));
        }
    }

    private void guardarDatos() {
        for (int i = 0; i < nombres[modo].length; i++) {
            guardados.put(nombres[modo][i], campos[i].getText());
        }
    }

    /* Deja un campo ya escrito desde el inicio, como la gravedad */
    protected void valorInicial(String nombre, String valor) {
        guardados.put(nombre, valor);
        for (int i = 0; i < nombres[modo].length; i++) {
            if (nombres[modo][i].equals(nombre)) campos[i].setText(valor);
        }
    }

    /* Lee un campo, acepta coma o punto como en derivadas. Un campo opcional vacio llega como NaN */
    private double leerDato(int i) {
        String texto = campos[i].getText().trim();
        if (texto.isEmpty() && opcional(modo, i)) return Double.NaN;
        try {
            double d = Double.parseDouble(texto.replace(",", "."));
            if (Double.isFinite(d)) return d;
        } catch (NumberFormatException e) {
            // no pasa nada: el aviso sale abajo
        }
        throw new IllegalArgumentException("Revisa este dato:\n" + nombres[modo][i]);
    }

    protected void revisarTiempo(double tiempo) {
        if (tiempo <= 0) throw new IllegalArgumentException("El tiempo debe ser mayor que 0.");
    }

    /* Escribe un resultado, si se pasa de grande aqui se frena. Los numeros que fmt no alcanza van en notacion cientifica */
    protected String dato(double d) {
        if (!Double.isFinite(d)) throw new IllegalArgumentException("Los datos son demasiado grandes.");
        double abs = Math.abs(d);
        if (abs >= 1e15 || (abs >= 1e-9 && abs < 1e-3)) return String.format("%.4e", d);
        return polinomio.fmt(d);
    }

    public void sendInfo() {
        try {
            double[] datos = new double[nombres[modo].length];
            for (int i = 0; i < datos.length; i++) datos[i] = leerDato(i);
            calcular(modo, datos);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Dato Invalido",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /* Muestra el resultado y lo guarda con sus datos para la ventana de Resultados */
    protected void mostrar(String texto) {
        numero++;
        StringBuilder sb = new StringBuilder("Calculo " + numero + " (" + botones[modo] + ")\n");
        for (int i = 0; i < nombres[modo].length; i++) {
            String valor = campos[i].getText().trim();
            if (!valor.isEmpty()) sb.append(nombres[modo][i]).append(" ").append(valor).append("\n");
        }
        calculos.add(sb.append(texto).toString());
        if (calculos.size() > MAX_CALCULOS) calculos.remove(0);

        resultado.setText(texto);
    }

    private void reiniciar() {
        calculos.clear();
        numero = 0;
        resultado.setText("");
    }

    private void verResultados() {
        JOptionPane.showMessageDialog(this,
                calculos.isEmpty() ? "Todavia no hay calculos." : String.join("\n\n", calculos),
                "Resultados",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    public CalcFisica(String ventana, String nombre, String textoAyuda, String[] botones, String[][] nombres) {

        PrincipalFont fontType = new PrincipalFont();
        this.botones = botones;
        this.nombres = nombres;

        /* Tarjeta principal */
        JPanel tarjeta = PanelBlanco();
        tarjeta.setPreferredSize(new Dimension(1100, 430));

        JLabel titulo = new JLabel(nombre);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0, 28));
        titulo.setBounds(45, 20, 900, 40);
        tarjeta.add(titulo);

        /* Caja Contenido */
        JPanel contenido = PanelBlanco();
        contenido.setBounds(45, 75, 1010, 285);

        JLabel lblContenido = new JLabel("Contenido");
        lblContenido.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 12));
        lblContenido.setForeground(Color.DARK_GRAY);
        lblContenido.setBounds(15, 8, 200, 18);
        contenido.add(lblContenido);

        /* Botones de que calcular */
        selector = new JButton[botones.length];
        for (int i = 0; i < botones.length; i++) {
            int elegido = i;
            selector[i] = Boton(botones[i], 0, fontType);
            selector[i].setBounds(30 + i * 240, 32, 220, 34);
            selector[i].addActionListener(e -> cambiarModo(elegido));
            contenido.add(selector[i]);
        }

        // Los campos van uno debajo del otro, hay tantos como pida el boton mas largo
        int filas = 0;
        for (String[] n : nombres) filas = Math.max(filas, n.length);

        etiquetas = new JLabel[filas];
        campos = new JTextField[filas];
        for (int i = 0; i < filas; i++) {
            CalcFis(contenido, i, 85 + i * 42, fontType);
        }

        /* Resultado al lado de los campos */
        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 12));
        lblResultado.setForeground(Color.DARK_GRAY);
        lblResultado.setBounds(440, 85, 200, 18);
        contenido.add(lblResultado);

        resultado = new JTextArea();
        resultado.setBounds(440, 110, 540, 160);
        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);
        resultado.setEditable(false);
        resultado.setOpaque(false);
        resultado.setFont(fontType.getFont(fontType.STAY_WITH_ME, 0, 26));
        contenido.add(resultado);

        tarjeta.add(contenido);
        cambiarModo(0);

        /* Boton Iniciar */
        JButton iniciar = Boton("Iniciar", 285, fontType);
        iniciar.addActionListener(e -> sendInfo());
        tarjeta.add(iniciar);

        /* Boton Reiniciar */
        JButton limpiar = Boton("Reiniciar", 470, fontType);
        limpiar.addActionListener(e -> reiniciar());
        tarjeta.add(limpiar);

        /* Boton Resultados */
        JButton resultados = Boton("Resultados", 655, fontType);
        resultados.addActionListener(e -> verResultados());
        tarjeta.add(resultados);

        /* Boton de ayuda */
        JButton ayuda = new JButton("?");
        ayuda.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 28));
        ayuda.setBorderPainted(false);
        ayuda.setContentAreaFilled(false);
        ayuda.setFocusPainted(false);
        ayuda.addActionListener(e -> JOptionPane.showMessageDialog(this,
                textoAyuda,
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
        setTitle(ventana);
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        add(zona, BorderLayout.CENTER);
        getRootPane().setDefaultButton(iniciar);
        background();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
