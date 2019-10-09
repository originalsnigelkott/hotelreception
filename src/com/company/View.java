package com.company;

import java.util.Scanner;

public class View {
    public enum MainMenuItem {
        ADMINISTRATOR_SUB_MENU ("Show admin menu"),
        RECEPTION_SUB_MENU ("Show reception menu"),
        HELP ("Help"),
        QUIT ("Quit");

        private String menuOutput;
        private MainMenuItem(String menuOutput){
            this.menuOutput = menuOutput;
        }
    }

    public enum AdminMenuItem {
        HIRE ("Hire employee"),
        DISMISS("Dismiss employee"),
        SHOW ("Show employees"),
        BACK ("Back");

        private String menuOutput;

        private AdminMenuItem(String menuOutput) {
            this.menuOutput = menuOutput;
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
        } while (!FormatCheckers.mainMenuChoiceIsValid(mainMenuChoice, MainMenuItem.values().length));
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
        } while (!FormatCheckers.mainMenuChoiceIsValid(adminMenuChoice, AdminMenuItem.values().length));
        return AdminMenuItem.values()[Integer.parseInt(adminMenuChoice) - 1];
    }


    public void showErrorMessage(String errorMessage) {
        String output = String.format("Error: %s. Try again.\n", errorMessage);
        System.out.println(output);
    }
}
