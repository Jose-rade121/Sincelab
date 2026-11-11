package sincelab.view.curses.fisica1;

import java.awt.*;
import javax.swing.*;
import sincelab.view.utilities.Header;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.Themes;



/**
 *
 * @author alejo
 */
public class Fisica1 extends JFrame implements Themed{

    private Header header;

    public void background(){
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    /* Boton azul del menu, los 3 son iguales */
    private JButton Boton(String texto, int y, PrincipalFont f){
        JButton b = new JButton();
        b.setText(texto);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setBackground(new Color(59,130,246));
        b.setForeground(new Color(255,255,255));
        b.setBounds(70,y,360,80);
        b.setFont(f.getFont(f.HEY_COMIC, 0, 15));
        return b;
    }
    
    public Fisica1(){

        PrincipalFont fontType = new PrincipalFont();

        JPanel zona = new JPanel();

        JLabel titulo = new JLabel();
        titulo.setText("Fisica 1");
        titulo.setForeground(new Color(59,130,246));
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0 ,30));
        titulo.setBounds(0,90,500,50);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        JButton movimiento = Boton("Movimiento uniformemente acelerado", 180, fontType);

        movimiento.addActionListener(e -> {
            new MovAcelerado();
            dispose();
        });

        JButton newton = Boton("Segunda ley de Newton", 280, fontType);

        newton.addActionListener(e -> {
            new SegundaLey();
            dispose();
        });

        JButton caida = Boton("Caida libre", 380, fontType);

        caida.addActionListener(e -> {
            new CaidaLibre();
            dispose();
        });

        zona.setLayout(null);
        zona.add(movimiento);
        zona.add(newton);
        zona.add(caida);
        zona.add(titulo);


        //Disposiciones de la ventana

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        );

        setIconImage(icon.getImage());
        setTitle("FISICA 1"); //Le da un titulo.
        setSize(500,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.

        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        add(zona);
        background();
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
