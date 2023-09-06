/**
 * @author Leonhard Leung
 * Date: 09/06/2023
 */

package prelim;

import prelim.implementations.MyFixedSizeArrayList;
import prelim.misc.ListOverflowException;

import java.util.Scanner;

public class ExecutableOne {
    private Scanner keyboard = new Scanner(System.in);
    private MyFixedSizeArrayList list = new MyFixedSizeArrayList();
    public static void main(String[] args) {
        ExecutableOne execute = new ExecutableOne();
        try {
            execute.run();
        } catch (ListOverflowException e) {
            e.sendMessage();
        }
    } // end of main method

    public void run() throws ListOverflowException {
        int selection = 0;

        while (selection != 4) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addProducts();
                case 2 -> deleteProducts();
            }
        }
    } // end of run method

    public void addProducts() throws ListOverflowException{
        String product, modelNumber, color, weight;

        do {
            product = readString("Product: ");
            modelNumber = readString("Model Number: ");
            color = readString("Color: ");
            weight = readString("Weight: ");

            try {
                list.insert(new MyFixedSizeArrayList(product, modelNumber, color, weight));
            } catch (Exception e) {
                throw new ListOverflowException();
            }

            System.out.print("Do you want to add another product? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addProducts method

    public void deleteProducts() {
        String product, modelNumber;
        int index;

        product = readString("Enter product: ");
        modelNumber = readString("Enter model number: ");

        MyFixedSizeArrayList[] array = list.getArray();
        MyFixedSizeArrayList element = null;

        for (index = 0; index < array.length; index++) {
            if (product.equalsIgnoreCase(array[index].getProduct()) && modelNumber.equalsIgnoreCase(array[index].getModelNumber())) {
                element = list.getElement(array[index]);
            }
        }
        Boolean.parseBoolean(list.delete(element) ? "Data has been deleted" : "Data has not been deleted");
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
}
