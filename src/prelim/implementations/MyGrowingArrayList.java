package prelim.implementations;

public class MyGrowingArrayList {
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




}
