import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arslan on 18.06.2016.
 */
public class BookingForm extends JFrame {
    private JPanel panel1;
    private JList list1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BookingForm bookingForm = new BookingForm();
                bookingForm.setTitle("Бронь билета");
                bookingForm.createListOfImages();
            }
        });
    }

    private Map<String, ImageIcon> imageMap;
    String[][] nameList = {{"Angry birds", "Алиса в зазеркалье", "Варкрафт", "Выживший", "Иллюзия обмана 2",
            "Славные ублюдки","Стажер"},
            {"http://www.kinocenter.ru/upload/iblock/44d/44dfe0cfce64a9e960832e75c0e4a7b0.jpg",
                    "http://www.kinocenter.ru/upload/iblock/b8b/b8b767d6145205dbe35a6145443ccad3.jpg",
                    "http://www.kinocenter.ru/upload/iblock/76e/76effd735c8d4bcb3d778f8346807daa.jpg",
                    "http://www.kinocenter.ru/upload/iblock/19e/19e6cd3a4cb2a79406dfac7a048932d0.jpg",
                    "http://www.kinocenter.ru/upload/iblock/f0b/f0b8bdc16606b02cf12533188eef00fa.jpg",
                    "http://www.kinocenter.ru/upload/iblock/a3b/a3ba505dd2e1478943ca0267735d22a3.jpg",
                    "http://www.kinocenter.ru/upload/iblock/dfd/dfd10a8eec04e5c7f1dce5b125258eb6.jpg"
            }
    };
    String[] addresses = {"ул. Дмитрия Ульянова, 16",
            "Подкопаевский пер., 2/6",
            "Яузская ул., 11/6 строение 11, Москва",
            "ул. Пречистенка, 22/2",
            "Рогожский Вал ул., 7"};

    private void changeListView(int index) {
        list1.removeAll();
        if (index == 0) {
            list1.setListData(nameList[0]);
        } else {
            list1.setListData(addresses);
        }
    }

    private void createListOfImages() {
        list1.removeAll();
        list1.setListData(nameList[0]);
        imageMap = createImageMap(nameList[0]);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (0.6 * dimension.getSize().width), (int) (0.85 * dimension.getSize().height));

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (! list1.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Selected item: " + list1.getSelectedIndex());
                }
            }
        });

        comboBox1.addItem("Фильмы");
        comboBox1.addItem("Кинотеатры");
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeListView(comboBox1.getSelectedIndex());
            }
        });

        list1.setCellRenderer(new ListRenderer());

        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public class ListRenderer extends DefaultListCellRenderer {
        Font font = new Font("helvitica", Font.BOLD, 24);

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel)super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);

            label.setIcon(imageMap.get(value));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);

            return label;
        }
    }

    // ассоциация в контейнере названия с изображением
    private Map<String, ImageIcon> createImageMap(String[] list) {
        Map<String, ImageIcon> map = new HashMap<>();
        Image image = null;
        Image resizedImage = null;
        try {
            if (nameList != null && nameList[0] != null) {
                for (int i = 0; i < nameList[0].length; ++i) {
                    // загрузка изображения по адресу и его масштабирование
                    image = ImageIO.read(new URL(nameList[1][i]));
                    int width = image.getWidth(null) / 4;
                    int height = image.getHeight(null) / 4;
                    resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    map.put(nameList[0][i], new ImageIcon(resizedImage));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Exception filling list of icons:\n" + e.getMessage());
        }

        return map;
    }

}
