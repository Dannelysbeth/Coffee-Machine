package org.hiperskill;

import java.util.Scanner;

public class Main {
    private static final int WATER_PER_CUP = 200; // Milliliters
    private static final int MILK_PER_CUP = 50; // Milliliters
    private static final int COFFEE_BEANS_PER_CUP = 15; // Grams

    private static int waterAmount = 400;
    private static int milkAmount = 540;
    private static int beansAmount = 120;
    private static int cupsAmount = 9;
    private static int money = 550;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        // Get the amount of water, milk, coffee beans, and cups of coffee from the user
//        System.out.println("Write how many ml of water the coffee machine has:");
//        int waterAmount = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milkAmount = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int coffeeBeansAmount = scanner.nextInt();
//        System.out.println("Write how many cups of coffee you will need:");
//        int requestedCoffeeCups = scanner.nextInt();

        System.out.printf("""
                        The coffee machine has:
                        %d ml of water
                        %d ml of milk
                        %d g of coffee beans
                        %d disposable cups
                        $%d of money
                                        
                        Write action (buy, fill, take):\s
                        """,
                waterAmount, milkAmount, beansAmount, cupsAmount, money);

        String operation = scanner.next();
        switch (operation) {
            case "buy" -> buy(scanner);
            case "fill" -> fill(scanner);
            case "take" -> take(scanner);
            default -> {
            }
        }
        System.out.printf("""
                        The coffee machine has:
                        %d ml of water
                        %d ml of milk
                        %d g of coffee beans
                        %d disposable cups
                        $%d of money
                                        
                        Write action (buy, fill, take):\s
                        """,
                waterAmount, milkAmount, beansAmount, cupsAmount, money);


//        // Calculate the maximum number of cups of coffee that can be made with the given resources
//        int maxPossibleCups = calculatePossibleCups(waterAmount, milkAmount, coffeeBeansAmount);
//
//        // Print the result
//        if (maxPossibleCups > requestedCoffeeCups) {
//            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", maxPossibleCups - requestedCoffeeCups);
//        } else if (maxPossibleCups == requestedCoffeeCups) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else {
//            System.out.printf("No, I can make only %d cup(s) of coffee", maxPossibleCups);
//        }
    }

    public static int calculatePossibleCups(int waterAmount, int milkAmount, int coffeeBeansAmount) {
        // Calculate the maximum number of cups of coffee that can be made with the given resources
        return Math.min(Math.min(waterAmount / WATER_PER_CUP, milkAmount / MILK_PER_CUP), coffeeBeansAmount / COFFEE_BEANS_PER_CUP);
    }

    public static void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        waterAmount = waterAmount + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkAmount = milkAmount + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beansAmount = beansAmount + scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cupsAmount = cupsAmount + scanner.nextInt();
    }

    public static void take(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        System.out.printf("I gave you $%d", money);
        money = 0;
    }

    public static void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int coffeeType = scanner.nextInt();
        switch (coffeeType) {
            case 1 -> {                 //expresso For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
                waterAmount -= 250;
                beansAmount -= 16;
                money += 4;
            }
            case 2 -> {                 //For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
                waterAmount -= 350;
                milkAmount -= 75;
                beansAmount -= 20;
                money += 7;
            }
            case 3 -> {                 //cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
                waterAmount -= 200;
                milkAmount -= 100;
                beansAmount -= 12;
                money += 6;
            }
            default -> {
            }
        }
        cupsAmount--;

    }


}