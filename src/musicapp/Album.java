package musicapp;

import java.util.LinkedList;

public class Album {
    private String name;
    LinkedList<Song> songs;

    public Album(String name) {
        this.name = name;
        songs = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }
    
    public boolean addSong(Song s){
        try {
            if (findSong(s.getName()) != null) {
                System.out.println("Song already exists in album");
                return false;
            }else{
                songs.add(s);
                return true;
            }
        } catch (NullPointerException e) {
            System.out.println("Nullpointerexception occured");
            return false;
        }
    }
    
    
    private Song findSong(String s){
        for (Song song : songs) {
            if (song.getName().equals(s)) {
                return song;
            }
        }
        return null;
    }
}
