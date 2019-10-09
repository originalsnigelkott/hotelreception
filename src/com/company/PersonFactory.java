package com.company;

public class PersonFactory {
    public enum PersonType {
        GUEST,
        CLEANER,
        RECEPTIONIST,
        MANAGER,
    }

    public Person createPerson(PersonType personType, String firstname, String lastName, String dateOfBirth) {
        switch (personType) {
            case GUEST: {
                return new Guest(firstname, lastName, dateOfBirth, "");
            }
            case CLEANER: {
                return new Cleaner(firstname, lastName, dateOfBirth, 0, 0);
            }
            case RECEPTIONIST: {
                return new Receptionist(firstname, lastName, dateOfBirth, 0, 0);
            }
            case MANAGER: {
                return new Manager(firstname, lastName, dateOfBirth, 0, 0);
            }
            default: {
                return null;
            }
        }
    }
}
