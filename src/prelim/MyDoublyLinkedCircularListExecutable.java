/**
 * @author Leonhard Leung
 * Date: 09/18/2023
 */

package prelim;

import prelim.implementations.MyDoublyLinkedCircularList;
import prelim.misc.Node;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyDoublyLinkedCircularListExecutable {
    private final Scanner keyboard = new Scanner(System.in);
    MyDoublyLinkedCircularList<Song> doublyCircularList = new MyDoublyLinkedCircularList<>();

    public static void main(String[] args) {
        MyDoublyLinkedCircularListExecutable execute = new MyDoublyLinkedCircularListExecutable();
        try {
            execute.run();
        } catch (NoSuchElementException e) {
            System.out.println("\n- element not found\n");
            System.out.println("Exiting...\n");
            e.printStackTrace();
        }
    } // end of main method

    /**
     * Method that directs the program to a specific operation
     */
    public void run() {
        int selection = 0;
        while (selection != 6) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addSong();
                case 2 -> removeSong();
                case 3 -> findSong();
                case 4 -> showPlaylist();
                case 5 -> playSongs();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    /**
     * Method that adds a song to a list
     */
    public void addSong() {
        String title, artist, album, genre, duration;

        System.out.println("\nADD A SONG");
        do {
            title = readString(">>> Enter song title: ");
            artist = readString(">>> Enter artist name: ");
            album = readString(">>> Enter album title: ");
            genre = readString(">>> Enter song genre: ");
            duration = readString(">>> Enter song duration: ");

            doublyCircularList.insert(new Song(title, artist, album, genre, duration));

            System.out.print("\nDo you want to add another song? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addMusic method

    /**
     * Method that removes a song in a list
     */
    public void removeSong() {
        String title, artist;

        System.out.println("\nREMOVE A SONG");
        do {
            showPlaylist();
            title = readString(">>> Song title: ");
            artist = readString(">>> Artist name: ");

            boolean successfulDeletion = doublyCircularList.delete(doublyCircularList.getElement(new Song(title, artist)));
            System.out.println(successfulDeletion ? ("\n- " + title + " has been removed") :
                    ("\n- " + title + " has not been removed"));

            System.out.print("\nDo you want to remove another song? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of removeSong method

    /**
     * Method that searches and displays an element in the list
     */
    public void findSong() {
        String title, artist;

        System.out.println("\nFIND A SONG");
        do {
            title = readString(">>> Song title: ");
            artist = readString(">>> Artist name: ");

            Song song = doublyCircularList.getElement(new Song(title, artist));

            int index = doublyCircularList.search(song);
            if (index != -1) {
                System.out.println("\n- found a match at position " + (index + 1) + " from the list");
                System.out.println("\nDetails");
                System.out.println("============================");
                System.out.println(song.toString());
            }
            System.out.print("Do you want to find another song? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of findSong method

    /**
     * Method that displays the songs to be played in order
     */
    public void playSongs() {
        subMenu();
        int limit = 0;
        switch (Integer.parseInt(readString("Enter among the choices above: "))) {
            case 1 -> limit = doublyCircularList.getSize();
            case 2 -> limit = Integer.parseInt(readString(">>> Number of songs to be played: "));
        }
        boolean order = readString(">>> Play queue starting from the recently added song? <y/n>: ")
                .equalsIgnoreCase("y");

        Node<Song> playlist = doublyCircularList.getLastNode(order);
        Song element = playlist.getData();

        System.out.println("\nNow playing");
        System.out.printf("\t%-40s%-40s%-40s%-13s%n", element.getTitle(), element.getArtist(), element.getAlbum(),
                element.getDuration());

        System.out.println("\nNext from playlist");
        for (int i = 1; i < limit; i++) {
            if (order)
                playlist = playlist.getPrevious();
            else
                playlist = playlist.getNext();

            element = playlist.getData();

            System.out.printf("\t%-40s%-40s%-40s%-13s%n", element.getTitle(), element.getArtist(), element.getAlbum(),
                    element.getDuration());
        }
        System.out.println();
    } // end of playSongs method

    /**
     * Method that reads the input of the user
     * @param promptMessage message to be shown to the user
     * @return input of the user of type String
     */
    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method

    /**
     * Method that displays the menu
     */
    public void menu() {
        System.out.println("==============================================");
        System.out.println("|                 Harmony Hub                |");
        System.out.println("|   --------------------------------------   |");
        System.out.println("|     1. Add a song to the playlist          |");
        System.out.println("|     2. Remove a song from the playlist     |");
        System.out.println("|     3. Find a song in the playlist         |");
        System.out.println("|     4. View songs in the playlist          |");
        System.out.println("|     5. Play queue                          |");
        System.out.println("|     6. Exit program                        |");
        System.out.println("==============================================");
    } // end of menu method

    /**
     * Method that displays the menu for the playSongs() method
     */
    public void subMenu() {
        System.out.println("\n-----------< My Playlist >------------");
        System.out.println("|   1. Play all songs in playlist    |");
        System.out.println("|   2. Play songs with queue limit   |");
        System.out.println("--------------------------------------");
    } // end of subMenu method

    /**
     * Method that displays the list
     */
    public void showPlaylist() {
        Node<Song> playlist = doublyCircularList.getLastNode(false);
        System.out.println("\n--------------------------------------------------------------------------------------" +
                "-----------------------------------------------------------");
        System.out.println("                                                              Harmony Hub Playlist      " +
                "                                                         ");
        System.out.println("----------------------------------------------------------------------------------------" +
                "---------------------------------------------------------");
        System.out.printf("%-40s%-40s%-40s%-15s%-13s%n", "Title", "Artist", "Album", "Genre", "Duration");
        System.out.printf("%-40s%-40s%-40s%-15s%-13s%n", "=====================================",
                "=====================================", "=====================================", "============",
                "==========");
        for (int index = 0; index < doublyCircularList.getSize(); index++) {
            Song element = playlist.getData();
            playlist = playlist.getNext();
            System.out.printf("%-40s%-40s%-40s%-15s%-13s%n", element.getTitle(), element.getArtist(),
                    element.getAlbum(), element.getGenre(), element.getDuration());
        }
        System.out.println("----------------------------------------------------------------------------------------" +
                "---------------------------------------------------------\n");
    } // end of showPlaylist method

    /**
     * This class holds the details of a musical piece
     */
    private static class Song {
        private final String title;
        private final String artist;
        private String album;
        private String genre;
        private String duration;

        public Song(String t, String ar, String al, String g, String d) {
            title = t;
            artist = ar;
            album = al;
            genre = g;
            duration = d;
        } // end of constructor

        public Song(String t, String ar) {
            title = t;
            artist = ar;
        } // end of constructor

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public String getAlbum() {
            return album;
        }

        public String getGenre() {
            return genre;
        }

        public String getDuration() {
            return duration;
        }

        /**
         * Override method used to display the details of an element in a list
         * @return detailed information of an element
         */
        @Override
        public String toString() {
            return "Title: " + this.getTitle() + "\n" +
                    "Artist: " + this.getArtist() + "\n" +
                    "Album: " + this.getAlbum() + "\n" +
                    "Genre: " + this.getGenre() + "\n" +
                    "Duration: " + this.getDuration() + "\n";
        } // end of toString method

        /**
         * Override method used to compare two objects of the same data type
         * @param obj object of any type
         * @return boolean value regarding comparison of two objects
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;

            if (!(obj instanceof Song song))
                return false;

            return (this.getTitle() + "," + this.getArtist()).equalsIgnoreCase
                    (song.getTitle() + "," + song.getArtist());
        } // end of equals method
    } // end of Music class
} // end of MyDoublyLinkedCircularListExecutable class
