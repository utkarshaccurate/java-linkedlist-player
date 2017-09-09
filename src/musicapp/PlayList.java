package musicapp;

import java.util.LinkedList;

public class PlayList<T extends Song> {
    private String name;
    private LinkedList<T> song;

    public PlayList(String name) {
        this.name = name;
        song = new LinkedList<>();
    }
    
    public void addToPlaylist(T s){
        song.add(s);
    }

    public LinkedList<T> getSong() {
        return song;
    }
    
    
    public boolean removeSong(T s){
        T so = findSong(s);
        if (so != null) {
            song.remove(so);
            return true;
        }
        return false;
    }
    
    private T findSong(T s){
        for (T so : song) {
            if (so.getName().equals(s)) {
                return so;
            }
        }
        return null;
    }
}
