/**
 * @author Leonhard Leung
 * Date: 09/06/2023
 */

package prelim.implementations;

import prelim.misc.ListOverflowException;

public class MyFixedSizeArrayList {
    private String product;
    private String modelNumber;
    private String color;
    private String weight;
    private MyFixedSizeArrayList[] array = new MyFixedSizeArrayList[5];
    private MyFixedSizeArrayList element;
    private int index = 0;

    public MyFixedSizeArrayList(String p, String m, String c, String w) {
        product = p;
        modelNumber = m;
        color = c;
        weight = w;
    } // end of constructor
} // end of MyFixedSizeArrayList class
