package models;

public class Albums {
    public int id;
    public int artist_id;
    public String name;
    public String cover;

    public Albums(int id, int artist_id, String name, String cover) {
        this.id = id;
        this.artist_id = artist_id;
        this.name = name;
        this.cover = cover;
    }
}
