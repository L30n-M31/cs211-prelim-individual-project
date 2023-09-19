/**
 * @author Leonhard Leung
 * Date: 09/16/2023
 */

package prelim;

import prelim.implementations.MyFixedSizeArrayList;
import prelim.misc.ListOverflowException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyFixedSizeArrayListExecutable {
    private final MyFixedSizeArrayList list = new MyFixedSizeArrayList();
    private final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        MyFixedSizeArrayListExecutable execute = new MyFixedSizeArrayListExecutable();
        try {
            execute.run();
        } catch (ListOverflowException e1) {
            System.out.println("Exiting...\n");
            e1.printStackTrace();
        } catch (NoSuchElementException e2) {
            System.out.println("\n- element not found\n");
            System.out.println("Exiting...\n");
            e2.printStackTrace();
        }
    } // end of main method

    /**
     * Method that directs the program to a specific operation
     * @throws ListOverflowException thrown when it receives an exception from one of the invoked methods
     */
    public void run() throws ListOverflowException {
        int selection = 0;
        while (selection != 5) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addPhone();
                case 2 -> removePhone();
                case 3 -> findPhone();
                case 4 -> showList();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    /**
     * Method that adds a phone to an array
     * @throws ListOverflowException thrown when an element is still being inserted to a list at maximum capacity
     */
    public void addPhone() throws ListOverflowException{
        String brand, model, color, storage;

        System.out.println("\nADD A PHONE");
        do {
            brand = readString(">>> Enter brand: ");
            model = readString(">>> Enter model: ");
            color = readString(">>> Enter color: ");
            storage = readString(">>> Enter storage space: ");

            list.insert(new Phone(brand, model, color, storage));

            System.out.print("\nDo you want to add another phone? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addPhone method

    /**
     * Method that removes a phone in an array
     */
    public void removePhone() {
        String brand, model;

        System.out.println("\nREMOVE A PHONE");
        do {
            showList();
            brand = readString(">>> Brand: ");
            model = readString(">>> Model: ");

            boolean successfulDeletion = list.delete(list.getElement(new Phone(brand, model)));
            System.out.println(successfulDeletion ? ("\n- " + model + " has been deleted") :
                    ("\n- " + model + " has not been deleted"));

            System.out.print("\nDo you want to remove another phone? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of removePhone method

    /**
     * Method that searches and displays an element in an array
     */
    public void findPhone() {
        String brand, model;

        System.out.println("\nFIND A PHONE");
        do {
            brand = readString(">>> Brand: ");
            model = readString(">>> Model: ");

            Phone phone = (Phone) list.getElement(new Phone(brand, model));

            int index = list.search(phone);
            if (index != -1) {
                System.out.println("\n- found a match at position " + (index + 1) + " from the list");
                System.out.println("\nDetails");
                System.out.println("=====================");
                System.out.println(phone.toString());
            }
            System.out.print("Do you want to find another phone? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of findPhone method

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
        System.out.println("=========================================");
        System.out.println("|         Mobile Phone Inventory        |");
        System.out.println("|   ---------------------------------   |");
        System.out.println("|     1. Add a phone to the list        |");
        System.out.println("|     2. Remove a phone from the list   |");
        System.out.println("|     3. Find a phone from the list     |");
        System.out.println("|     4. View list of phones            |");
        System.out.println("|     5. Exit program                   |");
        System.out.println("=========================================");
    } // end of menu method

    /**
     * Method that displays the array
     */
    public void showList() {
        System.out.println("\n-------------------------------------------");
        System.out.println("             Mobile Phone List             ");
        System.out.println("-------------------------------------------");
        System.out.printf("%-13s%-13s%-10s%-10s%n", "Brand", "Model", "Color", "Storage");
        System.out.printf("%-13s%-13s%-10s%-10s%n", "==========", "==========", "=======", "=======");
        for (int index = 0; index < list.getSize(); index++) {
            Phone element = (Phone) list.getElement(index);
            if (element != null) {
                System.out.printf("%-13s%-13s%-10s%-10s%n", element.getBrand(), element.getModel(),
                        element.getColor(), element.getStorage());
            }
        }
        System.out.println("-------------------------------------------\n");
    } // end of showList method

    /**
     * This class holds the details of a phone such as the brand, model, color, and storage space
     */
    private static class Phone {
        private final String brand;
        private final String model;
        private String color;
        private String storage;

        public Phone(String b, String m, String c, String s) {
            brand = b;
            model = m;
            color = c;
            storage = s;
        } // end of constructor

        public Phone(String b, String m) {
            brand = b;
            model = m;
        } // end of constructor

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public String getStorage() {
            return storage;
        }

        /**
         * Override method used to display the details of an element in a list
         * @return detailed information of an element
         */
        @Override
        public String toString() {
            return "Brand: " + this.getBrand() + "\n" +
                    "Model: " + this.getModel() + "\n" +
                    "Color: " + this.getColor() + "\n" +
                    "Storage: " + this.getStorage() + "\n";
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

            if (!(obj instanceof Phone phone))
                return false;

            return (this.getBrand() + "," + this.getModel()).equalsIgnoreCase
                    (phone.getBrand() + "," + this.getModel());
        } // end of equals method
    } // end of Phone class
} // end of MyFixedSizeArrayListExecutable class