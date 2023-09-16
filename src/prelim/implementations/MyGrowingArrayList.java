/**
 * @author Leonhard Leung
 * Date: 09/16/2023 (updated)
 */

package prelim.implementations;

import prelim.misc.MyList;

import java.util.NoSuchElementException;

public class MyGrowingArrayList implements MyList<Object> {
    Object[] list = new Object[5];

    @Override
    public int getSize() {
        return list.length;
    } // end of getSize method

    @Override
    public void insert(Object data) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = data;
                return;
            }
        }
        list = increaseSize(getSize());
        insert(data);
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

    public Object getElement(int index) { return list[index]; } // end of getElement method

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

    public Object[] increaseSize(int size) {
        Object[] newList = new Object[size * 2];

        System.arraycopy(list, 0, newList, 0, getSize());
        return newList;
    } // end of increaseSize method
} // end of MyGrowingArrayList class