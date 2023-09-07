/**
 * @author Leonhard Leung
 * Date: 09/06/2023
 */

package prelim;

import prelim.implementations.MyFixedSizeArrayList;
import prelim.misc.ListOverflowException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExecutableOne {
    private final Scanner keyboard = new Scanner(System.in);
    private final MyFixedSizeArrayList list = new MyFixedSizeArrayList();
    public static void main(String[] args) {
        ExecutableOne execute = new ExecutableOne();
        try {
            execute.run();
        } catch (ListOverflowException e1) {
            e1.sendMessage();
        } catch (NoSuchElementException e2) {
            System.out.println("- element is not included in the list");
        }
    } // end of main method

    public void run() throws ListOverflowException, NoSuchElementException {
        int selection = 0;
        while (selection != 4) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addProducts();
                case 2 -> deleteProducts();
            }
        }
        System.out.println("Exiting...");
        System.exit(0);
    } // end of run method

    public void addProducts() throws ListOverflowException{
        String product, brand, serialNumber, color, weight;

        do {
            product = readString("\nProduct: ");
            brand = readString("Brand: ");
            serialNumber = readString("Serial Number: ");
            color = readString("Color: ");
            weight = readString("Weight: ");

            try {
                list.insert(new MyFixedSizeArrayList(product, brand, serialNumber, color, weight));
            } catch (Exception e) {
                throw new ListOverflowException();
            }

            System.out.print("\nDo you want to add another product? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
        list.showArray(); // Just to test if the method is working
    } // end of addProducts method

    public void deleteProducts() throws NoSuchElementException {
        String product, brand, serialNumber;

        product = readString("Enter product: ");
        brand = readString("Enter brand: ");
        serialNumber = readString("Enter serial number: ");

        MyFixedSizeArrayList element = list.getElement(new MyFixedSizeArrayList(product, brand, serialNumber));
        System.out.println(list.delete(element) ? "- Data has been deleted" : "- Data has not been deleted");
        list.showArray(); // Just to test if the method is working
    } // end of deleteProducts method

    public void menu() {
        System.out.println("===================================");
        System.out.println("              MAIN MENU            ");
        System.out.println("   -----------------------------   ");
        System.out.println("    1. Add product to list         ");
        System.out.println("    2. Delete product from list    ");
        System.out.println("    3. Search product from list    ");
        System.out.println("    4. Exit program                ");
        System.out.println("===================================");
    } // end of menu method

    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method
} // end of ExecutableOne class