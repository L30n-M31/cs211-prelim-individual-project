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
        MySinglyLinkedList<T> newNode = new MySinglyLinkedList<>(data);
        if (next == null)
            next = newNode;
        else {
            MySinglyLinkedList<T> pointer = next;
            while (pointer.getNext() != null)
                pointer = pointer.getNext();
            pointer.setNext(newNode);
        }
    } // end of insert method

    @Override
    public T getElement(T data) throws NoSuchElementException {
        return null;
    } // end of getElement method

    @Override
    public boolean delete(T data) {
        MySinglyLinkedList<T> pointer = next;
        if (next.getData().equals(data))
            next = pointer.getNext();
        else{
            while (pointer.getNext() != null) {
                if (pointer.getNext().getData().equals(data)) {
                    pointer.setNext(pointer.getNext().getNext());
                    return true;
                }
                pointer = pointer.getNext();
            }
        }
        return false;
    } // end of delete method

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
