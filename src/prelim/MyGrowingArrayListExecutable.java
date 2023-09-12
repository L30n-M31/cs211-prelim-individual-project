/**
 * @author Leung Leonhard
 * Date: 09/08/2023
 */

package prelim;

import prelim.implementations.MyGrowingArrayList;

import java.util.Scanner;

public class MyGrowingArrayListExecutable {
    private final Scanner keyboard = new Scanner(System.in);
    private final MyGrowingArrayList list = new MyGrowingArrayList();

    public static void main(String[] args) {
        MyGrowingArrayListExecutable execute = new MyGrowingArrayListExecutable();
        execute.run();
    } // end of main method

    public void run() {
        int selection = 0;
        while (selection != 5) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addTasks();
                case 2 -> deleteTask();
                case 3 -> locateTask();
                case 4 -> showList();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    public void addTasks() {
        String projectName, dateAssigned, dateSubmitted;

        System.out.println("\nADD A TASK");
        do {
            projectName = readString(">>> Project Name: ");
            dateAssigned = readString(">>> Date Assigned: ");
            dateSubmitted = readString(">>> Date Submitted: ");

            list.insert(new MyGrowingArrayList(projectName, dateAssigned, dateSubmitted));

            System.out.print("\nDo you want to add another task? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addTasks method

    public void deleteTask() {
        showList();
        String projectName;

        System.out.println("DELETE A TASK");
        projectName = readString(">>> Enter project name: ");

        MyGrowingArrayList element = list.getElement(new MyGrowingArrayList(projectName));
        System.out.println(list.delete(element) ? ("\n- " + element.getProjectName() + " has been deleted") :
                ("\n- " + element.getProjectName() + " has not been deleted"));
    } // end of deleteTask method

    public void locateTask() {
        String projectName;

        System.out.println("\nVIEW TASK DETAILS");
        projectName = readString(">>> Enter project name: ");

        MyGrowingArrayList element = list.getElement(new MyGrowingArrayList(projectName));

        int index = list.search(element);
        if (index != 1) {
            System.out.println("\n- found a match at position " + (index + 1));
            System.out.println("\nDetails:");
            System.out.println("=====================");
            System.out.println(list.getElement(element).toString());
        }
    } // end of locateTask method

    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method

    public void menu() {
        System.out.println("===============================================");
        System.out.println("|                   MAIN MENU                 |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|     1. Add completed tasks to list          |");
        System.out.println("|     2. Delete completed tasks from list     |");
        System.out.println("|     3. Locate task from list                |");
        System.out.println("|     4. View all completed tasks             |");
        System.out.println("|     5. Exit program                         |");
        System.out.println("===============================================");
    } // end of menu method

    public void showList() {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("                    Current List                       ");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-25s%-16s%-17s%n", "Project", "Date Assigned", "Date Submitted");
        System.out.printf("%-25s%-16s%-17s%n", "======================", "=============", "==============");
        for (int index = 0; index < list.getSize(); index++) {
            MyGrowingArrayList element = list.getElement(index);
            if (element != null) {
                System.out.printf("%-25s%-16s%-17s%n", element.getProjectName(), element.getDateAssigned(),
                        element.getDateSubmitted());
            }
        }
        System.out.println("-------------------------------------------------------\n");
    } // end of showList method
} // end of MyGrowingArrayListExecutable class
