package sincelab.view.curses.algebralineal;

import java.awt.*;
import javax.swing.*;

import sincelab.storage.MatrizCuadrada;
import sincelab.view.Header;
import sincelab.view.PrincipalFont;
import sincelab.view.Themed;
import sincelab.view.Themes;

/**
 *
 * @author josee
 */
public class Matrices extends JFrame implements Themed {
    
    //Estas dos son limites para serciorarse si entra en la ventana
    private static final int N_MIN = 2;
    private static final int N_MAX = 5;
    
    private static final int ANCHO_CEL = 55;
    private static final int ALTO_CEL = 32;
    private static final int SEPARACION = 5;
    private static final int ANCHO_VENTANA = 500;
    
    
    
    private Header header;
    public static Color backgroundColor;
    private JPanel posiciones;
    private JPanel rejilla;
    private JTextField[][] campos;
    private JTextField campoN;
    private JButton crear;
    private JTextArea resultado;
    private MatrizCuadrada matriz;
    
    @Override
    public void background(){    
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    private void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this,
                mensaje,
                "Dato invalido",
                JOptionPane.ERROR_MESSAGE   
        );
    }
    
    private double leerNumero(JTextField campo){
        return Double.parseDouble(campo.getText().trim().replace(',', '.'));
    }
    
    public void generarCampos(){
       
        int n ;
        
        try{
            
            n = Integer.parseInt(campoN.getText().trim());
            
        } catch(NumberFormatException e){
            
            mostrarError("El orden debe ser un numero entero");
            return;
            
        }
        
        if(n < N_MIN || n > N_MAX){
            mostrarError("El orden debe de estar entre " + N_MIN + " y " + N_MAX);
            return;
        }
        
        if(rejilla != null){
            posiciones.remove(rejilla);
        } 
        
        int ancho = n * ANCHO_CEL + (n - 1) * SEPARACION;
        int alto = n * ALTO_CEL + (n - 1) * SEPARACION;
        
        rejilla = new JPanel(new GridLayout(n , n , SEPARACION, SEPARACION));
        rejilla.setOpaque(false);
        rejilla.setBounds((ANCHO_VENTANA - ancho)/2, 200, ancho, alto);
        
        campos = new JTextField[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                JTextField campo = new JTextField();
                campo.setHorizontalAlignment(JTextField.CENTER);
                campos[i][j] = campo;
                rejilla.add(campo);
            }
        }
        
        posiciones.add(rejilla);
        posiciones.revalidate();
        posiciones.repaint();
        
        crear.setEnabled(true);
        resultado.setText("");
        matriz = null;
    }
    
    private double[][] leerDatos(){
    
        int n = campos.length;
        double[][] datos = new double[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                try{
                    
                    datos[i][j] = leerNumero(campos[i][j]);
                    
                } catch(NumberFormatException e){
                    
                    mostrarError("Dato invalido en la fila " + (i+1)
                            + ", columna " + (j+1) + ".");
                    campos[i][j].requestFocus();
                    return null;
                }
            }
        }
        return datos;
    }
    
    public void crearMatriz(){
        double[][] datos = leerDatos();
        if(datos == null){
            return;
        }
        
        matriz = new MatrizCuadrada(datos);
        
        StringBuilder texto = new StringBuilder();
        texto.append("Determinante: ").append(MatrizCuadrada.formato(matriz.determinante())).append("\n");
        
        try{
            texto.append("Inversa:\n").append(matriz.inversa().toString());
        } catch(ArithmeticException e){
            texto.append("No tiene inversa (determinante 0)");
        }
        
        resultado.setText(texto.toString());
    }
    
    public Matrices(){
        
        posiciones = new JPanel();
        posiciones.setLayout(null);
        posiciones.setOpaque(false);
        
        PrincipalFont fontType = new PrincipalFont();
        
        JLabel titulo = new JLabel();
        titulo.setText("MATRIZ");
        titulo.setForeground(new Color(59, 130, 246));
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0 , 20));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setBounds(0, 50, ANCHO_VENTANA, 80);
        posiciones.add(titulo);
        
        JLabel etiquetaN = new JLabel("Orden n = ");
        etiquetaN.setBounds(112, 150, 80 ,25);
        posiciones.add(etiquetaN);
        
        campoN = new JTextField("3");
        campoN.setBounds(192,150,50,25);
        campoN.setHorizontalAlignment(JTextField.CENTER);
        posiciones.add(campoN);
        
        JButton generar = new JButton("Generar");
        generar.setBackground(new Color(111,94,171));
        generar.setForeground(new Color(225,225,225));
        generar.setBorderPainted(false);
        generar.setFocusPainted(false);
        generar.setBounds(252,150,135,25);
        generar.addActionListener(e -> generarCampos());
        posiciones.add(generar);
        
        crear = new JButton("Calcular");
        crear.setBounds(112,400,275,32);
        crear.setBackground(new Color(111,94,171));
        crear.setForeground(new Color(255,255,255));
        crear.setBorderPainted(false);
        crear.setFocusPainted(false);
        crear.setFont(fontType.getFont(fontType.NUNITO_BLACK,0,15));
        crear.setEnabled(false);
        crear.addActionListener(e -> crearMatriz());
        posiciones.add(crear);
        
        resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setOpaque(false);
        resultado.setBounds(30,450,440,170);
        resultado.setFont(fontType.getFont(fontType.STAY_WITH_ME, 0, 18));
        posiciones.add(resultado);
        
        add(posiciones);
        
        //Especificaciones de la ventana
        
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        ); 
        
        setIconImage(icon.getImage());
        setTitle("MATRICES"); //Le da un titulo.
        setSize(ANCHO_VENTANA,720);  // Genera el tamaño.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui le dice q hace el boton de cerrar(existen muchos otros).
        setResizable(false); //Si la pagina se puede cambiar de tamaño o no.
          
        header = new Header(this, false);
        add(header, BorderLayout.NORTH);
        background();
        setLocationRelativeTo(null); 
        setVisible(true);
    }
 
}
