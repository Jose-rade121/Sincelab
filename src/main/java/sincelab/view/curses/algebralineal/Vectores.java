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
    
    public void sendInfo(){
        
        try {
           
            Vector3D v1 = leerVector(x1,y1,z1);
            Vector3D v2 = leerVector(x2,y2,z2);
        
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
        
        
        JLabel v1 = new JLabel();
        v1.setText("V1 = ");
        v1.setBounds(140, 200, 50, 25);
        x1 = crearCampo(posiciones, 190 ,200);
        y1 = crearCampo(posiciones, 250 ,200);
        z1 = crearCampo(posiciones, 310 ,200);
        

    
        JLabel v2 = new JLabel();
        v2.setText("V2 = ");
        v2.setBounds(140, 240, 50, 25);
        x2 = crearCampo(posiciones, 190 ,240);
        y2 = crearCampo(posiciones, 250 ,240);
        z2 = crearCampo(posiciones, 310 ,240);
        
        JButton enviar = new JButton();
        enviar.setText("Enviar");
        enviar.setBounds(190, 285, 170, 25);
        enviar.setBackground(new Color(111, 94, 171));
        enviar.setForeground(new Color(255, 255, 255));
        enviar.setBorderPainted(false);
        enviar.setFocusPainted(false);
        enviar.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 15));
        enviar.addActionListener(e -> sendInfo());
        
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
        setSize(1280,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
          
        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        background();
        setLocationRelativeTo(null); 
        setVisible(true);
        
    }
    
}
