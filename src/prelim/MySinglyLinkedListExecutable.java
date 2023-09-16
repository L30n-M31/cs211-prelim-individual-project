/**
 * @author Leonhard Leung
 * Date: 09/11/2023
 */

package prelim;

import prelim.implementations.MySinglyLinkedList;

import java.util.Scanner;

public class MySinglyLinkedListExecutable {

    private final Scanner keyboard = new Scanner(System.in);
    MySinglyLinkedList<String> singlyList = new MySinglyLinkedList<>();

    public static void main(String[] args) {
        MySinglyLinkedListExecutable execute = new MySinglyLinkedListExecutable();
        execute.run();
    } // end of main method

    public void run() {
        int selection = 0;
        while (selection != 5) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> locateStudent();
                case 4 -> showStudents();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    public void addStudent() {
        System.out.println("\nADD A STUDENT");
        do {
            String name = readString(">>> Enter students' name: ");
            singlyList.insert(name);

            System.out.print("\nDo you want to add another student? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addStudent method

    public void removeStudent() {
        System.out.println("REMOVE A STUDENT");
        do {
            showStudents();
            String name = readString(">>> Name of student: ");
            System.out.println(singlyList.delete(name) ? ("\n- " + name + " has been deleted") :
                    ("\n- " + name + " has not been deleted"));
            System.out.print("\nDo you want to remove another student? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of removeStudent method

    public void locateStudent() {
        System.out.println("\nFIND STUDENT");
        String name = readString(">>> Name of student: ");

        String element = singlyList.getElement(name);
        int index = singlyList.search(element);
        if (index != -1) {
            System.out.println("\n- found a match at position " + (index + 1));
            System.out.println("\nDetails:");
            System.out.println("=====================");
            System.out.println("Student: " + element + "\n");
        }
    } // end of locateStudent method

    public void showStudents() {
        System.out.println("\n--------------------------------");
        System.out.println("         Student List           ");
        System.out.println("--------------------------------");
        for (int index = 0; index < singlyList.getSize(); index++) {
            String element = singlyList.getElement(index);
            System.out.println("\t" + (index + 1) + ". " + element);
        }
        System.out.println("--------------------------------\n");
    } // end of showStudents method

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
} // end of MySinglyLinkedListExecutable class
