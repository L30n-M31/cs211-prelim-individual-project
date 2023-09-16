package prelim.implementations;

import prelim.misc.ListOverflowException;
import prelim.misc.MyList;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<T> implements MyList<T> {
    private T data;
    private MyDoublyLinkedList<T> next;
    private MyDoublyLinkedList<T> previous;
    private int size = 0;

    public MyDoublyLinkedList() {
        data = null;
        next = null;
        previous = null;
    }

    public MyDoublyLinkedList(T data) {
        this.data = data;
        previous = next;
        next = null;
    }

    public T getData() {
        return data;
    }

    public void setNext(MyDoublyLinkedList<T> node) {
        next = node;
    }

    public void setPrevious(MyDoublyLinkedList<T> node) {
        previous = node;
    }

    public MyDoublyLinkedList<T> getNext() {
        return next;
    }

    public MyDoublyLinkedList<T> getPrevious() {
        return previous;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void insert(T data) throws ListOverflowException {

    }

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
}
