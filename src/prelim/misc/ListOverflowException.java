/**
 * @author Leonhard Leung
 * Date: 09/06/2023
 */

package prelim.misc;

public class ListOverflowException extends Throwable {
    public ListOverflowException() {
        super("Maximum Size reached");
        System.out.println("\n- Array overflow detected!!! ");
        System.out.println("- Unable to insert element\n");
    } // end of default constructor
} // end of ListOverflowException class
