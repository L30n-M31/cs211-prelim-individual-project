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
    private String modelNumber;
    private String color;
    private String weight;
    private MyFixedSizeArrayList[] array = new MyFixedSizeArrayList[5];
    private int index = 0;

    public MyFixedSizeArrayList() {
        product = null;
        modelNumber = null;
        color = null;
        weight = null;
    } // end of default constructor

    public MyFixedSizeArrayList(String p, String m, String c, String w) {
        product = p;
        modelNumber = m;
        color = c;
        weight = w;
    } // end of constructor

    @Override
    public int getSize() {
        return array.length;
    } // end of getSize method

    @Override
    public void insert(MyFixedSizeArrayList data) throws ListOverflowException {
        array[index] = data;
        index++;
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
            if (array[i].equals(data))
                return i;
        }
        return -1;
    } // end of search method
} // end of MyFixedSizeArrayList class
