package database;

import java.sql.Date;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class Tickets {

    private int id;
    private Date date_release;
    private int idsession;
    private int idseats;
    private double price;
    private boolean ispayed;
    private boolean isbooked;


    public Tickets(Date date_release, int idsession, int idseats, double price, boolean ispayed, boolean isbooked) {

        this.date_release = date_release;
        this.idsession = idsession;
        this.idseats = idseats;
        this.price = price;
        this.ispayed = ispayed;
        this.isbooked = isbooked;
    }

    public Tickets(int id, Date date_release, int idsession, int idseats,
                   double price, boolean ispayed, boolean isbooked) {

        this.id = id;
        this.date_release = date_release;
        this.idsession = idsession;
        this.idseats = idseats;
        this.price = price;
        this.ispayed = ispayed;
        this.isbooked = isbooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_release() {
        return date_release;
    }

    public void setDate_release(Date date_release) {
        this.date_release = date_release;
    }

    public int getIdsession() {
        return idsession;
    }

    public void setIdsession(int idsession) {
        this.idsession = idsession;
    }

    public int getIdseats() {
        return idseats;
    }

    public void setIdseats(int idseats) {
        this.idseats = idseats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean ispayed() {
        return ispayed;
    }

    public void setIspayed(boolean ispayed) {
        this.ispayed = ispayed;
    }

    public boolean isbooked() {
        return isbooked;
    }

    public void setIsbooked(boolean isbooked) {
        this.isbooked = isbooked;
    }
}
