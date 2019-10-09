package com.company;

public class FormatCheckers {
    public static boolean stringIsIntegers(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            View.getInstance().showErrorMessage("Only integers allowed");
        }
        return false;
    }

    public static boolean stringIsDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (Exception e) {
            View.getInstance().showErrorMessage("Only double-values allowed");
        }
        return false;
    }

    public static boolean mainMenuChoiceIsValid(String menuChoice, int noOfChoices) {
        if (stringIsIntegers(menuChoice)) {
            if (Integer.parseInt(menuChoice) <= noOfChoices && Integer.parseInt(menuChoice) > 0) {
                return true;
            } else {
                View.getInstance().showErrorMessage("No such choice");
            }
        }
        return false;
    }
}
