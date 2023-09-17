/**
 * @author Leonhard Leung
 * Date: 09/11/2023
 */

package prelim.implementations;

import prelim.misc.MyList;
import prelim.misc.Node;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements MyList<T> {
    private Node<T> next;
    private int size = 0;

    @Override
    public int getSize() {
        return size;
    } // end of getSize method

    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (next == null)
            next = newNode;
        else {
            Node<T> currentPointer = next;
            while (currentPointer.getNext() != null)
                currentPointer = currentPointer.getNext();
            currentPointer.setNext(newNode);
        }
        size++;
    } // end of insert method

    @Override
    public T getElement(T data) throws NoSuchElementException {
        Node<T> currentPointer = next;
        for (int i = 0; i < getSize(); i++) {
            if (currentPointer.getData().toString().equalsIgnoreCase(data.toString()))
                return currentPointer.getData();
            currentPointer = currentPointer.getNext();
        }
        throw new NoSuchElementException();
    } // end of getElement method

    public T getElement(int index) throws NoSuchElementException {
        Node<T> currentPointer = next;
        for (int i = 0; i < getSize(); i++) {
            if (i == index)
                return currentPointer.getData();
            currentPointer = currentPointer.getNext();
        }
        throw new NoSuchElementException();
    } // end of getElement method

    @Override
    public boolean delete(T data) {
        Node<T> currentPointer = next;
        Node<T> previousPointer = next;
        for (int i = 0; i < getSize(); i++) {
            if (i == 0 && currentPointer.getData().equals(data)) {
                next = currentPointer.getNext();
                size--;
                return true;
            }
            if (currentPointer.getData().equals(data)) {
                previousPointer.setNext(currentPointer.getNext());
                size--;
                return true;
            }
            previousPointer = currentPointer;
            currentPointer = currentPointer.getNext();
        }
        return false;
    } // end of delete method

    @Override
    public int search(T data) {
        Node<T> currentPointer = next;
        for (int i = 0; i < getSize(); i++) {
            if (currentPointer.getData().equals(data))
                return i;
            currentPointer = currentPointer.getNext();
        }
        return -1;
    } // end of search method
} // end of MySinglyLinkedList class
