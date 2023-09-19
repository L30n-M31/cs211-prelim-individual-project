/**
 * @author Leonhard Leung
 * Date: 09/17/2023
 */

package prelim;

import prelim.implementations.MySinglyLinkedCircularList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MySinglyLinkedCircularListExecutable {
    private final Scanner keyboard = new Scanner(System.in);
    MySinglyLinkedCircularList<Player> singlyCircularList = new MySinglyLinkedCircularList<>();

    public static void main(String[] args) {
        MySinglyLinkedCircularListExecutable execute = new MySinglyLinkedCircularListExecutable();
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
                case 1 -> addPlayer();
                case 2 -> removePlayer();
                case 3 -> findPlayer();
                case 4 -> showTeam();
                case 5 -> determineLineupPerGame();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    /**
     * Method that adds a player to a list
     */
    public void addPlayer() {
        String name, age, nationality;
        double height, weight;

        System.out.println("\nADD A PLAYER");
        do {
            name = readString(">>> Enter name: ");
            age = readString(">>> Enter age: ");
            nationality = readString(">>> Enter nationality: ");
            height = Double.parseDouble(readString(">>> Enter height: "));
            weight = Double.parseDouble(readString(">>> Enter weight: "));

            singlyCircularList.insert(new Player(name, age, nationality, height, weight));

            System.out.print("\nDo you want to add another player? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addPlayer method

    /**
     * Method that removes a student in a list
     */
    public void removePlayer() {
        String name;

        System.out.println("\nREMOVE A PLAYER");
        do {
            showTeam();
            name = readString(">>> Name: ");

            boolean successfulDeletion = singlyCircularList.delete(singlyCircularList.getElement(new Player(name)));
            System.out.println(successfulDeletion ? ("\n- " + name + " has been removed") :
                    ("\n- " + name + " has not been removed"));

            System.out.print("\nDo you want to remove another player? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of removePlayer method

    /**
     * Method that searches and displays an element in the list
     */
    public void findPlayer() {
        String name;

        System.out.println("\nFIND A PLAYER");
        do {
            name = readString(">>> Name: ");

            Player player = singlyCircularList.getElement(new Player(name));

            int index = singlyCircularList.search(player);
            if (index != -1) {
                System.out.println("\n- found a match at position " + (index + 1) + " from the list");
                System.out.println("\nDetails");
                System.out.println("============================");
                System.out.println(player.toString());
            }
            System.out.print("\nDo you want to find another player? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of findPlayer method

    /**
     * Method that demonstrates the circular list by showcasing the rotation of players to be deployed on the field in
     * a game
     */
    public void determineLineupPerGame() {
        System.out.println("\nDETERMINE LINEUP");
        int numberOfGames = Integer.parseInt(readString(">>> Enter number of games: "));
        int onFieldPlayers = 11;
        int nextLineup = 0;

        for (int i = 0; i < numberOfGames; i++) {
            int playerNumber = 0;
            System.out.println("\nGame " + (i + 1));
            System.out.println("==========================");
            for (int start = nextLineup; start < onFieldPlayers; start++, playerNumber ++) {
                System.out.println("Player " + (playerNumber + 1) + ": " + singlyCircularList.getElement(start).getName());
            }
            System.out.println("--------------------------");
            System.out.print(readString(">>> Press enter to see next lineup... "));
            nextLineup += 11;
            onFieldPlayers += 11;
        }
    } // end of determineLineupPerGame method

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
        System.out.println("============================================");
        System.out.println("|            Soccer Team Manager           |");
        System.out.println("|   ------------------------------------   |");
        System.out.println("|     1. Add a player to the team          |");
        System.out.println("|     2. Remove a player from the team     |");
        System.out.println("|     3. Find a player in the team         |");
        System.out.println("|     4. View players in the team          |");
        System.out.println("|     5. Determine lineups per game        |");
        System.out.println("|     6. Exit program                      |");
        System.out.println("============================================");
    } // end of menu method

    /**
     * Method that displays the list
     */
    public void showTeam() {
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("                      List of Players                      ");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-20s%-7s%-15s%-10s%-10s%n", "Name", "Age", "Nationality", "Height", "Weight");
        System.out.printf("%-20s%-7s%-15s%-10s%-10s%n", "=================", "====", "============", "=======",
                "=======");
        for (int index = 0; index < singlyCircularList.getSize(); index++) {
            Player element = singlyCircularList.getElement(index);
            System.out.printf("%-20s%-7s%-15s%-10.2f%-10.2f%n", element.getName(), element.getAge(),
                    element.getNationality(), element.getHeight(), element.getWeight());
        }
        System.out.println("-----------------------------------------------------------\n");
    } // end of showTeam method

    /**
     * This class holds the details of a player such as the name, age, nationality, height, and weight
     */
    private static class Player {
        private final String name;
        private String age;
        private String nationality;
        private double height;
        private double weight;

        public Player(String n, String a, String nat, double h, double w) {
             name = n;
             age = a;
             nationality = nat;
             height = h;
             weight = w;
        } // end of constructor

        public Player(String n) {
            name = n;
        } // end of constructor

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public String getNationality() {
            return nationality;
        }

        public double getHeight() {
            return height;
        }

        public double getWeight() {
            return weight;
        }

        /**
         * Override method used to display the details of an element in a list
         * @return detailed information of an element
         */
        @Override
        public String toString() {
            return "Name: " + this.getName() + "\n" +
                    "Age: " + this.getAge() + "\n" +
                    "Nationality: " + this.getNationality() + "\n" +
                    "Height: " + this.getHeight() + "\n" +
                    "Weight: " + this.getWeight() + "\n";
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

            if (!(obj instanceof Player player))
                return false;

            return this.getName().equalsIgnoreCase(player.getName());
        } // end of equals method
    } // end of Player class
} // end of MySinglyLinkedCircularListExecutable
