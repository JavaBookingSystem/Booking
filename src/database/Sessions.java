package database;

import java.sql.Date;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class Sessions {

    private int id;
    private int idhall;
    private Date date_time;
    private double ticket_price;
    private int idmovies;
    private int idtheater;

    public Sessions(int id, int idhall, Date date_time, double ticket_price, int idmovies, int idtheater) {
        this.id = id;
        this.idhall = idhall;
        this.date_time = date_time;
        this.ticket_price = ticket_price;
        this.idmovies = idmovies;
        this.idtheater = idtheater;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public int getIdtheater() {
        return idtheater;
    }

    public void setIdtheater(int idtheater) {
        this.idtheater = idtheater;
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    public Sessions() {
    }

    public Sessions(int idhall, Date date_time, double price, int idmovies) {

        this.idhall = idhall;
        this.date_time = date_time;
        this.ticket_price = price;
        this.idmovies = idmovies;
    }

    public Sessions(int id, int idhall, Date date_time, double price, int idmovies) {

        this.id = id;
        this.idhall = idhall;
        this.date_time = date_time;
        this.ticket_price = price;
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
        return ticket_price;
    }

    public void setPrice(double price) {
        this.ticket_price = price;
    }

    public int getIdmovies() {
        return idmovies;
    }

    public void setIdmovies(int idmovies) {
        this.idmovies = idmovies;
    }

    public String getDateToString() {
        return date_time.toString();
    }
}
