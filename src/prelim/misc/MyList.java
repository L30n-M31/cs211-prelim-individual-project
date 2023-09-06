/**
 * @author: Leonhard Leung
 * Date: 09/06/2023
 */

package prelim.misc;

import java.util.NoSuchElementException;

public interface MyList<T> {
    public int getSize();
    public void insert(T data) throws ListOverflowException;
    public T getElement(T data) throws NoSuchElementException;
    public boolean delete(T data); // returns false if the data is not deleted in the list
    public int search(T data); // returns index of data, else -1 is return
} // end of MyList interface
