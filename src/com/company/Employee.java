package com.company;

public abstract class Employee extends Person {

    public enum SortEmployeeBy {
        ID ("EmployeeID"),
        NAME ("Name"),
        DATE_OF_BIRTH ("Date of birth");

        String menuOutput;

        private SortEmployeeBy(String menuOut) {
            this.menuOutput = menuOutput;
        }

    }

    private static SortEmployeeBy sortEmployeeBy;
    private double hourlySalary;
    private double hoursPerWeek;
    private double weeklySalary;
    private int employeeID;
    private String employedAs; //TODO: when listed need to add role
    private static int counter = 0;

    //TODO: add Employee type and sorting mechanism.
    public Employee(String firstName, String lastName, String dateOfBirth, double hourlySalary, double hoursPerWeek) {
        super(firstName, lastName, dateOfBirth);
        this.hourlySalary = hourlySalary;
        this.hoursPerWeek = hoursPerWeek;
        weeklySalary = hoursPerWeek * hourlySalary;
        employeeID = generateEmployeeID();
    }

    private int generateEmployeeID() {
        counter++;
        String employeeID = null;
        if (counter < 10) {
            employeeID = "1000" + counter;
        } else if (counter < 100) {
            employeeID = "100" + counter;
        } else if (counter < 1000) {
            employeeID = "10" + counter;
        } else if (counter < 10000) {
            employeeID = "1" + counter;
        }
        return Integer.parseInt(employeeID);
    }

    @Override
    public String toString() {
        String output = String.format("" +
                        "EmployeeID: %d\n" +
                        "%s, %s\n" +
                        "Date of birth: %s\n" +
                        "Salary: %.2f\n" +
                        "Hours/week: %.2f\n" +
                        "-----------------------"
                , employeeID, super.getLastName(), super.getFirstName(), super.getDateOfBirth(), weeklySalary, hoursPerWeek);
        return output;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setSortEmployeeBy(SortEmployeeBy sortEmployeeBy) {
        this.sortEmployeeBy = sortEmployeeBy;
    }
}
