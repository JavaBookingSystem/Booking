package database;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class Seats {

    private int id;
    private int idhall;
    private int num_row;
    private int num_seat;

    public Seats(int idhall, int num_row, int num_seat) {

        this.idhall = idhall;
        this.num_row = num_row;
        this.num_seat = num_seat;
    }

    public Seats(int id, int idhall, int num_row, int num_seat) {

        this.id = id;
        this.idhall = idhall;
        this.num_row = num_row;
        this.num_seat = num_seat;
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

    public int getNum_row() {
        return num_row;
    }

    public void setNum_row(int num_row) {
        this.num_row = num_row;
    }

    public int getNum_seat() {
        return num_seat;
    }

    public void setNum_seat(int num_seat) {
        this.num_seat = num_seat;
    }
}
