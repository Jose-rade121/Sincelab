/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.view.curses.matematicas2;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sincelab.storage.integrales;
import sincelab.storage.polinomio;
import sincelab.view.Header;
import sincelab.view.PrincipalFont;
import sincelab.view.Themed;
import sincelab.view.Themes;
/**
 *
 * @author Angel
 */

public class Integrales extends JFrame implements Themed {
 
    private Header header;
    private JTextField funcion, limInf, limSup;
    private JTextArea resultado;
 
    public void background() {
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
 
    /* Panel blanco con borde redondeado */
    private JPanel panelblanco() {
        JPanel p = new JPanel(null) { // Crea un panel en blanco
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // esto hace que los bordes queden mas suavizados//
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
 
    private JTextField CalcIntg(JPanel panel, String texto, int x, int y, int w, PrincipalFont f) {
        JLabel lbl = new JLabel(texto); // crea la palabra funcion y f(x)//
        lbl.setFont(f.getFont(f.NUNITO_BLACK, 0, 13));
        lbl.setForeground(new Color(32, 17, 82));
        lbl.setBounds(x, y, w, 20);
        JTextField campo = new JTextField();
        campo.setBounds(x, y + 22, w, 30);
        panel.add(lbl);
        panel.add(campo);
        return campo;
    }
 
    public void sendInfo() {
        try {
            polinomio p = polinomio.parse(funcion.getText());
            double a = Double.parseDouble(limInf.getText().trim().replace(",", "."));
            double b = Double.parseDouble(limSup.getText().trim().replace(",", "."));
 
            
            resultado.setText("f(x) = " + p + "\n" 
                    + "Integral de " + polinomio.fmt(a) + " a " + polinomio.fmt(b) + "\n"
                    + "= " + polinomio.fmt(integrales.definida(p, a, b)));
        } catch (IllegalArgumentException e) { // esta opcion sirve para que no se rompa el programa, entonces en vez de romperse primero advierte al usuario//
            JOptionPane.showMessageDialog(this,
                    "Revisa la funcion y los limites a y b.\nEjemplo: 3x^2 - 5x + 2",
                    "Dato Invalido",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
 
    public Integrales() {
 
        PrincipalFont fontType = new PrincipalFont();
 
        /* Pagina principal */
        JPanel tarjeta = panelblanco();
        tarjeta.setPreferredSize(new Dimension(1100, 520));
 
        JLabel titulo = new JLabel("Integral definida");
        titulo.setForeground(Color.BLACK);
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0, 28));
        titulo.setBounds(45, 25, 600, 40);
        tarjeta.add(titulo);
 
        /* Contenido */
        JPanel contenido = panelblanco();
        contenido.setBounds(45, 80, 1010, 270);
 
        JLabel lblContenido = new JLabel("Ecuaciones");
        lblContenido.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 12));
        lblContenido.setForeground(Color.DARK_GRAY);
        lblContenido.setBounds(15, 8, 200, 18);
        contenido.add(lblContenido);
 
        funcion = CalcIntg(contenido, "Funcion f(x):", 30, 35, 440, fontType);
        limInf = CalcIntg(contenido, "Limite a:", 500, 35, 150, fontType);
        limSup = CalcIntg(contenido, "Limite b:", 670, 35, 150, fontType);

        
        resultado = new JTextArea();
        resultado.setBounds(30, 110, 950, 145);
        resultado.setEditable(false); // bloquea que el usuario puedad escribir ajajaj//
        resultado.setOpaque(false); // como java tiene una configuracion rara cuando uno tiene un contenido, decidi poner trasparente el fondo de la frase//
        resultado.setFont(fontType.getFont(fontType.STAY_WITH_ME, 0, 20));
        contenido.add(resultado);
        tarjeta.add(contenido);
 
        /*
        JLabel lblClasif = new JLabel("Clasificacion:");
        lblClasif.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 13));
        lblClasif.setBounds(48, 365, 300, 20);
        tarjeta.add(lblClasif);
 
        JPanel cajaPunt = panelblanco();
        cajaPunt.setBounds(45, 390, 1010, 70);
        JLabel puntuaciones = new JLabel("PUNTUACIONES", JLabel.CENTER);
        puntuaciones.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 13));
        puntuaciones.setBounds(0, 0, 1010, 70);
        cajaPunt.add(puntuaciones);
        tarjeta.add(cajaPunt);*/ //Aun no terminada!!!//
 
        // boton de iniciar la operacion//
        JButton iniciar = new JButton("Iniciar"); //Crea el boton principal de iniciar//
        iniciar.setBounds(470, 475, 160, 34);
        iniciar.setBackground(new Color(190, 211, 250));
        iniciar.setForeground(new Color(60, 90, 160));
        iniciar.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 14));
        iniciar.setFocusPainted(false);
        iniciar.setBorder(BorderFactory.createLineBorder(new Color(110, 140, 210)));
        iniciar.addActionListener(e -> sendInfo());
        tarjeta.add(iniciar);
 
        /* Boton de ayuda */
        JButton ayuda = new JButton("?");
        ayuda.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 28));
        ayuda.setBorderPainted(false);
        ayuda.setContentAreaFilled(false);
        ayuda.setFocusPainted(false);
        ayuda.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Funcion: un polinomio, por ejemplo\n"
                + "    3x^2 - 5x + 2\n"
                + "    x^3 - 4\n\n"
                + "Limite a y b: extremos de la integral definida.\n"
                + "Pulsa Iniciar para calcular.",
                "Ayuda", JOptionPane.INFORMATION_MESSAGE)); //Esto sirve para explicar como funciona la Calculadora y pss como hay gente que no sabe para eso esta ese boton//
 
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
 
        setIconImage(icon.getImage()); // Carga el icono de la aplicacion desde los recursos del proyecto
        setTitle("INTEGRAL");
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
