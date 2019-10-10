package com.company;

public class PersonFactory {
    public enum PersonType {
        GUEST,
        CLEANER,
        RECEPTIONIST,
        MANAGER,
    }

    public static Person createPerson(PersonType personType) {
        String firstName = View.getInstance().getName("first");
        String lastName = View.getInstance().getName("last");
        String dateOfBirth = View.getInstance().getDateOfBirth();
        switch (personType) {
            case GUEST: {
                return new Guest(firstName, lastName, dateOfBirth, "");
            }
            case CLEANER: {
                Double hourlySalary = View.getInstance().getSalary();
                Double hoursPerWeek = View.getInstance().getHoursPerWeek();
                return new Cleaner(firstName, lastName, dateOfBirth, hourlySalary, hoursPerWeek);
            }
            case RECEPTIONIST: {
                Double hourlySalary = View.getInstance().getSalary();
                Double hoursPerWeek = View.getInstance().getHoursPerWeek();
                return new Receptionist(firstName, lastName, dateOfBirth, hourlySalary, hoursPerWeek);
            }
            case MANAGER: {
                Double hourlySalary = View.getInstance().getSalary();
                Double hoursPerWeek = View.getInstance().getHoursPerWeek();
                return new Manager(firstName, lastName, dateOfBirth, hourlySalary, hoursPerWeek);
            }
            default: {
                return null;
            }
        }
    }
}
