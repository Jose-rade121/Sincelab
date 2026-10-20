package sincelab.view.curses.algebralineal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sincelab.storage.Vector3D;
import sincelab.view.Header;
import sincelab.view.PrincipalFont;
import sincelab.view.Themed;
import sincelab.view.Themes;

/**
 *
 * @author josee
 */
public class Vectores extends JFrame implements Themed {
    
    private Header header;
    public static Color backgroundColor;
    private JTextField x1,y1,z1;
    private JTextField x2,y2,z2; 
    private JButton enviar;
    private Vector3D magnitudv1, magnitudv2;
    private JLabel resultado;
    private JLabel resultado2;
    
    
    public void background(){
        
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    private JTextField crearCampo(JPanel panel, int x, int y ){
        JTextField campo = new JTextField();
        campo.setBounds(x,y,50,25);
        panel.add(campo);
        return campo;
    }
            
    private Vector3D leerVector(JTextField cx, JTextField cy, JTextField cz){
        double x = Double.parseDouble(cx.getText().trim());
        double y = Double.parseDouble(cy.getText().trim());
        double z = Double.parseDouble(cz.getText().trim());
        return new Vector3D(x,y,z);
    }
    /*
    private double leerNumero(JTextField campo){
        return Double.parseDouble(campo.getText().trim().replace(',', '.'));
    }
    */
    /*
    private Vector3D leerVector(JTextField cx, JTextField cy, JTextField cz){
        return new Vector3D(leerNumero(cx), leerNumero(cy), leerNumero(cz));
    }
    */
    
    
    public void sendInfo(){
        

        try {

            Vector3D v1 = leerVector(x1,y1,z1);
            Vector3D v2 = leerVector(x2,y2,z2);

            resultado.setText(String.format("Angulo entre vectores: %.2f grados" , 
                v1.calcularAngulo(v2))
            );
            
            Vector3D cruz = v1.productoCruz(v2);
            String datos = String.format("(%.1f,%.1f,%.1f)",
                    cruz.getX(), cruz.getY(), cruz.getZ()
            );
            
            resultado2.setText("Producto cruz: " + datos );
                    
            
            System.out.println("ROGER!!!");
                
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,
                    "Ingresos no validos para x, y, z.",
                    "Dato Invalido",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
        
    }
    
    
    public Vectores(){
        
        JPanel posiciones = new JPanel();
        PrincipalFont fontType = new PrincipalFont();
        
        
        JLabel titulo = new JLabel();
        titulo.setText("VECTORES");
        titulo.setForeground(new Color(59,130,246));
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0 , 20));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setBounds(0, 50 , 500 , 80);
        
        posiciones.add(titulo);
        
        JLabel v1 = new JLabel();
        v1.setText("V1 = ");
        v1.setBounds(112, 150, 45, 28);
        x1 = crearCampo(posiciones, 157 , 150);
        y1 = crearCampo(posiciones, 237 , 150);
        z1 = crearCampo(posiciones, 317 , 150);
        

    
        JLabel v2 = new JLabel();
        v2.setText("V2 = ");
        v2.setBounds(112, 193, 45, 28);
        x2 = crearCampo(posiciones, 157 ,193);
        y2 = crearCampo(posiciones, 237 ,193);
        z2 = crearCampo(posiciones, 317 ,193);
        
        JButton enviar = new JButton();
        enviar.setText("Enviar");
        enviar.setBounds(112, 246, 275, 32);
        enviar.setBackground(new Color(111, 94, 171));
        enviar.setForeground(new Color(255, 255, 255));
        enviar.setBorderPainted(false);
        enviar.setFocusPainted(false);
        enviar.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 15));
        enviar.addActionListener(e -> sendInfo());
        
        resultado = new JLabel();
        resultado.setBounds(30,300,440,200);
        resultado.setFont(fontType.getFont(fontType.STAY_WITH_ME, 0, 25));
        resultado.setVerticalAlignment(JLabel.TOP);
        posiciones.add(resultado);
        
        resultado2 = new JLabel();
        resultado2.setBounds(30,350,440,200);
        resultado2.setFont(fontType.getFont(fontType.STAY_WITH_ME, 0, 25));
        resultado2.setVerticalAlignment(JLabel.TOP);
        posiciones.add(resultado2);
        
        
        
        posiciones.setLayout(null);
        posiciones.add(v1);
        posiciones.add(v2);
        posiciones.add(enviar);
        add(posiciones);
        
        //Especificaciones del Header
        
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        setIconImage(icon.getImage());
        setTitle("VECTORES"); //Le da un titulo.
        setSize(500,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
          
        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        background();
        setLocationRelativeTo(null); 
        setVisible(true);
        
    }
    
}
