/**
 * @author Leonhard Leung
 * Date: 09/18/2023
 */

package prelim;

import prelim.implementations.MyDoublyLinkedCircularList;
import prelim.misc.Node;

import java.util.Scanner;

public class MyDoublyLinkedCircularListExecutable {
    public static void main(String[] args) {
        MyDoublyLinkedCircularList<String> doublyCircularList = new MyDoublyLinkedCircularList<>();

        doublyCircularList.insert("One");
        doublyCircularList.insert("Two");
        doublyCircularList.insert("Three");
        doublyCircularList.insert("Four");
        doublyCircularList.insert("Five");


        doublyCircularList.delete("Five");


        Node<String> list = doublyCircularList.getLastNode(true);

        for (int i = 0; i < 15; i++) {
            System.out.println(list.getData());
            list = list.getPrevious();
        }
    }




} // end of MyDoublyLinkedCircularListExecutable class
