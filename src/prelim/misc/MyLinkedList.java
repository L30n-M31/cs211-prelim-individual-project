/**
 * @author Leonhard Leung
 * Date: 09/17/2023
 */

package prelim.misc;

import java.util.NoSuchElementException;

public interface MyLinkedList<T> {
    int getSize();
    void insertAtHead(T data);
    void insertAtTail(T data);
    T getElement(T data) throws NoSuchElementException;
    T getElement(int index) throws NoSuchElementException;
    boolean deleteAtHead(T data);
    boolean deleteAtTail(T data);
    int searchAtHead(T data);
    int searchAtTail(T data);
} // end of MyLinkedList<T> interface
