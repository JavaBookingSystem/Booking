package database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

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
}
