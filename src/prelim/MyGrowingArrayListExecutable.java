/**
 * @author Leung Leonhard
 * Date: 09/16/2023 (updated)
 */

package prelim;

import prelim.implementations.MyGrowingArrayList;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyGrowingArrayListExecutable {
    private final MyGrowingArrayList list = new MyGrowingArrayList();
    private final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        MyGrowingArrayListExecutable execute = new MyGrowingArrayListExecutable();
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
                case 1 -> addTask();
                case 2 -> deleteTask();
                case 3 -> viewTask();
                case 4 -> showList();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    public void addTask() {
        String course, projectName, dateAssigned, dateSubmitted;

        System.out.println("\nADD A PROJECT");
        do {
            course = readString(">>> Enter course: ");
            projectName = readString(">>> Enter project name: ");
            dateAssigned = readString(">>> Enter date assigned: ");
            dateSubmitted = readString(">>> Enter date submitted: ");

            list.insert(new ProjectList(course, projectName, dateAssigned, dateSubmitted));

            System.out.print("\nDo you want to add another project? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addTask method

    public void deleteTask() {
        String course, projectName;

        System.out.println("\nDELETE A PROJECT");
        do {
            showList();
            course = readString(">>> Course: ");
            projectName = readString(">>> Project name: ");

            boolean successfulDeletion = list.delete(list.getElement(new ProjectList(course, projectName)));
            System.out.println(successfulDeletion ? ("\n- " + projectName + " has been deleted") :
                    ("\n- " + projectName + " has not been deleted"));

            System.out.print("\nDo you want to delete another project? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of deleteTask method

    public void viewTask() {
        String course, projectName;

        System.out.println("\nVIEW PROJECT DETAILS");
        do {
            course = readString(">>> Course: ");
            projectName = readString(">>> Project name: ");

            ProjectList project = (ProjectList) list.getElement(new ProjectList(course, projectName));

            int index = list.search(project);
            if (index != -1) {
                System.out.println("\n- found a match at position " + (index + 1) + " from the list");
                System.out.println("\nDetails");
                System.out.println("=====================");
                System.out.println(project.displayDetails());
            }
            System.out.print("Do you want to find another project? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of viewTask method

    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method

    public void menu() {
        System.out.println("=======================================");
        System.out.println("|              MAIN MENU              |");
        System.out.println("|   -------------------------------   |");
        System.out.println("|     1. Add project to list          |");
        System.out.println("|     2. Delete project from list     |");
        System.out.println("|     3. View project details         |");
        System.out.println("|     4. View list                    |");
        System.out.println("|     5. Exit program                 |");
        System.out.println("=======================================");
    } // end of menu method

    public void showList() {
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("                          Project List                            ");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-11s%-25s%-16s%-17s%n", "Course", "Project", "Date Assigned", "Date Submitted");
        System.out.printf("%-11s%-25s%-16s%-17s%n", "========", "======================", "=============", "==============");
        for (int index = 0; index < list.getSize(); index++) {
            ProjectList element = (ProjectList) list.getElement(index);
            if (element != null) {
                System.out.printf("%-11s%-25s%-16s%-17s%n", element.getCourse(), element.getProjectName(),
                        element.getDateAssigned(), element.getDateSubmitted());
            }
        }
        System.out.println("------------------------------------------------------------------\n");
    } // end of showList method

    /**
     * This class holds the details of a school project such as the course, project name, date assigned, and
     * date submitted
     */
    private static class ProjectList {
        private final String course;
        private final String projectName;
        private String dateAssigned;
        private String dateSubmitted;

        public ProjectList(String c, String pN, String dA, String dB) {
            course = c;
            projectName = pN;
            dateAssigned = dA;
            dateSubmitted = dB;
        } // end of constructor

        public ProjectList(String c, String pN) {
            course = c;
            projectName = pN;
        } // end of constructor

        public String getCourse() {
            return course;
        }

        public String getProjectName() {
            return projectName;
        }

        public String getDateAssigned() {
            return dateAssigned;
        }

        public String getDateSubmitted() {
            return dateSubmitted;
        }

        public String displayDetails() {
            return "Course: " + this.getCourse() + "\n" +
                    "Project Name: " + this.getProjectName() + "\n" +
                    "Date Assigned: " + this.getDateAssigned() + "\n" +
                    "Date Submitted: " + this.getDateSubmitted() + "\n";
        } // end of displayDetails

        @Override
        public String toString() {
            return course + "," + projectName;
        } // end of toString method
    } // end of ProjectList class
} // end of MyGrowingArrayListExecutable class
