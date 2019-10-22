package com.company;

import java.util.Scanner;

/**
 * <h1>View</h1>
 * This singleton class handles all the output and input in the console.
 * @author originalsnigelkott
 * @version 1.0
 */
public class View {
    /**
     * This enum is for showing and choosing main menu options
     */
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

    /**
     * This enum is for showing and choosing admin menu options
     */
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

    /**
     * This enum is for showing and choosing employee type menu options
     */
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

    /**
     * This enum is for showing and choosing show employee menu options
     */
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

    /**
     * This enum is for showing and choosing sorting menu
     */
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

    /**
     * This enum is for showing and choosing reception menu options
     */
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

    /**
     * Contains the instance of the class
     */
    private static View instance = null;
    /**
     * The scanner used for input
     */
    private Scanner input = new Scanner(System.in);

    /**
     * Private constructor for the View class
     */
    private View() {

    }

    /**
     * This method checks if there is an instance of View, if there isn't it creates one, and returns it
     * @return returns the instance of the View class
     */
    public static View getInstance() {
        if (instance == null) {
            return new View();
        }
        return instance;
    }

    /**
     * This method outputs a menu in the console.
     * @param menuItems The menu type to output
     * @param <E> A generic element that implements MenuOutput
     */
    public <E extends MenuOutput> void showMenu(E[] menuItems) {
        int i = 1;
        for (E menuItem :
                menuItems) {
            System.out.printf("%d. %s\n", i, menuItem.getMenuOutput());
            i++;
        }
    }

    /**
     * This method gets the users choice from the menu previously shown
     * @param menuItems The menu to make a choice from
     * @param <E> A generic element
     * @return
     */
    public <E> E inputMenuChoice(E[] menuItems) {
        String userInput;
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.menuChoiceIsValid(userInput, menuItems.length));
        return menuItems[Integer.parseInt(userInput) - 1];
    }

    /**
     * This method outputs a warning message and asks user to confirm their choice
     * @param warningMessage The warning message to be output to user
     * @return Returns true or false based on the users choice
     */
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

    /**
     * This method reads a name from the user
     * @param type This argument is to output first or last in the prompt
     * @return Returns the string input by the user
     */
    public String inputName(String type) {
        System.out.printf("Enter %s name:\n", type);
        String userInput;
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsValid(userInput));
        return userInput;
    }

    /**
     * This method reads a date of birth from the user
     * @return Returns the string input by the user
     */
    public String inputDateOfBirth() {
        System.out.println("Enter date of birth: (YYYYMMDD)");
        String userInput;
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.dateOfBirthFormatIsCorrect(userInput));
        return userInput;
    }

    /**
     * This method reads a salary from the user
     * @return Returns the double input by the user
     */
    public double inputSalary() {
        String userInput;
        System.out.println("Input employees hourly salary: ($$.¢¢ or $$)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsDouble(userInput));
        return Double.parseDouble(userInput);
    }

    /**
     * This method reads a hours worked per week from the user
     * @return Returns the double input by the user
     */
    public double inputHoursPerWeek() {
        String userInput;
        System.out.println("Input employees work hours/week: (HH or HH.hh)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsDouble(userInput));
        return Double.parseDouble(userInput);
    }

    /**
     * This method reads an employee ID from the user
     * @return Returns the integer input byt the user
     */
    public int inputEmployeeID() {
        String userInput;
        System.out.println("Input employeeID: (1XXXX)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.employeeIDInputIsValid(userInput));
        return Integer.parseInt(userInput);
    }

    /**
     * This method prints a message
     * @param message The message to be displayed
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * This method prints an error message
     * @param errorMessage Description of the error that occured.
     */
    public void showErrorMessage(String errorMessage) {
        String output = String.format("Error: %s", errorMessage);
        System.out.println(output);
    }

    /**
     * This method prints toString() method of a person
     * @param person The person to be printed
     * @param <E> A generic element, in this case any element with a toString method
     */
    public <E> void showPerson(E person) {
        System.out.println(person);
    }
}
