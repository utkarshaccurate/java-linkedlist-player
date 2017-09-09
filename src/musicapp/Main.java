package musicapp;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Album hybridT = new Album("hybrid theory");
        hybridT.addSong(new Song("in the end" , 3.27));
        hybridT.addSong(new Song("numb" , 2.27));
        hybridT.addSong(new Song("somewhere I belong" , 2.27));
        
        Album meteora = new Album("meteora");
        meteora.addSong(new Song("Crawling" , 3.36));
        meteora.addSong(new Song("Boleward of broken dreams", 3.36));
        meteora.addSong(new Song("Lies, greed, misery", 4.36));
        
        
        PlayList<Song> playlist = new PlayList<>("good songs");
        playlist.addToPlaylist(hybridT.getSongs().get(0));
        playlist.addToPlaylist(hybridT.getSongs().get(1));
        playlist.addToPlaylist(meteora.getSongs().get(1));
        playlist.addToPlaylist(meteora.getSongs().get(2));
        
        play(playlist.getSong());
    }
    
    
    private static void play(LinkedList<Song> playList){
        ListIterator<Song> itr = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
        }else{
            System.out.println("Now playing : "+itr.next());
            printMenu();
        }
        boolean quit = false;
        boolean forward = true;
        Scanner sc = new Scanner(System.in);
        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();
            
            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    
                    if (!forward) {
                        if (itr.hasNext()) {
                            itr.next();
                        }
                        forward = true;
                    }
                    
                    if (itr.hasNext()) {
                        System.out.println("Now playing : "+itr.next().toString());
                    }else{
                        System.out.println("Reached end of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    
                    if(forward) {
                        if(itr.hasPrevious()) {
                            itr.previous();
                        }
                        forward = false;
                    }
                    
                    if(itr.hasPrevious()) {
                        System.out.println("Now playing : " + itr.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                    
                    
                case 3:
                    if (forward) {
                        if (itr.hasPrevious()) {
                            System.out.println("Re-playing : " + itr.previous().toString());
                        }else{
                            System.out.println("At the start of list");
                        }
                    } else {
                        if (itr.hasNext()) {
                            System.out.println("Re-playing : " + itr.next().toString());
                        }else{
                            System.out.println("At the end of list");
                        }
                    }
                    
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        itr.remove();
                        if (itr.hasNext()) {
                            System.out.println("Now playing : " + itr.next().toString());
                        }else if (itr.hasPrevious()) {
                            System.out.println("Now playing : " + itr.previous().toString());
                        }else{
                            System.out.println("Nothing to play");
                        }
                    }
                    break;
                default:
                    break;
            }
        }   
        
    }
    
    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }


    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }

    
}
