package sincelab.view.utilities;


import java.awt.*;
import javax.swing.*;
import sincelab.view.utilities.PrincipalFont;

/**
 *
 * @author josee
 */
public class TheoryBlock extends JPanel{
    
    private final JLabel lblTitulo;
    private final JEditorPane area;
    
    public TheoryBlock(String titulo, String texto,int x, int y, int ancho, int alto){
        
        PrincipalFont fontType = new PrincipalFont();
        
        setLayout(new BorderLayout(0,8));
        setBackground(Color.WHITE);
        setBounds(x,y,ancho,alto);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK,2),
            BorderFactory.createEmptyBorder(12,15,12,15)));
        
        lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(fontType.getFont(fontType.BESTIME, 0, 20));
        
        area = new JEditorPane();
        area.setEditable(false);
        area.setContentType("text/html");
        area.setOpaque(false);
        area.setText(texto);
        area.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 20));
        
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        
        add(lblTitulo, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        
    }
    
    public void actualizar(String titulo, String html){
        lblTitulo.setText(titulo);
        area.setText(html);
        area.setCaretPosition(0);
    }
    
}
