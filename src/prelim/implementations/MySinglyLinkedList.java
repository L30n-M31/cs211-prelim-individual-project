/**
 * @author Leonhard Leung
 * Date: 09/11/2023
 */

package prelim.implementations;

import prelim.misc.MyLinkedList;
import prelim.misc.Node;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements MyLinkedList<T> {
    private Node<T> next;
    private int size = 0;

    @Override
    public int getSize() {
        return size;
    } // end of getSize method

    @Override
    public void insertAtHead(T data) {
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
    } // end of insertAtHead method

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
    public boolean deleteAtHead(T data) {
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
    } // end of deleteAtHead method

    @Override
    public int searchAtHead(T data) {
        Node<T> currentPointer = next;
        for (int i = 0; i < getSize(); i++) {
            if (currentPointer.getData().equals(data))
                return i;
            currentPointer = currentPointer.getNext();
        }
        return -1;
    } // end of searchAtHead method

    @Override
    public void insertAtTail(T data) { } // end of insertAtTail method

    @Override
    public boolean deleteAtTail(T data) {
        return false;
    } // end of deleteAtTail method

    @Override
    public int searchAtTail(T data) {
        return 0;
    } // end of searchAtTail method
} // end of MySinglyLinkedList class
