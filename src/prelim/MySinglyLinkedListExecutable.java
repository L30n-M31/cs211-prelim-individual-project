package prelim;

import prelim.implementations.MySinglyLinkedList;
import prelim.misc.ListOverflowException;

public class MySinglyLinkedListExecutable {
    public static void main(String[] args) throws ListOverflowException{
        MySinglyLinkedList<String> singlyList = new MySinglyLinkedList<>();

        String one = "one";
        String two = "two";
        String three = "three";
        String four = "four";
        String five = "five";

        // insert method test
        singlyList.insert(one);
        singlyList.insert(two);
        singlyList.insert(three);
        singlyList.insert(four);
        singlyList.insert(five);
        singlyList.print();

        // delete method test
        System.out.println();
        singlyList.delete(three);
        singlyList.print();

        // getElement method test
        String element = singlyList.getElement(two);
        System.out.println("\n" + element);

        // search method test
        System.out.println("\nElement found at index: " + singlyList.search(four) + "\t" + "position: " + (singlyList.search(four) + 1));
    }
}
