package com.company;

import java.util.ArrayList;

public class HotelReceptionProgram {
    public static final int NUMBER_OF_FLOORS = 3;
    private ArrayList<Floor> floors = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    View view;

    public HotelReceptionProgram() {
        view = View.getInstance();
        for (int i = 0; i < NUMBER_OF_FLOORS; i++) {
            floors.add(new Floor(i + 1));
        }
    }

    public void startProgram() {
        View.MainMenuItem mainMenuChoice;
        do {
            view.showMainMenu("Clarion Hotel");
            mainMenuChoice = view.getMainMenuChoice();
            switch (mainMenuChoice) {
                case ADMINISTRATOR_SUB_MENU: {
                    View.AdminMenuItem adminMenuChoice;
                    do {
                        view.showAdminMenu();
                        adminMenuChoice = view.getAdminMenuItem();
                        switch (adminMenuChoice) {
                            case HIRE: {
                                View.EmployeeTypeMenuItem employeeTypeMenuItem;
                                do {
                                    view.showEmployeeTypeMenu();
                                    employeeTypeMenuItem = view.getEmployeeTypeMenuItem();
                                    switch (employeeTypeMenuItem) {
                                        case CLEANER: {
                                            //TODO: implement
                                            break;
                                        }
                                        case MANAGER: {
                                            //TODO: implement
                                            break;
                                        }
                                        case RECEPTIONIST: {
                                            //TODO: implement
                                            break;
                                        }
                                        case BACK: {
                                            break;
                                        }
                                        default: {
                                            view.showErrorMessage("Invalid choice");
                                        }
                                    }
                                } while (employeeTypeMenuItem != View.EmployeeTypeMenuItem.BACK);
                                break;
                            }
                            case DISMISS: {
                                //TODO: implement getEmployeeID
                                break;
                            }
                            case SHOW: {
                                //TODO: implement
                                break;
                            }
                            case BACK: {
                                break;
                            }
                            default: {
                                view.showErrorMessage("Invalid choice");
                            }
                        }
                    } while (adminMenuChoice != View.AdminMenuItem.BACK);
                    break;
                }
                case RECEPTION_SUB_MENU: {
                    System.out.println("Receptionist options coming soon.");
                    break; //TODO: implement
                }
                case HELP: {
                    System.out.println("Help menu coming soon.");
                    break; //TODO: implement
                }
                case QUIT: {
                    break;
                }
                default: {
                    view.showErrorMessage("Invalid choice");
                }
            }
        } while (mainMenuChoice != View.MainMenuItem.QUIT);
    }
}
