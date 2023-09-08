/**
 * @author Leonhard Leung
 * Date: 09/06/2023
 */

package prelim;

import prelim.implementations.MyFixedSizeArrayList;
import prelim.misc.ListOverflowException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyFixedSizeArrayListExecutable {
    private final Scanner keyboard = new Scanner(System.in);
    private final MyFixedSizeArrayList list = new MyFixedSizeArrayList();
    public static void main(String[] args) {
        MyFixedSizeArrayListExecutable execute = new MyFixedSizeArrayListExecutable();
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
        while (selection != 5) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addProducts();
                case 2 -> deleteProducts();
                case 3 -> locateProduct();
                case 4 -> list.showList();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    public void addProducts() throws ListOverflowException{
        String product, brand, serialNumber, color, weight;

        System.out.println("\nADD A PRODUCT");
        do {
            product = readString(">>> Product: ");
            brand = readString(">>> Brand: ");
            serialNumber = readString(">>> Serial Number: ");
            color = readString(">>> Color: ");
            weight = readString(">>> Weight: ");

            try {
                list.insert(new MyFixedSizeArrayList(product, brand, serialNumber, color, weight));
            } catch (Exception e) {
                throw new ListOverflowException();
            }

            System.out.print("\nDo you want to add another product? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addProducts method

    public void deleteProducts() throws NoSuchElementException {
        list.showList();
        String product, brand, serialNumber;

        System.out.println("DELETE A PRODUCT");
        product = readString(">>> Enter product: ");
        brand = readString(">>> Enter brand: ");
        serialNumber = readString(">>> Enter serial number: ");

        MyFixedSizeArrayList element = list.getElement(new MyFixedSizeArrayList(product, brand, serialNumber));
        System.out.println(list.delete(element) ? "\n- Data has been deleted" : "\n- Data has not been deleted");
    } // end of deleteProducts method

    public void locateProduct() {
        String product, brand, serialNumber;

        System.out.println("\nLOCATE PRODUCT");
        product = readString(">>> Enter product: ");
        brand = readString(">>> Enter brand: ");
        serialNumber = readString(">>> Enter serial number: ");

        MyFixedSizeArrayList element = new MyFixedSizeArrayList(product, brand, serialNumber);
        int index = list.search(element);
        if (index != -1)
            System.out.println("\n- The product is number " + (index + 1) + " in the list");
        else
            System.out.println("\n- The product is not included in the list");
    } // end of locateProduct method

    public void menu() {
        System.out.println("=======================================");
        System.out.println("|              MAIN MENU              |");
        System.out.println("|   -------------------------------   |");
        System.out.println("|     1. Add product to list          |");
        System.out.println("|     2. Delete product from list     |");
        System.out.println("|     3. Locate product from list     |");
        System.out.println("|     4. View list                    |");
        System.out.println("|     5. Exit program                 |");
        System.out.println("=======================================");
    } // end of menu method

    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method
} // end of ExecutableOne class