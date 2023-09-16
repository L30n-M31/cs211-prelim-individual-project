/**
 * @author Leonhard Leung
 * Date: 09/16/2023 (updated)
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

    public void run() throws ListOverflowException {
        int selection = 0;
        while (selection != 5) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addPhone();
                case 2 -> deletePhone();
                case 3 -> viewPhone();
                case 4 -> showList();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    public void addPhone() throws ListOverflowException{
        String brand, model, color, storage;

        System.out.println("\nADD A PHONE");
        do {
            brand = readString(">>> Enter brand: ");
            model = readString(">>> Enter model: ");
            color = readString(">>> Enter color: ");
            storage = readString(">>> Enter storage space: ");

            list.insert(new PhoneList(brand, model, color, storage));

            System.out.print("\nDo you want to add another phone? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addPhone method

    public void deletePhone() {
        String brand, model;

        System.out.println("\nDELETE A PHONE");
        do {
            showList();
            brand = readString(">>> Brand: ");
            model = readString(">>> Model: ");

            boolean successfulDeletion = list.delete(list.getElement(new PhoneList(brand, model)));
            System.out.println(successfulDeletion ? ("\n- " + model + " has been deleted") :
                    ("\n- " + model + " has not been deleted"));

            System.out.print("\nDo you want to delete another phone? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of deletePhone method

    public void viewPhone() {
        String brand, model;

        System.out.println("\nVIEW PHONE DETAILS");
        do {
            brand = readString(">>> Brand: ");
            model = readString(">>> Model: ");

            PhoneList phone = (PhoneList) list.getElement(new PhoneList(brand, model));

            int index = list.search(phone);
            if (index != -1) {
                System.out.println("\n- found a match at position " + (index + 1) + " from the list");
                System.out.println("\nDetails");
                System.out.println("=====================");
                System.out.println(phone.displayDetails());
            }
            System.out.print("Do you want to find another product? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of viewPhone method

    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method

    public void menu() {
        System.out.println("=====================================");
        System.out.println("|             MAIN MENU             |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|     1. Add phone to list          |");
        System.out.println("|     2. Delete phone from list     |");
        System.out.println("|     3. View phone details         |");
        System.out.println("|     4. View list                  |");
        System.out.println("|     5. Exit program               |");
        System.out.println("=====================================");
    } // end of menu method

    public void showList() {
        System.out.println("\n-------------------------------------------");
        System.out.println("                Phone List                 ");
        System.out.println("-------------------------------------------");
        System.out.printf("%-13s%-13s%-10s%-10s%n", "Brand", "Model", "Color", "Storage");
        System.out.printf("%-13s%-13s%-10s%-10s%n", "==========", "==========", "=======", "=======");
        for (int index = 0; index < list.getSize(); index++) {
            PhoneList element = (PhoneList) list.getElement(index);
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
    private static class PhoneList {
        private final String brand;
        private final String model;
        private String color;
        private String storage;

        public PhoneList(String b, String m, String c, String s) {
            brand = b;
            model = m;
            color = c;
            storage = s;
        } // end of constructor

        public PhoneList(String b, String m) {
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

        public String displayDetails() {
            return "Brand: " + this.getBrand() + "\n" +
                    "Model: " + this.getModel() + "\n" +
                    "Color: " + this.getColor() + "\n" +
                    "Storage: " + this.getStorage() + "\n";
        } // end of displayDetails method

        @Override
        public String toString() {
            return brand + "," + model;
        } // end of toString method
    } // end of PhoneList class
} // end of ExecutableOne class