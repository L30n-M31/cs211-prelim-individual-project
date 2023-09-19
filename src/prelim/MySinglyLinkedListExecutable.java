/**
 * @author Leonhard Leung
 * Date: 09/11/2023
 */

package prelim;

import prelim.implementations.MySinglyLinkedList;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MySinglyLinkedListExecutable {

    private final Scanner keyboard = new Scanner(System.in);
    MySinglyLinkedList<Student> singlyList = new MySinglyLinkedList<>();

    public static void main(String[] args) {
        MySinglyLinkedListExecutable execute = new MySinglyLinkedListExecutable();
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
        while (selection != 5) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> findStudent();
                case 4 -> showList();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    /**
     * Method that adds a student to a list
     */
    public void addStudent() {
        String firstName, lastName, IDNumber;

        System.out.println("\nADD A STUDENT");
        do {
            firstName = readString(">>> Enter first name: ");
            lastName = readString(">>> Enter last name: ");
            IDNumber = readString(">>> Enter ID number: ");

            singlyList.insert(new Student(firstName, lastName, IDNumber));

            System.out.print("\nDo you want to add another student? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addStudent method

    /**
     * Method that removes a student in a list
     */
    public void removeStudent() {
        String firstName, lastName;

        System.out.println("\nREMOVE A STUDENT");
        do {
            showList();
            firstName = readString(">>> First name: ");
            lastName = readString(">>> Last name: ");

            boolean successfulDeletion = singlyList.delete(singlyList.getElement(new Student(firstName, lastName)));
            System.out.println(successfulDeletion ? ("\n- " + firstName + " has been removed") :
                    ("\n- " + firstName + " has not been removed"));

            System.out.print("\nDo you want to remove another student? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of removeStudent method

    /**
     * Method that searches and displays an element in the list
     */
    public void findStudent() {
        String firstName, lastName;

        System.out.println("\nFIND A STUDENT");
        do {
            firstName = readString(">>> First name: ");
            lastName = readString(">>> Last name: ");

            Student student = singlyList.getElement(new Student(firstName, lastName));

            int index = singlyList.search(student);
            if (index != -1) {
                System.out.println("\n- found a match at position " + (index + 1) + " from the list");
                System.out.println("\nDetails");
                System.out.println("============================");
                System.out.println(student.toString());
            }
            System.out.print("Do you want to find another student? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of findStudent method

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
        System.out.println("=============================================");
        System.out.println("|          Student Management List          |");
        System.out.println("|   -------------------------------------   |");
        System.out.println("|     1. Add a student to the list          |");
        System.out.println("|     2. Remove a student from the list     |");
        System.out.println("|     3. Find a student from list           |");
        System.out.println("|     4. View list of students              |");
        System.out.println("|     5. Exit program                       |");
        System.out.println("=============================================");
    } // end of menu method

    /**
     * Method that displays the list
     */
    public void showList() {
        System.out.println("\n------------------------------------------");
        System.out.println("               Student List               ");
        System.out.println("------------------------------------------");
        System.out.printf("%-15s%-16s%-14s%n", "First Name", "Last Name", "ID Number");
        System.out.printf("%-15s%-16s%-14s%n", "============", "=============", "===========");
        for (int index = 0; index < singlyList.getSize(); index++) {
            Student element = singlyList.getElement(index);
            System.out.printf("%-15s%-16s%-14s%n", element.getFirstName(), element.getLastName(), element.getIDNumber());
        }
        System.out.println("------------------------------------------\n");
    } // end of showList method

    /**
     * This class holds the details of a student such as first name, last name, and id number
     */
    private static class Student {
        private final String firstName;
        private final String lastName;
        private String IDNumber;

        public Student(String fN, String lN, String ID) {
            firstName = fN;
            lastName = lN;
            IDNumber = ID;
        } // end of constructor

        public Student(String fN, String lN) {
            firstName = fN;
            lastName = lN;
        } // end of constructor

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getIDNumber() {
            return IDNumber;
        }

        /**
         * Override method used to display the details of an element in a list
         * @return detailed information of an element
         */
        @Override
        public String toString() {
            return "Name: " + this.getFirstName() + " " + this.getLastName() + "\n" +
                    "ID number: " + this.getIDNumber() + "\n";
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

            if (!(obj instanceof Student))
                return false;

            Student student = (Student) obj;

            if ((this.getFirstName() + "," + this.getLastName()).equalsIgnoreCase
                    (student.getFirstName() + "," + student.getLastName()))
                return true;

            return false;
        }
    } // end of Student class
} // end of MySinglyLinkedListExecutable class
