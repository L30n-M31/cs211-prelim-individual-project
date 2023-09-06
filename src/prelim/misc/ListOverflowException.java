/**
 * @author Leonhard Leung
 * Date: 09/06/2023
 */

package prelim.misc;

import java.lang.Throwable;

public class ListOverflowException extends Throwable {
    public void sendMessage() {
        System.out.println("- Array overflow detected!!!");
        System.out.println("- Unable to insert element into array");
    } // end of sendExceptionMessage method
} // end of ListOverflowException class
