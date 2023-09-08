/**
 * @author Leonhard Leung
 * Date: 09/08/2023
 */

package prelim.implementations;

import prelim.misc.MyList;

import java.util.NoSuchElementException;

public class MyGrowingArrayList implements MyList<MyGrowingArrayList> {
    private final String projectName;
    private String dateAssigned;
    private String dateSubmitted;
    private MyGrowingArrayList[] array = new MyGrowingArrayList[5];

    public MyGrowingArrayList() {
        projectName = null;
        dateAssigned = null;
        dateSubmitted = null;
    } // end of default constructor

    public MyGrowingArrayList(String pN, String dA, String dS) {
        projectName = pN;
        dateAssigned = dA;
        dateSubmitted = dS;
    } // end of constructor

    public MyGrowingArrayList(String pN) {
        projectName = pN;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDateAssigned() {
        return dateAssigned;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }


    @Override
    public int getSize() {
        return array.length;
    }

    @Override
    public void insert(MyGrowingArrayList data) {
        int i = 0;
        for (int index = 0; index < array.length; index++) {
            if (index == array.length - 1) {
                array = increaseArraySize(array, getSize());
            }
            if (array[index] == null) {
                i = index;
                break;
            }
            i++;
        }
        array[i] = data;
    } // end of insert method

    @Override
    public MyGrowingArrayList getElement(MyGrowingArrayList data) throws NoSuchElementException {
        for (MyGrowingArrayList element : array) {
            if (element != null) {
                if (element.getProjectName().equalsIgnoreCase(data.getProjectName()))
                    return element;
            }
        }
        return null;
    } // end of getElement method

    @Override
    public boolean delete(MyGrowingArrayList data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(data)) {
                array[i] = null;
                return true;
            }
        }
        return false;
    } // end of delete method

    @Override
    public int search(MyGrowingArrayList data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].getProjectName().equalsIgnoreCase(data.getProjectName()))
                    return i;
            }
        }
        return -1;
    } // end of search method

    public MyGrowingArrayList[] increaseArraySize(MyGrowingArrayList[] oldArray, int length) {
        MyGrowingArrayList[] newArray = new MyGrowingArrayList[length * 2];

        for (int index = 0; index < oldArray.length; index++) {
            newArray[index] = oldArray[index];
        }
        return newArray;
    } // end of increaseArraySize method

    public void showList() {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("                    Current List                       ");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-25s%-16s%-17s%n", "Project", "Date Assigned", "Date Submitted");
        System.out.printf("%-25s%-16s%-17s%n", "======================", "=============", "==============");
        for (MyGrowingArrayList element : array) {
            if (element != null) {
                System.out.printf("%-25s%-16s%-17s%n", element.getProjectName(), element.getDateAssigned(),
                        element.getDateSubmitted());
            }
        }
        System.out.println("-------------------------------------------------------\n");
    } // end of showList method
} // end of MyGrowingArrayList class