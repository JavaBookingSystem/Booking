package database;

/**
 * Created by Анастасия on 18.06.2016.
 */
public class Theaters {

    private int id;
    private String name;
    private String address;

    public Theaters(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Theaters(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public Theaters() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "\nid: " + id
                                            + "\t address: " + address
                                            + "\t name: " + name;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}
