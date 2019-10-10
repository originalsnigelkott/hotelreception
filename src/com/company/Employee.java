package com.company;

public abstract class Employee extends Person {
    private double hourlySalary;
    private double hoursPerWeek;
    private double weeklySalary;
    private int employeeID;
    private static int counter = 0;

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
}
