package prelim;

import prelim.implementations.MySinglyLinkedList;
import prelim.misc.ListOverflowException;

public class MySinglyLinkedListExecutable {
    public static void main(String[] args) {
        MySinglyLinkedList<String> singlyList = new MySinglyLinkedList<>();

        String one = "one";
        String two = "two";
        String three = "three";
        String four = "four";
        String five = "five";

        try {
            singlyList.insert(one);
            singlyList.insert(two);
            singlyList.insert(three);
            singlyList.insert(four);
            singlyList.insert(five);
        } catch (ListOverflowException e) {
            e = new ListOverflowException();
        }

        singlyList.print();
    }
}
