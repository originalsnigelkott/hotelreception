package com.company;

import java.util.Scanner;

public class View {
    public enum MainMenuItem implements MenuOutput {
        ADMINISTRATOR_SUB_MENU ("Show admin menu"),
        RECEPTION_SUB_MENU ("Show reception menu"),
        HELP ("Help"),
        QUIT ("Quit");

        private String menuOutput;
        private MainMenuItem(String menuOutput){
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

        private AdminMenuItem(String menuOutput) {
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

        private EmployeeTypeMenuItem(String menuOutput) {
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
        BACK ("Back");

        private String menuOutput;

        private ShowEmployeeTypeMenuItem(String menuOutput) {
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

    public <T extends MenuOutput> void showMenu(T[] menuItems) {
        int i = 1;
        for (T menuItem :
                menuItems) {
            System.out.printf("%d. %s\n", i, menuItem.getMenuOutput());
            i++;
        }
    }

    public <T> T inputMenuChoice(T[] menuItems){
        String menuChoice;
        do {
            menuChoice = input.nextLine();
        } while (!FormatCheckers.menuChoiceIsValid(menuChoice, menuItems.length));
        return menuItems[Integer.parseInt(menuChoice) - 1];
    }

    //TODO: remove redundant menu and input methods
    public void showMainMenu(String hotelName) {
        int i = 1;
        System.out.printf("Welcome to %s.\n", hotelName);
        for (MainMenuItem mainMenuItem :
                MainMenuItem.values()) {
            System.out.printf("%d. %s\n", i, mainMenuItem.menuOutput);
            i++;
        }
    }
    public MainMenuItem getMainMenuChoice() {
        String mainMenuChoice;
        do {
            mainMenuChoice = input.nextLine();
        } while (!FormatCheckers.menuChoiceIsValid(mainMenuChoice, MainMenuItem.values().length));
        return MainMenuItem.values()[Integer.parseInt(mainMenuChoice) - 1];
    }
    public void showAdminMenu() {
        int i = 1;
        for (AdminMenuItem adminMenuItem :
                AdminMenuItem.values()) {
            System.out.printf("%d. %s\n", i, adminMenuItem.menuOutput);
            i++;
        }
    }
    public AdminMenuItem getAdminMenuItem() {
        String adminMenuChoice;
        do {
            adminMenuChoice = input.nextLine();
        } while (!FormatCheckers.menuChoiceIsValid(adminMenuChoice, AdminMenuItem.values().length));
        return AdminMenuItem.values()[Integer.parseInt(adminMenuChoice) - 1];
    }
    public void showEmployeeTypeMenu() {
        int i = 1;
        for (EmployeeTypeMenuItem employeeTypeMenu :
                EmployeeTypeMenuItem.values()) {
            System.out.printf("%d. %s\n", i, employeeTypeMenu.menuOutput);
            i++;
        }
    }
    public EmployeeTypeMenuItem getEmployeeTypeMenuItem() {
        String employeeTypeMenuChoice;
        do {
            employeeTypeMenuChoice = input.nextLine();
        } while (!FormatCheckers.menuChoiceIsValid(employeeTypeMenuChoice, EmployeeTypeMenuItem.values().length));
        return EmployeeTypeMenuItem.values()[Integer.parseInt(employeeTypeMenuChoice) - 1];
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
        String output = String.format("Error: %s. Try again.\n", errorMessage);
        System.out.println(output);
    }
}
