/**
 * @author Leonhard Leung
 * Date: 09/17/2023
 */

package prelim;

import prelim.implementations.MyDoublyLinkedList;
import prelim.misc.Node;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyDoublyLinkedListExecutable {

    private final Scanner keyboard = new Scanner(System.in);
    MyDoublyLinkedList<Book> doublyList = new MyDoublyLinkedList<>();

    public static void main(String[] args) {
        MyDoublyLinkedListExecutable execute = new MyDoublyLinkedListExecutable();
        try {
            execute.run();
        } catch (NoSuchElementException e) {
            System.out.println("\n- element not found\n");
            System.out.println("Exiting...\n");
            e.printStackTrace();
        }
    } // end of main method

    /**
     * Method that directs the program to a specific operation
     */
    public void run() {
        int selection = 0;
        while (selection != 5) {
            menu();
            selection = Integer.parseInt(readString("Enter among the choices above: "));
            switch (selection) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> findBook();
                case 4 -> showList(true);
            }
        }
        System.out.println("\nExiting...");
        System.exit(0);
    } // end of run method

    /**
     * Method that adds a book to a list
     */
    public void addBook() {
        String borrower, dateBorrowed, bookTitle, bookAuthor, ISBN;

        System.out.println("\nADD A BOOK");
        do {
            borrower = readString(">>> Enter borrower name: ");
            dateBorrowed = readString(">>> Enter date borrowed: ");
            bookTitle = readString(">>> Enter book title: ");
            bookAuthor = readString(">>> Enter book author: ");
            ISBN = readString(">>> Enter ISBN: ");

            doublyList.insert(new Book(borrower, dateBorrowed, bookTitle, bookAuthor, ISBN));

            System.out.print("\nDo you want to add another borrower? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of addBook method

    /**
     * Method that removes a book in a list
     */
    public void removeBook() {
        String bookTitle, bookAuthor;

        System.out.println("\nREMOVE A BOOK");
        do {
            showList(false);
            bookTitle = readString(">>> Book title: ");
            bookAuthor = readString(">>> Book author: ");

            boolean successfulDeletion = doublyList.delete(doublyList.getElement(new Book(bookTitle, bookAuthor)));
            System.out.println(successfulDeletion ? ("\n- " + bookTitle + " has been removed") :
                    ("\n- " + bookTitle + " has not been removed"));

            System.out.print("\nDo you want to remove another borrowed book? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of removeBook method

    /**
     * Method that searches and displays an element in the list
     */
    public void findBook() {
        String bookTitle, bookAuthor;

        System.out.println("\nFIND A BOOK");
        do {
            bookTitle = readString(">>> Book title: ");
            bookAuthor = readString(">>> Book author: ");

            Book book = doublyList.getElement(new Book(bookTitle, bookAuthor));

            int index = doublyList.search(book);
            if (index != -1) {
                System.out.println("\n- found a match at position " + (index + 1) + " from the list");
                System.out.println("\nDetails");
                System.out.println("============================");
                System.out.println(book.toString());
            }
            System.out.print("Do you want to find another book? <y/n>: ");
        } while (keyboard.nextLine().equalsIgnoreCase("y"));
    } // end of findBook method

    /**
     * Method that reads the input of the user
     * @param promptMessage message to be shown to the user
     * @return input of the user of type String
     */
    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return keyboard.nextLine();
    } // end of readString method

    /**
     * Method that displays the menu
     */
    public void menu() {
        System.out.println("==========================================");
        System.out.println("|        Library Borrowing System        |");
        System.out.println("|   ----------------------------------   |");
        System.out.println("|     1. Add a book to the list          |");
        System.out.println("|     2. Remove a book from the list     |");
        System.out.println("|     3. Find a book from the list       |");
        System.out.println("|     4. View list of books              |");
        System.out.println("|     5. Exit program                    |");
        System.out.println("==========================================");
    } // end of menu method

    /**
     * Method that displays the list
     * @param trigger triggers the additional code of the method wherein it asks what order the list will be displayed
     */
    public void showList(boolean trigger) {
        boolean displayLatestFirst = false;
        Node<Book> bookList = doublyList.getLastNode(false);
        if (trigger) {
            displayLatestFirst = (readString("\n>>> Display from recent to oldest? <y/n>: ")
                    .equalsIgnoreCase("y"));
            bookList = doublyList.getLastNode(displayLatestFirst);
        }

        System.out.println("\n-------------------------------------------------------------------------------------");
        System.out.println("                              List of Borrowed Books                                 ");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-18s%-15s%-20s%-15s%n", "Borrower", "Date Borrowed", "Book Title",
                "Book Author", "ISBN");
        System.out.printf("%-20s%-18s%-15s%-20s%-15s%n", "=================", "===============", "============",
                "=================", "============");
        for (int index = 0; index < doublyList.getSize(); index++) {
            Book element = bookList.getData();
            if (displayLatestFirst)
                bookList = bookList.getPrevious();
            else
                bookList = bookList.getNext();
            System.out.printf("%-20s%-18s%-15s%-20s%-15s%n", element.getBorrower(), element.getDateBorrowed(),
                    element.getTitle(), element.getAuthor(), element.getISBN());
        }
        System.out.println("-------------------------------------------------------------------------------------\n");
    } // end of showList method

    /**
     * This class holds the details of a borrowed book such as name of borrower, date borrowed, book title,
     * book author, and ISBN
     */
    private static class Book {
        private String borrower;
        private String dateBorrowed;
        private final String title;
        private final String author;
        private String ISBN;

        public Book(String b, String dB, String t, String a, String i) {
            borrower = b;
            dateBorrowed = dB;
            title = t;
            author = a;
            ISBN = i;
        } // end of constructor

        public Book(String t, String a) {
            title = t;
            author = a;
        } // end of constructor

        public String getBorrower() {
            return borrower;
        }

        public String getDateBorrowed() {
            return dateBorrowed;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getISBN() {
            return ISBN;
        }

        /**
         * Override method used to display the details of an element in a list
         * @return detailed information of an element
         */
        @Override
        public String toString() {
            return "Borrower: " + this.getBorrower() + "\n" +
                    "Date borrowed: " + this.getDateBorrowed() + "\n" +
                    "Title: " + this.getTitle() + "\n" +
                    "Author: " + this.getAuthor() + "\n" +
                    "ISBN: " + this.getISBN() + "\n";
        } // end of toString method

        /**
         * Override method used to compare two objects of the same data type
         * @param obj object of any type
         * @return boolean value regarding comparison of two objects
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;

            if (!(obj instanceof Book))
                return false;

            Book book = (Book) obj;

            return (this.getTitle() + "," + this.getAuthor()).equalsIgnoreCase
                    (book.getTitle() + "," + book.getAuthor());
        } // end of equals method
    } // end of Book class
} // end of MyDoublyLinkedListExecutable class
