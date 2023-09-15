/**
 * @author Leonhard Leung
 * Date: 09/11/2023
 */

package prelim.implementations;

import prelim.misc.MyList;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements MyList<T> {

    private final T data;
    private MySinglyLinkedList<T> next;
    private int size = 0;

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
        return size;
    }

    @Override
    public void insert(T data) {
        MySinglyLinkedList<T> newNode = new MySinglyLinkedList<>(data);
        if (next == null)
            next = newNode;
        else {
            MySinglyLinkedList<T> currentPointer = next;
            while (currentPointer.getNext() != null)
                currentPointer = currentPointer.getNext();
            currentPointer.setNext(newNode);
        }
        size++;
    } // end of insert method

    @Override
    public T getElement(T data) throws NoSuchElementException {
        MySinglyLinkedList<T> currentPointer = next;
        if (currentPointer.getData().equals(data)) {
            return currentPointer.getData();
        }
        else {
            while (currentPointer.getNext() != null) {
                if (currentPointer.getData().equals(data)) {
                    return currentPointer.getData();
                }
                currentPointer = currentPointer.getNext();
            }
        }
        throw new NoSuchElementException();
    } // end of getElement method

    @Override
    public boolean delete(T data) {
        MySinglyLinkedList<T> currentPointer = next;
        if (currentPointer.getData().equals(data))
            next = currentPointer.getNext();
        else{
            MySinglyLinkedList<T> previousPointer = next;
            while (currentPointer.getNext() != null) {
                if (currentPointer.getData().equals(data)) {
                    previousPointer.setNext(currentPointer.getNext());
                    size--;
                    return true;
                }
                previousPointer = currentPointer;
                currentPointer = currentPointer.getNext();
            }
        }
        return false;
    } // end of delete method

    @Override
    public int search(T data) {
        int index = 0;
        MySinglyLinkedList<T> currentPointer = next;
        while (currentPointer.getNext() != null) {
            if (currentPointer.getData().equals(data))
                return index;
            currentPointer = currentPointer.getNext();
            index++;
        }
        return -1;
    } // end of search method

    public void print() {
        MySinglyLinkedList<T> temp = next;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
} // end of MySinglyLinkedList class
