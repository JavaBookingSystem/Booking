package gui;

import database.DBWorker;
import database.Movies;
import database.Theaters;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
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

    private DBWorker dbWorker = new DBWorker();
    private ArrayList<Movies> movies = null;
    private ArrayList<Theaters> theaters = null;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BookingForm bookingForm = new BookingForm();
                bookingForm.setTitle("Бронь билета");
                bookingForm.constructForm();
            }
        });
    }

    private Map<String, ImageIcon> imageMap;
    String[][] nameList = new String[2][];
    String[] addresses = null;

    private void constructForm() {
        movies = dbWorker.getMovies();
        nameList[0] = new String[movies.size()];
        nameList[1] = new String[movies.size()];

        int i = 0;
        for (Movies movie: movies) {
            nameList[0][i] = movie.getName();
            nameList[1][i] = movie.getPosters();
            ++ i;
        }

        theaters = dbWorker.getTheaters();
        addresses = new String[theaters.size()];

        int j = 0;
        for (Theaters theater: theaters) {
            addresses[j] = theater.getAddress();
            ++ j;
        }

        createList();
    }

    boolean isListOfMovies = true;

    private void changeListView(int index) {
        list1.removeAll();
        if (index == 0) {
            list1.setListData(nameList[0]);
            isListOfMovies = true;
        } else {
            list1.setListData(addresses);
            isListOfMovies = false;
        }
    }

    // вызов формы с описанием конкретного фильма
    private void invokeMovieDescription(int selected) {
        if (isListOfMovies) {
            MovieDescriptionForm movieDescriptionForm = new MovieDescriptionForm(dbWorker, movies.get(selected), this);
            setEnabled(false);
        }
    }

    int selected = -1;
    private void createList() {
        list1.removeAll();
        list1.setListData(nameList[0]);
        imageMap = createImageMap(nameList[0]);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (0.6 * dimension.getSize().width), (int) (0.85 * dimension.getSize().height));

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (! list1.isSelectionEmpty() && selected != list1.getSelectedIndex()) {
                    selected = list1.getSelectedIndex();
                    invokeMovieDescription(selected);
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


    // ренедерит изображения
    private class ListRenderer extends DefaultListCellRenderer {
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
            JOptionPane.showMessageDialog(new JFrame(), "Exception in filling list of icons:\n" + e.getMessage());
        }

        return map;
    }

}
