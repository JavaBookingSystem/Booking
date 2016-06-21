package database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb_cinema?autoReconnect=true&useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASS = "root";

    private static Connection connection;

    /*For statements methods:
    execute for insert, update for update, query for select

    ResultSet res = statement.executeQuery("select * from theaters;");
    statement.addBatch(""); // for multiply queries
    statement.executeBatch(); // for complete multiple queries

    statement.clearBatch(); //clear all batches

    statement.getConnection(); //получаем соединение к базе данных
    */

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASS);
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

    public static ArrayList<Movies> getMovies() {
        ArrayList<Movies> movies = new ArrayList<>();
        String query = "select * from movies";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Movies movie = new Movies(rs.getInt("id"), rs.getString("name"), rs.getTime("duration"),
                        rs.getDate("end_date"), rs.getDate("start_date"),
                        rs.getString("poster"), rs.getString("description"));
                movies.add(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public static ArrayList<Theaters> getTheaters() {
        ArrayList<Theaters> theaters = new ArrayList<>();
        String query = "select * from theaters";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Theaters theater = new Theaters(rs.getInt("id"), rs.getString("name"),
                        rs.getString("address"));
                theaters.add(theater);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theaters;
    }
}
