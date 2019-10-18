package com.company;

import java.util.Scanner;

public class View {
    public enum MainMenuItem implements MenuOutput {
        ADMINISTRATOR_SUB_MENU("Show admin menu"),
        RECEPTION_SUB_MENU("Show reception menu"),
        LOAD ("Load data from previous session"),
        HELP("Help"),
        QUIT("Quit");

        private String menuOutput;

        MainMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    public enum AdminMenuItem implements MenuOutput {
        HIRE("Hire employee"),
        DISMISS("Dismiss employee"),
        SHOW("Show employees"),
        BACK("Back");

        private String menuOutput;

        AdminMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    public enum EmployeeTypeMenuItem implements MenuOutput {
        CLEANER("Cleaner"),
        MANAGER("Manager"),
        RECEPTIONIST("Receptionist"),
        BACK("Back");

        private String menuOutput;

        EmployeeTypeMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    public enum ShowEmployeeTypeMenuItem implements MenuOutput {
        CLEANER("Show cleaners"),
        MANAGER("Show manager"),
        RECEPTIONIST("Show receptionist"),
        ALL("Show all"),
        SET_SORTING("Set sorting method"),
        BACK("Back");

        private String menuOutput;

        ShowEmployeeTypeMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    public enum SortByMenuItem implements MenuOutput {
        NAME("Sort by name"),
        DATE_OF_BIRTH("Sort by date of birth"),
        ID("Sort by employeeID");

        private String menuOutput;

        SortByMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    public enum ReceptionMenuItem implements MenuOutput {
        ROOMS("Rooms"),
        GUESTS("Guests"),
        BACK("Back");

        String menuOutput;

        ReceptionMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    private static View instance = null;
    private Scanner input = new Scanner(System.in);

    private View() {

    }

    public static View getInstance() {
        if (instance == null) {
            return new View();
        }
        return instance;
    }

    public <E extends MenuOutput> void showMenu(E[] menuItems) {
        int i = 1;
        for (E menuItem :
                menuItems) {
            System.out.printf("%d. %s\n", i, menuItem.getMenuOutput());
            i++;
        }
    }

    public <E> E inputMenuChoice(E[] menuItems) {
        String userInput;
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.menuChoiceIsValid(userInput, menuItems.length));
        return menuItems[Integer.parseInt(userInput) - 1];
    }

    public boolean isConfirmed(String warningMessage) {
        System.out.printf("%s. Do you wish to proceed? (Y/n)\n", warningMessage);
        String userInput = input.nextLine();
        if (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("YES")) {
            return true;
        } else if(userInput.equalsIgnoreCase("N") || userInput.equalsIgnoreCase("NO")) {
            return false;
        } else {
            showErrorMessage("Only yes or no allowed. Try again.");
            return isConfirmed(warningMessage);
        }
    }

    public String inputName(String type) {
        System.out.printf("Enter %s name:\n", type);
        String userInput;
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsValid(userInput));
        return userInput;
    }

    public String inputDateOfBirth() {
        System.out.println("Enter date of birth: (YYYYMMDD)");
        String userInput;
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.dateOfBirthFormatIsCorrect(userInput));
        return userInput;
    }

    public double inputSalary() {
        String userInput;
        System.out.println("Input employees hourly salary: ($$.¢¢ or $$)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsDouble(userInput));
        return Double.parseDouble(userInput);
    }

    public double inputHoursPerWeek() {
        String userInput;
        System.out.println("Input employees work hours/week: (HH or HH.hh)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsDouble(userInput));
        return Double.parseDouble(userInput);
    }

    public int inputEmployeeID() {
        String userInput;
        System.out.println("Input employeeID: (1XXXX)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.employeeIDInputIsValid(userInput));
        return Integer.parseInt(userInput);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showErrorMessage(String errorMessage) {
        String output = String.format("Error: %s", errorMessage);
        System.out.println(output);
    }

    public <E> void showPerson(E person) {
        System.out.println(person);
    }
}
