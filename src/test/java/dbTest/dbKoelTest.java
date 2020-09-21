package dbTest;

import helpers.DbAdapter;
import models.Albums;
import models.PSongs;
import models.Playlist;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class dbKoelTest {
    @Test
    public void getPlaylistById(){
        Playlist pl = DbAdapter.getPlaylistById(7519);
        Assert.assertEquals(pl.id, 7519);
        Assert.assertEquals(pl.name,"Leonardo");
    }

    @Test
    public void getAllPlaylists(){
        List<Playlist> playlists = DbAdapter.getAllPlaylists();
        for (Playlist pl : playlists){
            System.out.println(pl.id + " "+ pl.name);
        }
        Assert.assertTrue(playlists.size()>0);
    }

    @Test
    public void getAllAlbums(){
        List<Albums> albums = DbAdapter.getAllAlbums();
        for (Albums alb : albums){
            System.out.println(alb.id+" "+ alb.artist_id+ " "+alb.name+" "+alb.cover);
        }
    }

    @Test
    public void getPlaylistSongs(){
        List<PSongs> list = DbAdapter.getPlaylistSongs(7620);
        boolean xx=false;
        for (PSongs ps : list){
            if(ps.title.equals("Lesser Faith")){
                xx=true;
                break;
            }
        }
        Assert.assertTrue(xx);
    }
}
