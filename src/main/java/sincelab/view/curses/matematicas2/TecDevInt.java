/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.view.curses.matematicas2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import sincelab.view.PrincipalFont;

/**
 *
 * @author  Angel
 */
public class TecDevInt extends JPanel {
    
    private JTextField actual; // aca es donde se escribe el texto//
    
      public TecDevInt(PrincipalFont fontType, JTextField... campos) {
        super(new GridLayout(4, 5, 5, 5));
        setOpaque(false);
 
        // Por defecto escribe en el primer campo; luego en el ultimo que se toque
        actual = campos[0];
        for (JTextField c : campos) {
            c.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    actual = c;
                }
            });
        }
        
         String[] teclas = {
            "7", "8", "9", "+", "Borrar",
            "4", "5", "6", "-", "Limpiar",
            "1", "2", "3", "*", "x",
            "0", ".", "^", "x^2", "x^3"
        };
        for (String t : teclas) {
            add(crearTecla(t, fontType));
        }
     } 
    private JButton crearTecla(String t,PrincipalFont f){
        JButton b = new JButton(t);
        b.setFocusable(false);
        b.setFont(f.getFont(f.NUNITO_BLACK, 0,14));
        b.setMargin(new Insets(0, 0, 0, 0));
        b.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 170)));
 
        if (t.equals("Borrar") || t.equals("Limpiar")) {
            b.setBackground(new Color(250, 215, 215));
        } else if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("^")) {
            b.setBackground(new Color(190, 211, 250));
        } else {
            b.setBackground(new Color(245, 245, 250));
        }
 
        b.addActionListener(e -> pulsar(t));
        return b;
    }
      private void pulsar(String t) {
        JTextField c = actual;
        if (t.equals("Limpiar")) {
            c.setText("");
        } else if (t.equals("Borrar")) {
            borrar(c);
        } else {
            c.replaceSelection(t);   // inserta donde esta el cursor
        }
        c.requestFocusInWindow();
    }
 
    /* Borra el texto seleccionado*/
    private void borrar(JTextField c) {
        try {
            Document d = c.getDocument();
            int ini = c.getSelectionStart();
            int fin = c.getSelectionEnd();
            if (ini != fin) {
                d.remove(ini, fin - ini);
            } else if (ini > 0) {
                d.remove(ini - 1, 1);
            }
        } catch (BadLocationException ex) {
            // no pasa nada: no habia nada que borrar
        }
    }
}
        

 
 
 
