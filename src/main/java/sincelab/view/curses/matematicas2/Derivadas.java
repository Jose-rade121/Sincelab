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
import sincelab.storage.derivada;
import sincelab.storage.polinomio;
import sincelab.view.Header;
import sincelab.view.PrincipalFont;
import sincelab.view.Themed;
import sincelab.view.Themes;
/**
 *
 * @author Angel
 */
public class Derivadas extends JFrame implements Themed {
 
    private Header header;
    private JTextField funcion, punto;
    private JTextArea resultado;
 
    public void background() {
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
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
 
    private JTextField CalcDeV(JPanel panel, String texto, int x, int y, int w, PrincipalFont f) {
        JLabel lbl = new JLabel(texto);
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
            polinomio d = derivada.derivar(p);
            double x0 = Double.parseDouble(punto.getText().trim().replace(",", "."));
 
            resultado.setText("f(x) = " + p + "\n"
                    + "f'(x) = " + d + "\n"
                    + "f'(" + polinomio.fmt(x0) + ") = " + polinomio.fmt(derivada.valorEn(p, x0)));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this,
                    "Revisa la funcion y el punto x.\nEjemplo: 3x^2 - 5x + 2",
                    "Dato Invalido",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
 
    public Derivadas() {
 
        PrincipalFont fontType = new PrincipalFont();
 
        /* Tarjeta principal */
        JPanel tarjeta = PanelBlanco();
        tarjeta.setPreferredSize(new Dimension(1100, 520));
 
        JLabel titulo = new JLabel("Derivada");
        titulo.setForeground(Color.BLACK);
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0, 28));
        titulo.setBounds(45, 25, 600, 40);
        tarjeta.add(titulo);
 
        /* Caja Contenido */
        JPanel contenido = PanelBlanco();
        contenido.setBounds(45, 80, 1010, 270);
 
        JLabel lblContenido = new JLabel("Contenido");
        lblContenido.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 12));
        lblContenido.setForeground(Color.DARK_GRAY);
        lblContenido.setBounds(15, 8, 200, 18);
        contenido.add(lblContenido);
 
        funcion = CalcDeV(contenido, "Funcion f(x):", 30, 35, 440, fontType);
        punto = CalcDeV(contenido, "Punto x:", 500, 35, 150, fontType);
 
        resultado = new JTextArea();
        resultado.setBounds(30, 110, 950, 145);
        resultado.setEditable(false);
        resultado.setOpaque(false);
        resultado.setFont(fontType.getFont(fontType.STAY_WITH_ME, 0, 20));
        contenido.add(resultado);
        tarjeta.add(contenido);
 
        /* Clasificacion 
        JLabel lblClasif = new JLabel("Clasificacion:");
        lblClasif.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 13));
        lblClasif.setBounds(48, 365, 300, 20);
        tarjeta.add(lblClasif);
 
        JPanel CalcDeVPunt = CalcDeV();
        cajaPunt.setBounds(45, 390, 1010, 70);
        JLabel puntuaciones = new JLabel("PUNTUACIONES", JLabel.CENTER);
        puntuaciones.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 13));
        puntuaciones.setBounds(0, 0, 1010, 70);
        cajaPunt.add(puntuaciones);
        tarjeta.add(cajaPunt); */ //NO funciona//
 
        /* Boton Iniciar */
        JButton iniciar = new JButton("Iniciar");
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
                + "Punto x: valor donde se evalua la derivada.\n"
                + "Pulsa Iniciar para calcular.",
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
        setTitle("DERIVADA");
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