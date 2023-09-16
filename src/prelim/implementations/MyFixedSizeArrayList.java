/**
 * @author Leonhard Leung
 * Date: 09/16/2023 (updated)
 */

package prelim.implementations;

import prelim.misc.ListOverflowException;
import prelim.misc.MyList;

import java.util.NoSuchElementException;

public class MyFixedSizeArrayList implements MyList<Object> {
    Object[] list = new Object[5];

    @Override
    public int getSize() {
        return list.length;
    }

    @Override
    public void insert(Object data) throws ListOverflowException {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = data;
                return;
            }
        }
        throw new ListOverflowException();
    } // end of insert method

    @Override
    public Object getElement(Object data) throws NoSuchElementException {
        for (Object element : list) {
            if (element != null)
                if (element.toString().equalsIgnoreCase(data.toString()))
                    return element;
        }
        throw new NoSuchElementException();
    } // end of getElement method

    public Object getElement(int index) {
        return list[index];
    } // end of getElement method

    @Override
    public boolean delete(Object data) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null)
                if (list[i].equals(data)) {
                    list[i] = null;
                    return true;
                }
        }
        return false;
    } // end of delete method

    @Override
    public int search(Object data) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null)
                if (list[i].equals(data))
                    return i;
        }
        return -1;
    } // end of search method
} // end of MyFixedSizeArrayList class
