/**
 * @author Leonhard Leung
 * Date: 09/06/2023
 */

package prelim.misc;

import java.util.NoSuchElementException;

public interface MyList<T> {
    int getSize();
    void insert(T data) throws ListOverflowException;
    T getElement(T data) throws NoSuchElementException;
    boolean delete(T data); // returns false if the data is not deleted in the list
    int search(T data); // returns index of data, else -1 is return
} // end of MyList interface
