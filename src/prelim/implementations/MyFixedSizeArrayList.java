/**
 * @author Leonhard Leung
 * Date: 09/06/2023
 */

package prelim.implementations;

import prelim.misc.ListOverflowException;
import prelim.misc.MyList;

import java.util.NoSuchElementException;

public class MyFixedSizeArrayList implements MyList<MyFixedSizeArrayList> {
    private String product;
    private String brand;
    private String serialNumber;
    private String color;
    private String weight;
    private MyFixedSizeArrayList[] array = new MyFixedSizeArrayList[5];

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
    public void insert(MyFixedSizeArrayList data) throws ListOverflowException {
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
            if (element.equals(data))
                return element;
        }
        return null;
    } // end of getElement method

    @Override
    public boolean delete(MyFixedSizeArrayList data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getProduct().equalsIgnoreCase(data.getProduct()) &&
                    array[i].getSerialNumber().equalsIgnoreCase(data.getSerialNumber())) {
                array[i] = null;
                return true;
            }
        }
        return false;
    } // end of delete method

    @Override
    public int search(MyFixedSizeArrayList data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getProduct().equalsIgnoreCase(data.getProduct()) &&
                    array[i].getSerialNumber().equalsIgnoreCase(data.getSerialNumber())) {
                return i;
            }
        }
        return -1;
    } // end of search method

    /*
     * Just to test if the methods are working
     */
    public void showArray() {
        for (MyFixedSizeArrayList element : array) {
            if (element != null) {
                if (element.getProduct().equalsIgnoreCase(""))
                    System.out.println("empty");
                else
                    System.out.println(element.getProduct() + ", " + element.getBrand() + ", " +
                            element.getSerialNumber() + ", " + element.getColor() + ", " + element.getWeight());
            } else
                System.out.println("empty");
        }
    } // end of showArray method
} // end of MyFixedSizeArrayList class
