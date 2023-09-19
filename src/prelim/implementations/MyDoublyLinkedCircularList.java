/**
 * @author Leonhard Leung
 * Date: 09/18/2023
 */

package prelim.implementations;

import prelim.misc.MyList;
import prelim.misc.Node;

import java.util.NoSuchElementException;

public class MyDoublyLinkedCircularList<T> implements MyList<T> {
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
        } else {
            Node<T> currentPointer = next;
            while (currentPointer.getNext() != next)
                currentPointer = currentPointer.getNext();

            currentPointer.setNext(newNode);
            newNode.setPrevious(currentPointer);
        }
        newNode.setNext(next);
        next.setPrevious(newNode);
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
     * Method for deleting an element in a list
     * @param data details of an object
     * @return boolean value regarding the successful deletion of the data
     */
    @Override
    public boolean delete(T data) {
        Node<T> currentPointer = next;
        Node<T> previousPointer = next.getPrevious();

        do {
            if (currentPointer.getData().equals(data)) {
                if (previousPointer == next.getPrevious()) {
                    if (currentPointer.getNext() == next)
                        next = null;
                    else {
                        next = currentPointer.getNext();
                        Node<T> lastNode = next;
                        while (lastNode.getNext() != currentPointer)
                            lastNode = lastNode.getNext();
                        lastNode.setNext(next);
                        next.setPrevious(lastNode);
                    }
                } else {
                    previousPointer.setNext(currentPointer.getNext());
                    currentPointer.getNext().setPrevious(previousPointer);
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
     * @return int value that either returns the position of the element or a -1 if no such element is found
     */
    @Override
    public int search(T data) {
        // I just searched from the tail going to the head instead to make use of the doubly-linked list
        int position = getSize() - 1;
        Node<T> currentPointer = next.getPrevious();
        do {
            if (currentPointer.getData().equals(data))
                return position;
            currentPointer = currentPointer.getPrevious();
            position--;
        } while (currentPointer != next.getPrevious());
        return -1;
    } // end of search method

    /**
     * Method for obtaining either the first node or the last node of the list
     * @param displayLatestFirst boolean value regarding how the data wll be displayed (i.e. ascending or descending)
     * @return one of the node at the two ends of the list (i.e. first node or last node)
     */
    public Node<T> getLastNode(boolean displayLatestFirst) {
        Node<T> current = next;
        if (displayLatestFirst) {
            while (current.getNext() != next) {
                current = current.getNext();
            }
        }
        return current;
    } // end of getLastNode method
} // end of MyDoublyLinkedCircularList class
