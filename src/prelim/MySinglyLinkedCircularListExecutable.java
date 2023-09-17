package prelim;

import prelim.implementations.MySinglyLinkedCircularList;
import prelim.implementations.MySinglyLinkedList;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MySinglyLinkedCircularListExecutable {
    private final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        MySinglyLinkedCircularList<String> singlyCircularList = new MySinglyLinkedCircularList<>();

        singlyCircularList.insert("one");
        singlyCircularList.insert("two");
        singlyCircularList.insert("three");
        singlyCircularList.insert("four");
        singlyCircularList.insert("five");

        singlyCircularList.delete("five");

        for (int index = 0; index < singlyCircularList.getSize() + 5; index++)
            System.out.println(singlyCircularList.getElement(index));
    }
}
