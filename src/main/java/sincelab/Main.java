package sincelab;


import sincelab.view.windows.MainWindow;
import sincelab.storage.Archive;
import sincelab.view.windows.UiLogin;
import sincelab.view.curses.algebralineal.AlgLineal;
import sincelab.view.curses.algebralineal.Matrices;
import sincelab.view.curses.algebralineal.Vectores;

/**
 *
 * @author josee
 */
public class Main {
    public static void main(String [] args){
        
        //new Archive(); -> Error por q le faltan 2 strings
        //new AlgLineal();
        //new MainWindow();
        //new UiLogin();
        //new Vectores();
        new Matrices();
    }
}
