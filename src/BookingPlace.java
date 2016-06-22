import database.DBWorker;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Arslan on 22.06.2016.
 */
public class BookingPlace extends JFrame {
    private JPanel panel1;
    private JButton payButton;
    private JTable table = null;
    int m = 20, n = 30;

    private ImageIcon busy = null;
    private ImageIcon free = null;

    public BookingPlace(DBWorker dbWorker) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (0.85 * dimension.getSize().width), (int) (0.85 * dimension.getSize().height));

        try {
            busy = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("busy.png")));
            free = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("free.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] names = new String[n];
        for(int i = 0; i < n; ++ i) {
            names[i] = ((Integer)(i + 1)).toString();
        }

        DefaultTableModel model = new DefaultTableModel(m, n) {
            String[] columnNames = names;

            @Override
            public Class<?> getColumnClass(int column) {
                return ImageIcon.class;
            }

            @Override
            public String getColumnName(int index) {
                return columnNames[index];
            }
        };

        table = new JTable(model);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                bookPlace(row, column);
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(panel1);

        panel1.add(scrollPane);

        JTable rowTable = new RowNumberTable(table);
        scrollPane.setRowHeaderView(rowTable);
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
                rowTable.getTableHeader());

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

        fillCells();
        updateRowHeights();

        setTitle("Бронь места");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void close() {
        setVisible(false);
        dispose();
    }

    private boolean bookPlace(int i, int j) {
        table.setValueAt(busy, i, j);
        return true;
    }

    private void fillCells() {
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                table.setValueAt(free, i, j);
            }
        }
    }

    // изменить высоту ячеек
    private void updateRowHeights() {
        for (int row = 0; row < table.getRowCount(); row++) {
            int rowHeight = table.getRowHeight();

            for (int column = 0; column < table.getColumnCount(); column++) {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }

            table.setRowHeight(row, rowHeight);
        }
    }
}
