package database;

import java.sql.Date;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class Sessions {

    private int id;
    private int idhall;
    private Date date_time;
    private double price;
    private int idmovies;

    public Sessions() {
    }

    public Sessions(int idhall, Date date_time, double price, int idmovies) {

        this.idhall = idhall;
        this.date_time = date_time;
        this.price = price;
        this.idmovies = idmovies;
    }

    public Sessions(int id, int idhall, Date date_time, double price, int idmovies) {

        this.id = id;
        this.idhall = idhall;
        this.date_time = date_time;
        this.price = price;
        this.idmovies = idmovies;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdhall() {
        return idhall;
    }

    public void setIdhall(int idhall) {
        this.idhall = idhall;
    }

    public Date getDate() {
        return date_time;
    }

    public void setDate(Date date) {
        this.date_time = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdmovies() {
        return idmovies;
    }

    public void setIdmovies(int idmovies) {
        this.idmovies = idmovies;
    }
}
