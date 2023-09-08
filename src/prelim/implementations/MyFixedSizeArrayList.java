/**
 * @author Leonhard Leung
 * Date: 09/06/2023
 */

package prelim.implementations;

import prelim.misc.ListOverflowException;
import prelim.misc.MyList;

import java.util.NoSuchElementException;

public class MyFixedSizeArrayList implements MyList<MyFixedSizeArrayList> {
    private final String product;
    private final String brand;
    private final String serialNumber;
    private String color;
    private String weight;
    private final MyFixedSizeArrayList[] array = new MyFixedSizeArrayList[5];

    public MyFixedSizeArrayList() {
        product = null;
        brand = null;
        serialNumber = null;
        color = null;
        weight = null;
    } // end of default constructor

    public MyFixedSizeArrayList(String p, String b, String s, String c, String w) {
        product = p;
        brand = b;
        serialNumber = s;
        color = c;
        weight = w;
    } // end of constructor

    public MyFixedSizeArrayList(String p, String b, String s) {
        product = p;
        brand = b;
        serialNumber = s;
    } // end of constructor

    public String getProduct() {
        return product;
    }

    public String getBrand() {
        return brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getColor() {
        return color;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public int getSize() {
        return array.length;
    } // end of getSize method

    @Override
    public void insert(MyFixedSizeArrayList data) {
        int i = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == null) {
                i = index;
                break;
            }
            i++;
        }
        array[i] = data;
    } // end of insert method

    @Override
    public MyFixedSizeArrayList getElement(MyFixedSizeArrayList data) throws NoSuchElementException {
        for (MyFixedSizeArrayList element : array) {
            if (element != null) {
                if (element.getProduct().equalsIgnoreCase(data.getProduct()) &&
                        element.getBrand().equalsIgnoreCase(data.getBrand()) &&
                        element.getSerialNumber().equalsIgnoreCase(data.getSerialNumber()))
                    return element;
            }
        }
        return null;
    } // end of getElement method

    @Override
    public boolean delete(MyFixedSizeArrayList data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(data)) {
                array[i] = null;
                return true;
            }
        }
        return false;
    } // end of delete method

    @Override
    public int search(MyFixedSizeArrayList data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].getProduct().equalsIgnoreCase(data.getProduct()) &&
                        array[i].getBrand().equalsIgnoreCase(data.getBrand()) &&
                        array[i].getSerialNumber().equalsIgnoreCase(data.getSerialNumber())) {
                    return i;
                }
            }
        }
        return -1;
    } // end of search method

    /*
     * Just to test if the methods are working
     */
    public void showList() {
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("                           Current List                             ");
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-15s%-13s%-17s%-10s%-13s%n", "Product", "Brand", "Series No.", "Color", "Weight (g)");
        System.out.printf("%-15s%-13s%-17s%-10s%-10s%n", "============", "==========", "==============",
                "=======", "=============");
        for (MyFixedSizeArrayList element : array) {
            if (element != null) {
                System.out.printf("%-15s%-13s%-17s%-10s%-10s%n", element.getProduct(), element.getBrand(),
                        element.getSerialNumber(), element.getColor(), element.getWeight());
            } else
                System.out.printf("%-15s%-13s%-17s%-10s%-10s%n", "N/A", "N/A", "N/A", "N/A", "N/A");
        }
        System.out.println("--------------------------------------------------------------------\n");
    } // end of showList method
} // end of MyFixedSizeArrayList class
