package com.teamSuperior.tuiLayer;

import java.util.Scanner;

/**
 * Created by Smoothini on 28.11.2016.
 */
public class MainMenu
{
    private boolean isRunning = true;
    private Scanner sc = new Scanner(System.in);

    private MenuCustomers menuCustomers = new MenuCustomers();
    private MenuProducts menuProducts = new MenuProducts();
    private MenuOffers menuOffers = new MenuOffers();
    private MenuOrders menuOrders = new MenuOrders();
    private MenuContractors menuContractors = new MenuContractors();
    private MenuStatistics menuStatistics = new MenuStatistics();

    public MainMenu() {
        while (isRunning) {
            printMenu();
            chooseSubMenu();
        }
    }

    public void printMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Customers");
        System.out.println("2. Products");
        System.out.println("3. Offers");
        System.out.println("4. Orders");
        System.out.println("5. Contractors");
        System.out.println("6. Statistics");
        System.out.println("7. Exit");
        System.out.println("Your option");
    }

    public void chooseSubMenu(){
        int choice;
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                menuCustomers.printCustomersMenu();
                break;
            case 2:
                menuProducts.printProductsMenu();
                break;
            case 3:
                menuOffers.printOffersMenu();
                break;
            case 4:
                menuOrders.printOrdersMenu();
                break;
            case 5:
                menuContractors.printContractorsMenu();
                break;
            case 6:
                menuStatistics.printStatisticsMenu();
                break;
            case 7:
                System.out.println("Thank you for using our software");
                isRunning = false;
                break;
            default:
                System.out.println("Error, please try again");
                break;
        }
    }

    public void printCustomersMenu()
    {

    }
}
