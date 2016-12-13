/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyProject;

import java.util.Scanner;

import prompt.Prompt;

/**
 *
 * @author David Gordon Plouse
 */
public class GamesAppMenu {
    Scanner sc = new Scanner(System.in);
    DAOGames data = new DAOGames();

    public GamesAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String name;
        double price;
        int number = 0;
        int date = 0;

        while (choice != 0) {
            System.out.println("\nGames App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by Id");
            System.out.println("7 = Retrieve All: Order by Name");
            System.out.println("8 = Retrieve All: Order by Price");
            System.out.println("9 = Retrieve All: Order by Serial Number");
            System.out.println("10 = Retrieve All: Order by Year released");
            System.out.println("11 = Retrieve All: Order by Name / Price Descending");
            System.out.println("12 = Retrieve All: Order by Name / Price Descending version 2");
            System.out.println("13 = Statistics");
            choice = Prompt.getInt("Number of choice: ", 0, 13);

            if (choice == 1) {
                System.out.println(data.toString());
            } else if (choice == 2) {
                id = Prompt.getInt("Enter games id: ");
                name = Prompt.getLine("Enter Name: ");
                price = Prompt.getDouble("Enter price: ");
                number = Prompt.getInt("Enter serial number: ");
                date = Prompt.getInt("Enter the date purchased: ");
                Games games = new Games(id, name, price, number, date);
                data.create(games);
            } else if (choice == 3) {
                id = Prompt.getInt("Enter games id: ");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                System.out.println("Enter games update");
            } else if (choice == 5) {
                id = Prompt.getInt("Enter games id: ");
                data.delete(id);
            } else if (choice == 6) {
                System.out.println(data.orderById());
            } else if (choice == 7) {
                System.out.println(data.orderByName());
            } else if (choice == 8) {
                System.out.println(data.orderByPrice());
            } else if (choice == 9) {
                System.out.println(data.orderByNumber());
            } else if (choice == 10) {
                System.out.println(data.orderByDate());
            } else if (choice == 11) {
                System.out.println(data.orderByNamePrice());
            } else if (choice == 12) {
                //System.out.println(data.orderByNamePrice2());
            } else if (choice == 13) {
                  System.out.println("Lowest price - " + 
                        GamesStatistics.lowestPrice(data));
                System.out.println("Highest price - " + 
                        GamesStatistics.highestPrice(data));
                System.out.println("Sum of prices - " + 
                        GamesStatistics.sumPrice(data));
                System.out.println("Average price - " + 
                        GamesStatistics.avgPrice(data));
                System.out.println("Standard Deviation - " + 
                        GamesStatistics.standardDeviation(data));
            } else if (choice == 0) {
                ;
            }
        }
    }

    public static void main(String[] args) {
        new GamesAppMenu();
    }
}
