package database;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class Halls {

    private int id;
    private String name;
    private int num_rows;
    private int num_col;


    public Halls(String name, int num_rows, int num_col) {

        this.name = name;
        this.num_rows = num_rows;
        this.num_col = num_col;
    }

    public Halls(int id, String name, int num_rows, int num_col) {

        this.id = id;
        this.name = name;
        this.num_rows = num_rows;
        this.num_col = num_col;
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

    public int getNum_rows() {
        return num_rows;
    }

    public void setNum_rows(int num_rows) {
        this.num_rows = num_rows;
    }

    public int getNum_col() {
        return num_col;
    }

    public void setNum_col(int num_col) {
        this.num_col = num_col;
    }

}
