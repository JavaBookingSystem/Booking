package gui;

import database.DBWorker;
import database.Movies;
import database.Sessions;
import gui.BookingPlace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Arslan on 21.06.2016.
 */
public class MovieDescriptionForm extends JFrame {
    private JList list1;
    private JPanel panel1;
    private JButton buyButton;
    private JLabel label1;
    private JTextArea textArea1;

    String[] listOfSessions = null;

//    public static void main(String[] args) {
//        new MovieDescriptionForm(null).setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//    }
    private Movies movie = null;
    private ArrayList<Sessions> sessions = null;

    SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");

    public MovieDescriptionForm(DBWorker dbWorker, Movies movie, JFrame parentJFrame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (0.5 * dimension.getSize().width), (int) (0.7 * dimension.getSize().height));

        sessions = dbWorker.getSessions(movie);
        listOfSessions = new String[sessions.size()];
        int i = 0;
        for (Sessions session: sessions) {
            listOfSessions[i] = localDateFormat.format(session.getDate()) +
                    ", Зал " + session.getIdhall() + ", Цена" + session.getPrice();
        }
        list1.setListData(listOfSessions);

        this.movie = movie;
        try {
            label1.setIcon(new ImageIcon(new URL(movie.getPosters())));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        textArea1.setWrapStyleWord(true);
        textArea1.setLineWrap(true);
        textArea1.setText(movie.getDescription() + "\n\n" + "" +
                "Старт показа: " + movie.getStart_date());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                parentJFrame.setEnabled(true);
            }
        });

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invokeBookingPlace();
            }
        });
        setContentPane(panel1);
        setVisible(true);
        setTitle("Выбор");
    }

    // вызов формы для выбора места для билета
    private void invokeBookingPlace() {
        BookingPlace bookingPlace = new BookingPlace(null);
    }
//     = {
//            "9:00, Зал 458, ул. Дмитрия Ульянова, 16",
//            "12:00, Зал 2, Подкопаевский пер., 2/6",
//            "15:00, Зал 4, Яузская ул., 11/6 строение 11",
//            "15:00, Зал 5, ул. Дмитрия Ульянова, 16",
//            "17:00, Зал 458, ул. Дмитрия Ульянова, 16",
//            "19:00, Зал 2, Подкопаевский пер., 2/6",
//            "19:00, Зал 4, Яузская ул., 11/6 строение 11",
//            "21:00, Зал 5, ул. Дмитрия Ульянова, 16",
//            "23:00, Зал 458, ул. Дмитрия Ульянова, 16",
//            "23:00, Зал 2, Подкопаевский пер., 2/6",
//            "23:00, Зал 4, Яузская ул., 11/6 строение 11",
//            "23:00, Зал 5, ул. Дмитрия Ульянова, 16"};
}
