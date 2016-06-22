package database;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb_cinema?autoReconnect=true&useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASS = "root";

    private Connection connection;

    /*For statements methods:
    execute for insert, update for update, query for select

    ResultSet res = statement.executeQuery("select * from theaters;");
    statement.addBatch(""); // for multiply queries
    statement.executeBatch(); // for complete multiple queries

    statement.clearBatch(); //clear all batches

    statement.getConnection(); //получаем соединение к базе данных
    */
    Statement statement = null;
    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<ArrayList<String>> getAllMovies() {
        String query = "select name, poster from movies";
        ArrayList<ArrayList<String>> movies = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ArrayList<String> arrayList = new ArrayList<>();
                String name = resultSet.getString("name");
                String poster = resultSet.getString("poster");
                arrayList.add(name);
                arrayList.add(poster);
                movies.add(arrayList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }
}
