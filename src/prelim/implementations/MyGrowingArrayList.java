package prelim.implementations;

import prelim.MyGrowingArrayListExecutable;
import prelim.misc.ListOverflowException;
import prelim.misc.MyList;

import java.util.NoSuchElementException;

public class MyGrowingArrayList implements MyList<MyGrowingArrayList> {
    private String projectName;
    private String dateAssigned;
    private String dateSubmitted;

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
        return 0;
    }

    @Override
    public void insert(MyGrowingArrayList data) throws ListOverflowException {

    }

    @Override
    public MyGrowingArrayList getElement(MyGrowingArrayList data) throws NoSuchElementException {
        return null;
    }

    @Override
    public boolean delete(MyGrowingArrayList data) {
        return false;
    }

    @Override
    public int search(MyGrowingArrayList data) {
        return 0;
    }
}
