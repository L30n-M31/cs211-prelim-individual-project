/**
 * @author Leonhard Leung
 * Date: 09/17/2023
 */

package prelim.implementations;

import prelim.misc.MyList;
import prelim.misc.Node;

import java.util.NoSuchElementException;

public class MySinglyLinkedCircularList<T> implements MyList<T> {
    private Node<T> next;
    private int size = 0;

    /**
     * Method for obtaining the size of the list
     * @return size of the list
     */
    @Override
    public int getSize() {
        return size;
    } // end of getSize method

    /**
     * Method for inserting an object to a list
     * @param data object of any type
     */
    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (next == null) {
            next = newNode;
            newNode.setNext(next);
        } else {
            Node<T> currentPointer = next;
            while (currentPointer.getNext() != next)
                currentPointer = currentPointer.getNext();
            currentPointer.setNext(newNode);
            newNode.setNext(next);
        }
        size++;
    } // end of insert method

    /**
     * Method for obtaining an element in a list
     * @param data details of an object
     * @return object that matches the details of the given object in the parameter
     * @throws NoSuchElementException thrown when no such element is found on the list
     */
    @Override
    public T getElement(T data) throws NoSuchElementException {
        Node<T> currentPointer = next;
        do {
            if (currentPointer.getData().equals(data))
                return currentPointer.getData();
            currentPointer = currentPointer.getNext();
        } while (currentPointer != next);
        throw new NoSuchElementException();
    } // end of getElement method

    /**
     * Method for obtaining an element in a list (alternative to the override method)
     * @param index position of the element in the list
     * @return object that matches the position of the given index in the parameter
     * @throws NoSuchElementException thrown when no such element is found on the list
     */
    public T getElement(int index) throws NoSuchElementException {
        Node<T> currentPointer = next;
        for (int i = 0; i < index; i++) {
            currentPointer = currentPointer.getNext();
        }
        if (currentPointer == null)
            throw new NoSuchElementException();

        return currentPointer.getData();
    } // end of getElement method

    /**
     * Method for deleting an element in a list
     * @param data details of an object
     * @return boolean value regarding the successful deletion of the data
     */
    @Override
    public boolean delete(T data) {
        Node<T> currentPointer = next;
        Node<T> previousPointer = null;

        do {
            if (currentPointer.getData().equals(data)) {
                if (previousPointer == null) {
                    if (currentPointer.getNext() == next)
                        next = null;
                    else {
                        next = currentPointer.getNext();
                        Node<T> lastNode = next;
                        while (lastNode.getNext() != currentPointer)
                            lastNode = lastNode.getNext();
                        lastNode.setNext(next);
                    }
                } else {
                    previousPointer.setNext(currentPointer.getNext());
                }
                size--;
                return true;
            }
            previousPointer = currentPointer;
            currentPointer = currentPointer.getNext();
        } while (currentPointer != next);
        return false;
    } // end of delete method

    /**
     * Method for obtaining the position of the element in a list
     * @param data details of an object
     * @return int value that either returns the position of the element or -1 if no such element is found
     */
    @Override
    public int search(T data) {
        int position = 0;
        Node<T> currentPointer = next;
        do {
            if (currentPointer.getData().equals(data))
                return position;
            currentPointer = currentPointer.getNext();
            position++;
        } while (currentPointer != next);
        return -1;
    } // end of search method
} // end of MySinglyLinkedCircularList class
