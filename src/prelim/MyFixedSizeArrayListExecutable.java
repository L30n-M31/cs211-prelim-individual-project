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
    private final MyFixedSizeArrayList list = new MyFixedSizeArrayList();
    private final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws ListOverflowException {
        MyFixedSizeArrayListExecutable execute = new MyFixedSizeArrayListExecutable();
        execute.run();
    } // end of main method

    public void run() throws ListOverflowException {
        int selection = 0;
        while (selection != 5) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addProducts();
                case 2 -> deleteProduct();
                case 3 -> locateProduct();
                case 4 -> showList();
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    public void addProducts() throws ListOverflowException{
        String product, brand, model, color;

        System.out.println("\nADD A PRODUCT");
        do {
            product = readString(">>> Product: ");
            brand = readString(">>> Brand: ");
            model = readString(">>> Model: ");
            color = readString(">>> Color: ");

            list.insert(new MyFixedSizeArrayList(product, brand, model, color));

            System.out.print("\nDo you want to add another product? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addProducts method

    public void deleteProduct() throws NoSuchElementException {
        showList();
        String product, brand, model;

        System.out.println("DELETE A PRODUCT");
        product = readString(">>> Enter product: ");
        brand = readString(">>> Enter brand: ");
        model = readString(">>> Enter model: ");

        MyFixedSizeArrayList element = list.getElement(new MyFixedSizeArrayList(product, brand, model));
        System.out.println(list.delete(element) ? ("\n- " + element.getModel() + " has been deleted") :
                ("\n- " + element.getModel() + " has not been deleted"));
    } // end of deleteProducts method

    public void locateProduct() {
        String product, brand, model;

        System.out.println("\nVIEW PRODUCT DETAILS");
        product = readString(">>> Enter product: ");
        brand = readString(">>> Enter brand: ");
        model = readString(">>> Enter model: ");

        MyFixedSizeArrayList element = list.getElement(new MyFixedSizeArrayList(product, brand, model));

        int index = list.search(element);
        if (index != -1) {
            System.out.println("\n- found a match at position " + (index + 1));
            System.out.println("\nDetails:");
            System.out.println("=====================");
            System.out.println(list.getElement(element).toString());
        }
    } // end of locateProduct method

    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method

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

    public void showList() {
        System.out.println("\n------------------------------------------------");
        System.out.println("                  Current List                  ");
        System.out.println("------------------------------------------------");
        System.out.printf("%-15s%-13s%-13s%-10s%n", "Product", "Brand", "Model", "Color");
        System.out.printf("%-15s%-13s%-13s%-10s%n", "============", "==========", "==========", "=======");
        for (int index = 0; index < list.getSize(); index++) {
            MyFixedSizeArrayList element = list.getElement(index);
            if (element != null) {
                System.out.printf("%-15s%-13s%-13s%-10s%n", element.getProduct(), element.getBrand(),
                        element.getModel(), element.getColor());
            } else
                System.out.printf("%-15s%-13s%-13s%-10s%n", "N/A", "N/A", "N/A", "N/A");
        }
        System.out.println("------------------------------------------------\n");
    } // end of showList method
} // end of ExecutableOne class