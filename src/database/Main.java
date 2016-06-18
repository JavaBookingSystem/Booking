package database;


import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class Main {

    public static void main(String[] args) {
        DBWorker dbWorker = new DBWorker();

        String query = "select * from theaters";

        try {
            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Theaters theater = new Theaters(rs.getInt(1), rs.getString(2), rs.getString(3));
                System.out.println(theater.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
