package database;

import java.sql.Date;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class Sessions {

    private int id;
    private int idhall;
    private Date date;
    private int idmovies;

    public Sessions(int idhall, Date date, int idmovies) {

        this.idhall = idhall;
        this.date = date;
        this.idmovies = idmovies;
    }

    public Sessions(int id, int idhall, Date date, int idmovies) {

        this.id = id;
        this.idhall = idhall;
        this.date = date;
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
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdmovies() {
        return idmovies;
    }

    public void setIdmovies(int idmovies) {
        this.idmovies = idmovies;
    }
}
