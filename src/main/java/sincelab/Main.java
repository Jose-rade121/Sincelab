package sincelab;


import javax.swing.SwingUtilities;

import sincelab.view.windows.MainWindow;
import sincelab.view.windows.UiLogin;

/**
 *
 * @author josee
 */
public class Main {
    public static void main(String [] args){
        // Primero se pide la sesion; al entrar bien se abre la ventana principal.
        SwingUtilities.invokeLater(() -> new UiLogin(() -> new MainWindow()));
    }
}
