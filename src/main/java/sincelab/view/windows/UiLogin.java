package sincelab.view.windows;
 
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.*;
 
import sincelab.storage.UsuarioDAO;
import sincelab.storage.sesion.Users;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Sesion;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.Themes;
 
/**
 * Ventana de acceso: iniciar sesion o crear cuenta.
 * Al terminar bien, guarda la sesion y ejecuta alTerminar (abre el menu).
 *
 * @author josee
 */
public class UiLogin extends JFrame implements Themed{
 
    private final Runnable alTerminar;
 
    private JPanel loginPanel;
    private int altoPanel = 290;
    private boolean modoRegistro = false;
 
    private final JLabel title = new JLabel();
    private final JLabel lblNombre = new JLabel("Nombre: ");
    private final JLabel lblCarrera = new JLabel("Carrera: ");
    private final JLabel lblUsuario = new JLabel("Usuario: ");
    private final JLabel lblClave = new JLabel("Contraseña: ");
 
    private final JTextField nombre = new JTextField();
    private final JTextField carrera = new JTextField();
    private final JTextField usuario = new JTextField();
    private final JPasswordField clave = new JPasswordField();
 
    private final JButton enviar = new JButton();
    private final JButton cambiar = new JButton();
 
    public void background(){
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
 
    public UiLogin(){
        this(null);
    }
 
    public UiLogin(Runnable alTerminar){
 
        this.alTerminar = alTerminar;
 
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/guardado.png")
        );
 
        PrincipalFont fontType = new PrincipalFont();
 
        loginPanel = new JPanel(null){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255,255,255,190));
                g2.fillRoundRect(10, 10, getWidth() - 20, altoPanel, 25, 25);
                g2.dispose();
                super.paintComponent(g);
            }
        };
 
        /* Titulo */
        title.setForeground(new Color(32, 17, 82));
        title.setFont(fontType.getFont(fontType.BESTIME, 0 , 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(30,20,260,30);
 
        /* Etiquetas */
        for (JLabel l : new JLabel[]{lblNombre, lblCarrera, lblUsuario, lblClave}) {
            l.setForeground(new Color(32, 17, 82));
            l.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0 , 15));
        }
 
        /* Boton principal (Entrar / Crear cuenta) */
        enviar.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 15));
        enviar.setForeground(new Color(255, 255, 255));
        enviar.setBackground(new Color(111, 94, 171));
        enviar.setBorderPainted(false);
        enviar.setFocusPainted(false);
        enviar.addActionListener(e -> procesar());
 
        /* Enlace para cambiar entre iniciar sesion y registrarse */
        cambiar.setFont(fontType.getFont(fontType.NUNITO_BLACK, 0, 12));
        cambiar.setForeground(new Color(32, 17, 82));
        cambiar.setBorderPainted(false);
        cambiar.setContentAreaFilled(false);
        cambiar.setFocusPainted(false);
        cambiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cambiar.addActionListener(e -> ajustar(!modoRegistro));
 
        loginPanel.setOpaque(false);
        loginPanel.add(title);
        loginPanel.add(lblNombre);
        loginPanel.add(nombre);
        loginPanel.add(lblCarrera);
        loginPanel.add(carrera);
        loginPanel.add(lblUsuario);
        loginPanel.add(usuario);
        loginPanel.add(lblClave);
        loginPanel.add(clave);
        loginPanel.add(enviar);
        loginPanel.add(cambiar);
 
        ajustar(false);   // empieza en "Iniciar sesion"
 
        /*
            Segunda mitad (Imagen)
        */
 
        ImageIcon astrona = new ImageIcon(
                new ImageIcon(getClass().getResource("/sincelab/assets/icons/Astronauta.png"))
                .getImage().getScaledInstance(220, -1, Image.SCALE_SMOOTH)
        );
 
        ImageIcon Fondo = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/fondo.jfif")
        );
 
        JPanel fondo = new JPanel(new GridLayout(1,2)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(fondo);
 
        JPanel loginPanel2 = new JPanel(null);
        loginPanel2.setOpaque(false);
 
        JLabel img = new JLabel(astrona);
        img.setBounds((320 - astrona.getIconWidth())/ 2, 15 , astrona.getIconWidth(), astrona.getIconHeight());
        loginPanel2.add(img);
 
        setIconImage(icon.getImage());
        setTitle("SINCELAB - Acceso");
        setSize(640,420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        add(loginPanel, BorderLayout.WEST);
        add(loginPanel2);
        background();
        getRootPane().setDefaultButton(enviar);   // Enter = enviar
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    /* Muestra u oculta los campos segun el modo y los acomoda */
    private void ajustar(boolean registro){
        modoRegistro = registro;
        title.setText(registro ? "CREAR CUENTA" : "INICIAR SESION");
 
        lblNombre.setVisible(registro);
        nombre.setVisible(registro);
        lblCarrera.setVisible(registro);
        carrera.setVisible(registro);
 
        int y = registro ? 60 : 80;
 
        if (registro) {
            lblNombre.setBounds(30, y, 260, 20);
            nombre.setBounds(30, y + 20, 260, 28);
            y += 55;
            lblCarrera.setBounds(30, y, 260, 20);
            carrera.setBounds(30, y + 20, 260, 28);
            y += 55;
        }
 
        lblUsuario.setBounds(30, y, 260, 20);
        usuario.setBounds(30, y + 20, 260, 28);
        y += 55;
 
        lblClave.setBounds(30, y, 260, 20);
        clave.setBounds(30, y + 20, 260, 28);
        y += 60;
 
        enviar.setText(registro ? "Crear cuenta" : "Entrar");
        enviar.setBounds(95, y, 140, 36);
        y += 44;
 
        cambiar.setText(registro ? "¿Ya tienes cuenta? Inicia sesion" : "¿No tienes cuenta? Registrate");
        cambiar.setBounds(30, y, 260, 22);
 
        altoPanel = y + 26;
        clave.setText("");
        loginPanel.revalidate();
        loginPanel.repaint();
    }
 
    private void aviso(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Dato Invalido", JOptionPane.ERROR_MESSAGE);
    }
 
    /* Registra o inicia sesion, segun el modo */
    private void procesar(){
        String u = usuario.getText().trim();
        char[] pass = clave.getPassword();
 
        try {
            if (u.isEmpty() || pass.length == 0) {
                aviso("Escribe tu usuario y tu contraseña.");
                return;
            }
 
            UsuarioDAO.Cuenta cuenta;
 
            if (modoRegistro) {
                String n = nombre.getText().trim();
                String c = carrera.getText().trim();
 
                if (n.isEmpty() || c.isEmpty()) {
                    aviso("Escribe tu nombre y tu carrera.");
                    return;
                }
                if (u.length() < 3) {
                    aviso("El usuario debe tener minimo 3 caracteres.");
                    return;
                }
                if (pass.length < 8) {
                    aviso("La contraseña debe tener minimo 8 caracteres.");
                    return;
                }
 
                cuenta = UsuarioDAO.registrar(u, n, c, pass);
                if (cuenta == null) {
                    aviso("Ese usuario ya existe. Elige otro.");
                    return;
                }
            } else {
                cuenta = UsuarioDAO.iniciarSesion(u, pass);
                if (cuenta == null) {
                    aviso("Usuario o contraseña incorrectos.");
                    return;
                }
            }
 
            Sesion.iniciar(new Users(cuenta.nombre(), cuenta.carrera(), cuenta.puntos()), cuenta.id());
            dispose();
            if (alTerminar != null) {
                alTerminar.run();
            }
 
        } catch (SQLException | RuntimeException ex) {
            aviso("No se pudo conectar con la base de datos. Revisa que MariaDB este encendida y que el .env exista.");
        } finally {
            Arrays.fill(pass, ' ');
        }
    }
 
}