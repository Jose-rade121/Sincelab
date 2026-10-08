package sincelab.view;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 *
 * @author josee
 */
public class UiLogin extends JPanel{
    
    public UiLogin(){
        
        PrincipalFont fontType = new PrincipalFont();
        
        JPanel loginPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER,10,10)
        ); 
        
        JLabel title = new JLabel();
        title.setText("REGISTRATE");
        title.setForeground(Color.BLACK);
        title.setFont(fontType.getFont(fontType.BESTIME, 0 , 20));
        title.setBorder(
                BorderFactory.createEmptyBorder(0,20,0,0)
        );
        
        loginPanel.setOpaque(false);
        loginPanel.add(title);
        
        
       
    }
    

    
}
