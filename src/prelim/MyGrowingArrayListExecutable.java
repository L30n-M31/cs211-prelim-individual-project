/**
 * @author Leung Leonhard
 * Date: 09/08/2023
 */

package prelim;

import prelim.implementations.MyGrowingArrayList;
import prelim.misc.ListOverflowException;

import java.util.Scanner;

public class MyGrowingArrayListExecutable {
    private final Scanner keyboard = new Scanner(System.in);
    private final MyGrowingArrayList list = new MyGrowingArrayList();

    public static void main(String[] args) {
        MyGrowingArrayListExecutable execute = new MyGrowingArrayListExecutable();
        try {
            execute.run();
        } catch (ListOverflowException e1) {
            e1.sendMessage();
        }
    } // end of main method

    public void run() throws ListOverflowException {
        int selection = 0;
        while (selection != 4) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addTasks();
                case 2 -> deleteTask();
                case 3 -> list.showList();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    public void addTasks() throws ListOverflowException {
        String projectName, dateAssigned, dateSubmitted;

        System.out.println("\nADD A TASK");
        do {
            projectName = readString(">>> Project Name: ");
            dateAssigned = readString(">>> Date Assigned: ");
            dateSubmitted = readString(">>> Date Submitted: ");

            try {
                list.insert(new MyGrowingArrayList(projectName, dateAssigned, dateSubmitted));
            } catch (Exception e) {
                throw new ListOverflowException();
            }
            System.out.print("\nDo you want to add another task? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addTasks method

    public void deleteTask() {
        list.showList();
        String projectName;

        System.out.println("DELETE A TASK");
        projectName = readString(">>> Enter Project Name: ");

        MyGrowingArrayList element = list.getElement(new MyGrowingArrayList(projectName));
        System.out.println(list.delete(element) ? "\n- Task has been deleted" : "\n- Task has not been deleted");
    } // end of deleteTask method

    public void menu() {
        System.out.println("===============================================");
        System.out.println("|                   MAIN MENU                 |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|     1. Add completed tasks to list          |");
        System.out.println("|     2. Delete completed tasks from list     |");
        System.out.println("|     3. View all completed tasks             |");
        System.out.println("|     4. Exit program                         |");
        System.out.println("===============================================");
    } // end of menu method

    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method

} // end of MyGrowingArrayListExecutable class
