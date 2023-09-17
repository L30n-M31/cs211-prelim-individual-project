package prelim.implementations;

import prelim.misc.ListOverflowException;
import prelim.misc.MyList;
import prelim.misc.Node;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<T> implements MyList<T> {
    private Node<T> next;
    private int size = 0;

    @Override
    public int getSize() {
        return size;
    } // end of getSize method

    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (next == null) {
            next = newNode;
        }
        else {
            Node<T> currentPointer = next;
            while (currentPointer.getNext() != null) {
                currentPointer = currentPointer.getNext();
            }
            currentPointer.setNext(newNode);
            newNode.setPrevious(currentPointer);
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
                //currentPointer.getNext().setPrevious(previousPointer);
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
    public Node<T> getLastNode(boolean displayLatestFirst) {
        Node<T> current = next;
        if (displayLatestFirst) {
            while (current.getNext() != null) {
                current = current.getNext();
            }
        }
        return current;
    } // end of display method
} // end of MyDoublyLinkedList<T> class
