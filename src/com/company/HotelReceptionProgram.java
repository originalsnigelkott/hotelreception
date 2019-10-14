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
            view.showMenu(View.MainMenuItem.values());
            mainMenuChoice = view.inputMenuChoice(View.MainMenuItem.values());
            switch (mainMenuChoice) {
                case ADMINISTRATOR_SUB_MENU: {
                    View.AdminMenuItem adminMenuChoice;
                    do {
                        view.showMenu(View.AdminMenuItem.values());
                        adminMenuChoice = view.inputMenuChoice(View.AdminMenuItem.values());
                        switch (adminMenuChoice) {
                            case HIRE: {
                                View.EmployeeTypeMenuItem employeeTypeMenuItem;
                                do {
                                    view.showMenu(View.EmployeeTypeMenuItem.values());
                                    employeeTypeMenuItem = view.inputMenuChoice(View.EmployeeTypeMenuItem.values());
                                    switch (employeeTypeMenuItem) {
                                        case CLEANER: {
                                            hireEmployee((Employee) PersonFactory.createPerson(PersonFactory.PersonType.CLEANER));
                                            break;
                                        }
                                        case MANAGER: {
                                            hireEmployee((Employee) PersonFactory.createPerson(PersonFactory.PersonType.MANAGER));
                                            break;
                                        }
                                        case RECEPTIONIST: {
                                            hireEmployee((Employee) PersonFactory.createPerson(PersonFactory.PersonType.RECEPTIONIST));
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
                                int employeeID = view.inputEmployeeID();
                                dismissEmployee(employeeID);
                                break;
                            }
                            case SHOW: {
                                for (Employee employee :
                                        employees) {
                                    System.out.println(employee);
                                }
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

    private void hireEmployee(Employee employee) {
        if (employee != null) {
            employees.add(employee);
        }
    }

    private void dismissEmployee(int employeeID) {
        for (Employee employee :
                employees) {
            if (employeeID == employee.getEmployeeID()) {
                employees.remove(employee);
                view.showMessage("Employee dismissed.");
                return;
            }
        }
        view.showErrorMessage("No employee with that ID");
    }
}
