import java.util.ArrayList;

public class DesertIslandPlaylist {
    public static void main(String[] args){

        System.out.println("\n***MY DESERT ISLAND PLAYLIST***");

        // Creating the playlist
        ArrayList<String> playlist = new ArrayList<>();

        // Adding Songs
        playlist.add("Bohemian Rhapsody - Queen");
        playlist.add("Blinding Lights - The Weeknd");
        playlist.add("Lose Yourself - Eminem");
        playlist.add("Thunderstruck - AC/DC");
        playlist.add("Hotel California - Eagles");

        // Printing full playlist
        System.out.println("\nMy Desert Island Playlist:");
        System.out.println(playlist);

        // Removing a song
        playlist.remove("Thunderstruck - AC/DC");
        System.out.println("\nAfter removing one song");
        System.out.println(playlist);

        // Checking size
        System.out.println("\nTotal songs: " + playlist.size());

        // Looping through the playlist
        System.out.println("\nTrack List:");
        for(String song : playlist){
            System.out.println("- " + song);
        }

        // Checking if a song exists
        System.out.println("\nContains Eminem?: " + playlist.contains("Lose Yourself - Eminem"));
    }

}
