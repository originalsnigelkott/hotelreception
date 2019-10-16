package com.company;

import java.util.Scanner;

public class View {
    public enum MainMenuItem implements MenuOutput {
        ADMINISTRATOR_SUB_MENU ("Show admin menu"),
        RECEPTION_SUB_MENU ("Show reception menu"),
        HELP ("Help"),
        QUIT ("Quit");

        private String menuOutput;
        MainMenuItem(String menuOutput){
            this.menuOutput = menuOutput;
        }

        @Override
        public String getMenuOutput() {
            return menuOutput;
        }
    }

    public enum AdminMenuItem implements MenuOutput {
        HIRE ("Hire employee"),
        DISMISS("Dismiss employee"),
        SHOW ("Show employees"),
        BACK ("Back");

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
        BACK ("Back");

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
        ALL ("Show all"),
        SET_SORTING( "Set sorting method"),
        BACK ("Back");

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
        NAME ("Sort by name"),
        DATE_OF_BIRTH ("Sort by date of birth"),
        ID ("Sort by employeeID");

        private String menuOutput;

        SortByMenuItem(String menuOutput) {
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

    public <E> E inputMenuChoice(E[] menuItems){
        String menuChoice;
        do {
            menuChoice = input.nextLine();
        } while (!FormatCheckers.menuChoiceIsValid(menuChoice, menuItems.length));
        return menuItems[Integer.parseInt(menuChoice) - 1];
    }

    public String inputName(String type) {
        System.out.printf("Enter %s name:\n", type);
        String nameInput;
        do {
            nameInput = input.nextLine();
        } while (!FormatCheckers.stringIsValid(nameInput));
        return nameInput;
    }
    public String inputDateOfBirth() {
        System.out.println("Enter date of birth: (YYYYMMDD)");
        String dateOfBirthInput;
        do {
            dateOfBirthInput = input.nextLine();
        } while (!FormatCheckers.dateOfBirthFormatIsCorrect(dateOfBirthInput));
        return dateOfBirthInput;
    }
    public double inputSalary(){
        String userInput;
        System.out.println("Input employees hourly salary: ($$.¢¢ or $$)");
        do {
            userInput = input.nextLine();
        } while (!FormatCheckers.stringIsDouble(userInput));
        return Double.parseDouble(userInput);
    }
    public double inputHoursPerWeek() {
        String userInput;
        System.out.println("Input employees work hours/week: (HH or HH.HH)");
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
        String output = String.format("Error: %s. Try again.", errorMessage);
        System.out.println(output);
    }
    public <E> void showPerson(E person) {
        System.out.println(person);
    }
}
