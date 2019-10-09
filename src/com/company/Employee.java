package com.company;

public abstract class Employee extends Person{
    private double hourlySalary;
    private double hoursPerWeek;
    private double weeklySalary;

    public Employee(String firstName, String lastName, String dateOfBirth, double hourlySalary, double hoursPerWeek) {
        super(firstName, lastName, dateOfBirth);
        this.hourlySalary = hourlySalary;
        this.hoursPerWeek = hoursPerWeek;
        weeklySalary = hoursPerWeek * hourlySalary;
    }
}
