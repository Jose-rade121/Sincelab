package sincelab.view.windows;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import sincelab.storage.PuntajeDAO;
import sincelab.view.utilities.Header;
import sincelab.view.utilities.PrincipalFont;
import sincelab.view.utilities.Themed;
import sincelab.view.utilities.Themes;

/**
 * Ranking general: los 10 con mas puntos (suma de todas las materias).
 * Para abrirla:  new RankingWindow();
 */
public class RankingWindow extends JFrame implements Themed{

    private Header header;

    public void background(){
        getContentPane().setBackground(Themes.backgroundC);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public RankingWindow(){

        PrincipalFont fontType = new PrincipalFont();

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/sincelab/assets/icons/icon.png")
        );

        setLayout(new BorderLayout());
        setIconImage(icon.getImage());
        setTitle("SINCELAB - Ranking");
        setSize(500, 620);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        background();

        header = new Header(this, false);
        add(header, BorderLayout.NORTH);

        JLabel titulo = new JLabel("Ranking", JLabel.CENTER);
        titulo.setForeground(new Color(111, 94, 171));
        titulo.setFont(fontType.getFont(fontType.BESTIME, 0, 30));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        DefaultTableModel modelo = new DefaultTableModel(new String[]{"#", "Nombre", "Puntos"}, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        try {
            int pos = 1;
            for (PuntajeDAO.Posicion p : PuntajeDAO.ranking(null, 10)) {
                modelo.addRow(new Object[]{pos++, p.nombre(), p.puntos()});
            }
        } catch (SQLException | RuntimeException ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo cargar el ranking. Revisa que MariaDB este encendida.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(32);
        tabla.setFont(fontType.getFont(fontType.HEY_COMIC, 0, 14));
        tabla.getTableHeader().setFont(fontType.getFont(fontType.HEY_COMIC, 0, 14));
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setFillsViewportHeight(true);
        tabla.getColumnModel().getColumn(0).setMaxWidth(50);
        tabla.getColumnModel().getColumn(2).setMaxWidth(90);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel centro = new JPanel(new BorderLayout());
        centro.setOpaque(false);
        centro.setBorder(BorderFactory.createEmptyBorder(0, 40, 30, 40));
        centro.add(titulo, BorderLayout.NORTH);
        centro.add(scroll, BorderLayout.CENTER);
        add(centro, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
