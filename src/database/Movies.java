package database;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class Movies {

    private int id;
    private String name;
    private Time duration;
    private Date start_date;
    private Date end_date;
    private int idtheatre;
    private Blob posters;

    public Movies() {
    }


    public Movies(String name, Time duration, Date start_date, Date end_date, int idtheatre) {

        this.name = name;
        this.duration = duration;
        this.start_date = start_date;
        this.end_date = end_date;
        this.idtheatre = idtheatre;
    }

    public Movies(String name, Time duration, Date start_date, Date end_date, int idtheatre, Blob posters) {

        this.name = name;
        this.duration = duration;
        this.start_date = start_date;
        this.end_date = end_date;
        this.idtheatre = idtheatre;
        this.posters = posters;
    }

    public Movies(int id, String name, Time duration, Date start_date, Date end_date, int idtheatre, Blob posters) {

        this.id = id;
        this.name = name;
        this.duration = duration;
        this.start_date = start_date;
        this.end_date = end_date;
        this.idtheatre = idtheatre;
        this.posters = posters;
    }

    public Blob getPosters() {
        return posters;
    }

    public void setPosters(Blob posters) {
        this.posters = posters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getIdtheatre() {
        return idtheatre;
    }

    public void setIdtheatre(int idtheatre) {
        this.idtheatre = idtheatre;
    }
}
