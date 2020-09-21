package helpers;

import models.Albums;
import models.PSongs;
import models.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAdapter {
    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://104.237.9.33/dbkoel";
    private static final String USER = "dbuser04";
    private static final String PASSWORD = "pa$$04";

    private static Connection connection = null;
    private static Statement statement = null;

    public static Playlist getPlaylistById(int id){
        Playlist playlist=null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            statement = connection.createStatement();
            String sqlExpression = "select * from playlists p where id = "+id;

            ResultSet resultSet = statement.executeQuery(sqlExpression);

            while (resultSet.next()){
                String name = resultSet.getString("name");
                int playlistId = resultSet.getInt("id");
                playlist = new Playlist(playlistId,name);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found "+e.getMessage());
        } catch (SQLException e) {
            System.out.println("Problems with DB call "+e.getMessage());
        } finally {
            if(connection!=null){
                try{
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return playlist;
    }

    public static List<Playlist> getAllPlaylists(){
        List<Playlist> playlists = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            statement = connection.createStatement();
            String sqlExpression = "select * from playlists p where user_id =9";

            ResultSet resultSet = statement.executeQuery(sqlExpression);

            while (resultSet.next()){
                String name = resultSet.getString("name");
                int playlistId = resultSet.getInt("id");
                Playlist playlist = new Playlist(playlistId,name);
                playlists.add(playlist);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found "+e.getMessage());
        } catch (SQLException e) {
            System.out.println("Problems with DB call "+e.getMessage());
        } finally {
            if(connection!=null){
                try{
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return playlists;
    }

    public static List<Albums> getAllAlbums(){
        List<Albums> albums = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            statement = connection.createStatement();
            String sqlExpression = "select * from albums a";

            ResultSet resultSet = statement.executeQuery(sqlExpression);

            while (resultSet.next()){
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                String cover = resultSet.getString("cover");
                int artist_id = resultSet.getInt("artist_id");
                Albums album = new Albums(id,artist_id,name,cover);
                albums.add(album);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found "+e.getMessage());
        } catch (SQLException e) {
            System.out.println("Problems with DB call "+e.getMessage());
        } finally {
            if(connection!=null){
                try{
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return albums;
    }

    public static List<PSongs> getPlaylistSongs(int id){
        List<PSongs> list = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            statement = connection.createStatement();
            String sqlExpression = "select s.title, s.`length` from playlist_song ps join songs s on ps.song_id =s.id WHERE ps.playlist_id = "+id;

            ResultSet resultSet = statement.executeQuery(sqlExpression);

            while (resultSet.next()){
                String title = resultSet.getString("title");
                double length = resultSet.getDouble("length");
                PSongs ps = new PSongs(title,length);
                list.add(ps);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found "+e.getMessage());
        } catch (SQLException e) {
            System.out.println("Problems with DB call "+e.getMessage());
        } finally {
            if(connection!=null){
                try{
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }
}
