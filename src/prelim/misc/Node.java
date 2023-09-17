/**
 * @author Leonhard Leung
 * Date: 09/17/2023
 */

package prelim.misc;

public class Node<T> {
    private final T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(T data) {
        this.data = data;
        next = null;
        previous = null;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> node) {
        next = node;
    }

    public void setPrevious(Node<T> node) {
        previous = node;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }
} // end of Node<T> class
