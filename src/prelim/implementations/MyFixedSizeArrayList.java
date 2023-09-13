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
    private final String model;
    private String color;
    private final MyFixedSizeArrayList[] array = new MyFixedSizeArrayList[5];

    public MyFixedSizeArrayList() {
        product = null;
        brand = null;
        model = null;
        color = null;
    } // end of default constructor

    public MyFixedSizeArrayList(String p, String b, String m, String c) {
        product = p;
        brand = b;
        model = m;
        color = c;
    } // end of constructor

    public MyFixedSizeArrayList(String p, String b, String m) {
        product = p;
        brand = b;
        model = m;
    } // end of constructor

    public String getProduct() {
        return product;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public MyFixedSizeArrayList getElement(int index) {
        return array[index];
    }

    @Override
    public String toString() {
        return "Product: " + this.getProduct() + "\n" +
                "Brand: " + this.getBrand() + "\n" +
                "Model: " + this.getModel() + "\n" +
                "Color: " + this.getColor() + "\n";
    } // end of toString method

    @Override
    public int getSize() {
        return array.length;
    } // end of getSize method

    @Override
    public void insert(MyFixedSizeArrayList data) throws ListOverflowException {
        int i = 0;
        for (int index = 0; index < getSize(); index++) {
            if (array[index] == null) {
                array[index] = data;
                return;
            }
            i++;
        }
        if (i >= array.length) {
            throw new ListOverflowException();
        }
    } // end of insert method

    @Override
    public MyFixedSizeArrayList getElement(MyFixedSizeArrayList data) throws NoSuchElementException {
        for (MyFixedSizeArrayList element : array) {
            if (element != null) {
                if (element.getProduct().equalsIgnoreCase(data.getProduct()) &&
                        element.getBrand().equalsIgnoreCase(data.getBrand()) &&
                        element.getModel().equalsIgnoreCase(data.getModel()))
                    return element;
            }
        }
        throw new NoSuchElementException();
    } // end of getElement method

    @Override
    public boolean delete(MyFixedSizeArrayList data) {
        for (int index = 0; index < getSize(); index++) {
            if (array[index].equals(data)) {
                array[index] = null;
                return true;
            }
        }
        return false;
    } // end of delete method

    @Override
    public int search(MyFixedSizeArrayList data) {
        for (int index = 0; index < getSize(); index++) {
            if (array[index] == data)
                return index;
        }
        return -1;
    } // end of search method
} // end of MyFixedSizeArrayList class
