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
    MySinglyLinkedList<StudentList> singlyList = new MySinglyLinkedList<>();

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

    public void addStudent() {
        String firstName, lastName, IDNumber;

        System.out.println("\nADD A STUDENT");
        do {
            firstName = readString(">>> Enter first name: ");
            lastName = readString(">>> Enter last name: ");
            IDNumber = readString(">>> Enter ID number: ");

            singlyList.insertAtHead(new StudentList(firstName, lastName, IDNumber));

            System.out.print("\nDo you want to add another student? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addStudent method

    public void removeStudent() {
        String firstName, lastName;

        System.out.println("\nREMOVE A STUDENT");
        do {
            showList();
            firstName = readString(">>> First name: ");
            lastName = readString(">>> Last name: ");

            boolean successfulDeletion = singlyList.deleteAtHead(singlyList.getElement(new StudentList(firstName, lastName)));
            System.out.println(successfulDeletion ? ("\n- " + firstName + " has been removed") :
                    ("\n- " + firstName + " has not been removed"));

            System.out.print("\nDo you want to remove another student? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of removeStudent method

    public void findStudent() {
        String firstName, lastName;

        System.out.println("\nFIND A STUDENT");
        do {
            firstName = readString(">>> First name: ");
            lastName = readString(">>> Last name: ");

            StudentList student = singlyList.getElement(new StudentList(firstName, lastName));

            int index = singlyList.searchAtHead(student);
            if (index != -1) {
                System.out.println("\n- found a match at position " + (index + 1) + " from the list");
                System.out.println("\nDetails");
                System.out.println("============================");
                System.out.println(student.displayDetails());
            }
            System.out.print("Do you want to find another student? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of findStudent method

    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method

    public void menu() {
        System.out.println("=========================================");
        System.out.println("|              MAIN MENU                |");
        System.out.println("|   ---------------------------------   |");
        System.out.println("|     1. Add a student to list          |");
        System.out.println("|     2. Remove a student from list     |");
        System.out.println("|     3. Find a student from list       |");
        System.out.println("|     4. View list of students          |");
        System.out.println("|     5. Exit program                   |");
        System.out.println("=========================================");
    } // end of menu method

    public void showList() {
        System.out.println("\n------------------------------------------");
        System.out.println("               Student List               ");
        System.out.println("------------------------------------------");
        System.out.printf("%-15s%-16s%-14s%n", "First Name", "Last Name", "ID Number");
        System.out.printf("%-15s%-16s%-14s%n", "============", "=============", "===========");
        for (int index = 0; index < singlyList.getSize(); index++) {
            StudentList element = singlyList.getElement(index);
            System.out.printf("%-15s%-16s%-14s%n", element.getFirstName(), element.getLastName(), element.getIDNumber());
        }
        System.out.println("------------------------------------------\n");
    } // end of showList method

    private static class StudentList {
        private final String firstName;
        private final String lastName;
        private String IDNumber;

        public StudentList(String fN, String lN, String ID) {
            firstName = fN;
            lastName = lN;
            IDNumber = ID;
        } // end of constructor

        public StudentList(String fN, String lN) {
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

        public String displayDetails() {
            return "Name: " + this.getFirstName() + " " + this.getLastName() + "\n" +
                    "ID number: " + this.getIDNumber() + "\n";
        } // end of displayDetails

        @Override
        public String toString() {
            return firstName + "," + lastName;
        } // end of toString method
    } // end of StudentList class
} // end of MySinglyLinkedListExecutable class
