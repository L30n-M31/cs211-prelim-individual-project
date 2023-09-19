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

    /**
     * Method that directs the program to a specific operation
     */
    public void run() {
        int selection = 0;
        while (selection != 5) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addProject();
                case 2 -> removeProject();
                case 3 -> findProject();
                case 4 -> showList();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    /**
     * Method that adds a project to an array
     */
    public void addProject() {
        String course, projectName, dateAssigned, dateSubmitted;

        System.out.println("\nADD A PROJECT");
        do {
            course = readString(">>> Enter course: ");
            projectName = readString(">>> Enter project name: ");
            dateAssigned = readString(">>> Enter date assigned: ");
            dateSubmitted = readString(">>> Enter date submitted: ");

            list.insert(new Project(course, projectName, dateAssigned, dateSubmitted));

            System.out.print("\nDo you want to add another project? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addProject method

    /**
     * Method that removes a project in an array
     */
    public void removeProject() {
        String course, projectName;

        System.out.println("\nREMOVE A PROJECT");
        do {
            showList();
            course = readString(">>> Course: ");
            projectName = readString(">>> Project name: ");

            boolean successfulDeletion = list.delete(list.getElement(new Project(course, projectName)));
            System.out.println(successfulDeletion ? ("\n- " + projectName + " has been deleted") :
                    ("\n- " + projectName + " has not been deleted"));

            System.out.print("\nDo you want to remove another project? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of removeProject method

    /**
     * Method that searches and displays an element in an array
     */
    public void findProject() {
        String course, projectName;

        System.out.println("\nFIND A PROJECT");
        do {
            course = readString(">>> Course: ");
            projectName = readString(">>> Project name: ");

            Project project = (Project) list.getElement(new Project(course, projectName));

            int index = list.search(project);
            if (index != -1) {
                System.out.println("\n- found a match at position " + (index + 1) + " from the list");
                System.out.println("\nDetails");
                System.out.println("=====================");
                System.out.println(project.toString());
            }
            System.out.print("Do you want to find another project? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of findProject method

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
        System.out.println("|             Project Checklist             |");
        System.out.println("|   -------------------------------------   |");
        System.out.println("|     1. Add a project to the list          |");
        System.out.println("|     2. Remove a project from the list     |");
        System.out.println("|     3. Find a project                     |");
        System.out.println("|     4. View project checklist             |");
        System.out.println("|     5. Exit program                       |");
        System.out.println("=============================================");
    } // end of menu method

    /**
     * Method that displays the array
     */
    public void showList() {
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("                        Project Checklist                         ");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-11s%-25s%-16s%-17s%n", "Course", "Project", "Date Assigned", "Date Submitted");
        System.out.printf("%-11s%-25s%-16s%-17s%n", "========", "======================", "=============", "==============");
        for (int index = 0; index < list.getSize(); index++) {
            Project element = (Project) list.getElement(index);
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
    private static class Project {
        private final String course;
        private final String projectName;
        private String dateAssigned;
        private String dateSubmitted;

        public Project(String c, String pN, String dA, String dB) {
            course = c;
            projectName = pN;
            dateAssigned = dA;
            dateSubmitted = dB;
        } // end of constructor

        public Project(String c, String pN) {
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

        /**
         * Override method used to display the details of an element in a list
         * @return detailed information of an element
         */
        @Override
        public String toString() {
            return "Course: " + this.getCourse() + "\n" +
                    "Project Name: " + this.getProjectName() + "\n" +
                    "Date Assigned: " + this.getDateAssigned() + "\n" +
                    "Date Submitted: " + this.getDateSubmitted() + "\n";
        } // end of toString method

        public boolean equals(Object obj) {
            if (obj == this)
                return true;

            if (!(obj instanceof Project project))
                return false;

            return (this.getCourse() + "," + this.getProjectName()).equalsIgnoreCase(
                    project.getCourse() + "," + project.getProjectName());
        } // end of equals method
    } // end of Project class
} // end of MyGrowingArrayListExecutable class
