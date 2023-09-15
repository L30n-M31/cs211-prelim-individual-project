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

    public MyGrowingArrayList getElement(int index) {
        return array[index];
    }

    public String toString() {
        return "Project Name: " + this.getProjectName() + "\n" +
                "Date Assigned: " + this.getDateAssigned() + "\n" +
                "Date Submitted: " + this.getDateSubmitted() + "\n";
    } // end of toString method

    @Override
    public int getSize() {
        return array.length;
    } // end of getSize method

    @Override
    public void insert(MyGrowingArrayList data) {
        for (int index = 0; index < getSize(); index++) {
            if (index == array.length - 1) {
                array = increaseArraySize(array, getSize());
            }
            if (array[index] == null) {
                array[index] = data;
                return;
            }
        }
    } // end of insert method

    public MyGrowingArrayList[] increaseArraySize(MyGrowingArrayList[] oldArray, int length) {
        MyGrowingArrayList[] newArray = new MyGrowingArrayList[length * 2];

        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    } // end of increaseArraySize method

    @Override
    public MyGrowingArrayList getElement(MyGrowingArrayList data) throws NoSuchElementException {
        for (MyGrowingArrayList element : array) {
            if (element != null) {
                if (element.getProjectName().equalsIgnoreCase(data.getProjectName()))
                    return element;
            }
        }
        throw new NoSuchElementException();
    } // end of getElement method

    @Override
    public boolean delete(MyGrowingArrayList data) {
        for (int index = 0; index < getSize(); index++) {
            if (array[index] != null) {
                if (array[index].equals(data)) {
                    array[index] = null;
                    return true;
                }
            }
        }
        return false;
    } // end of delete method

    @Override
    public int search(MyGrowingArrayList data) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == data)
                return index;
        }
        return -1;
    } // end of search method
} // end of MyGrowingArrayList class