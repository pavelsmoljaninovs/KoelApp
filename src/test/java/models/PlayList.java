package models;

public class PlayList {

    public int id;
    public String name;
    public String[] rules;
    public boolean is_smart;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Playlist(String name) {
        this.name = name;
    }

    public Playlist() {

    }


}
