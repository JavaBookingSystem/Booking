import database.DBWorker;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

/**
 * Created by Arslan on 21.06.2016.
 */
public class MovieDescriptionForm extends JFrame {
    private JList list1;
    private JPanel panel1;
    private JButton buyButton;
    private JLabel label1;
    private JTextArea textArea1;

//    public static void main(String[] args) {
//        new MovieDescriptionForm(null).setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//    }

    public MovieDescriptionForm(DBWorker dbWorker, JFrame parentJFrame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (0.5 * dimension.getSize().width), (int) (0.7 * dimension.getSize().height));

        list1.setListData(list);

        try {
            label1.setIcon(new ImageIcon(new URL("http://www.kinocenter.ru/upload/iblock/dfd/dfd10a8eec04e5c7f1dce5b125258eb6.jpg")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        textArea1.setWrapStyleWord(true);
        textArea1.setLineWrap(true);
        textArea1.setText("Режиссер: Нэнси Майерс\n" +
                "В ролях: Энн Хэтэуэй, Роберт Де Ниро, Рене Руссо.\n" +
                "Страна: США\n" +
                "\n" +
                "\n" +
                "Мудрая лирическая, с элементами сентиментальности, комедия ЖИЗНИ." +
                "Когда на съемочной площадке встречаются два обладателя Оскар кино"+
                " получается как минимум качественным. А участие Роберта Де Ниро гарантирует,"+
                "что оно будет ещё и смешным. 70-летний вдовец Бен Уитакер обнаруживает, что"+
                "выход на пенсию — еще не конец. Пользуясь случаем, он становится старшим стажером"+
                "на сайте моды под руководством Джулс Остин ");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                parentJFrame.setEnabled(true);
            }
        });
        setContentPane(panel1);
        setVisible(true);
        setTitle("Выбор");
    }

    String[] list = {
            "9:00, Зал 458, ул. Дмитрия Ульянова, 16",
            "12:00, Зал 2, Подкопаевский пер., 2/6",
            "15:00, Зал 4, Яузская ул., 11/6 строение 11",
            "15:00, Зал 5, ул. Дмитрия Ульянова, 16",
            "17:00, Зал 458, ул. Дмитрия Ульянова, 16",
            "19:00, Зал 2, Подкопаевский пер., 2/6",
            "19:00, Зал 4, Яузская ул., 11/6 строение 11",
            "21:00, Зал 5, ул. Дмитрия Ульянова, 16",
            "23:00, Зал 458, ул. Дмитрия Ульянова, 16",
            "23:00, Зал 2, Подкопаевский пер., 2/6",
            "23:00, Зал 4, Яузская ул., 11/6 строение 11",
            "23:00, Зал 5, ул. Дмитрия Ульянова, 16"};
}
