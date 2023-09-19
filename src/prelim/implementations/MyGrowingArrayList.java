/**
 * @author Leonhard Leung
 * Date: 09/16/2023 (updated)
 */

package prelim.implementations;

import prelim.misc.MyList;
import java.util.NoSuchElementException;

public class MyGrowingArrayList implements MyList<Object> {
    Object[] list = new Object[5];

    /**
     * Method for obtaining the size of the array
     * @return size of the array
     */
    @Override
    public int getSize() {
        return list.length;
    } // end of getSize method

    /**
     * Method for inserting an object to an array
     * @param data object of any type
     */
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

    /**
     * Method for obtaining an element in an array
     * @param data details of an object
     * @return object that matches the details of the given object in the parameter
     * @throws NoSuchElementException thrown when no such element is found on the array
     */
    @Override
    public Object getElement(Object data) throws NoSuchElementException {
        for (Object element : list) {
            if (element != null)
                if (element.equals(data))
                    return element;
        }
        throw new NoSuchElementException();
    } // end of getElement method

    /**
     * Method for obtaining an element in an array (alternative to the override method)
     * @param index position of the element in the array
     * @return object that matches the position of the given index in the parameter
     */
    public Object getElement(int index) { return list[index]; } // end of getElement method

    /**
     * Method for deleting an element in an array
     * @param data details of an object
     * @return boolean value regarding the successful deletion of the data
     */
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

    /**
     * Method for obtaining the position of the element in an array
     * @param data details of an object
     * @return int value that either returns the position of the element or a -1 if no such element is found
     */
    @Override
    public int search(Object data) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null)
                if (list[i].equals(data))
                    return i;
        }
        return -1;
    } // end of search method

    /**
     * Method for increasing the size of the array
     * @param size current size of the array
     * @return the new array with an increased size and contains the elements of the old array
     */
    public Object[] increaseSize(int size) {
        Object[] newList = new Object[size * 2];

        System.arraycopy(list, 0, newList, 0, getSize());
        return newList;
    } // end of increaseSize method
} // end of MyGrowingArrayList class