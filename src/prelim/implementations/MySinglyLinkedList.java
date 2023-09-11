/**
 * @author Leonhard Leung
 * Date: 09/11/2023
 */

package prelim.implementations;

import prelim.misc.ListOverflowException;
import prelim.misc.MyList;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements MyList<T> {

    private T data;
    private MySinglyLinkedList<T> next;

    public MySinglyLinkedList() {
        data = null;
        next = null;
    }

    public MySinglyLinkedList(T data) {
        this.data = data;
        next = null;
    }

    public T getData() {
        return data;
    }

    public void setNext(MySinglyLinkedList<T> node) {
        next = node;
    }

    public MySinglyLinkedList<T> getNext() {
        return next;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void insert(T data) throws ListOverflowException {
        MySinglyLinkedList<T> newNode = new MySinglyLinkedList<T>(data);
        newNode.next = next;
        next = newNode;
    } // end of insert method

    @Override
    public T getElement(T data) throws NoSuchElementException {
        return null;
    }

    @Override
    public boolean delete(T data) {
        return false;
    }

    @Override
    public int search(T data) {
        return 0;
    }

    public void print() {
        MySinglyLinkedList<T> temp = next;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
} // end of MySinglyLinkedList class
