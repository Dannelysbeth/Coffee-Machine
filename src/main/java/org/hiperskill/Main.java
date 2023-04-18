package org.hiperskill;

import java.util.Scanner;

public class Main {
    private static final int WATER_PER_CUP = 200; // Milliliters
    private static final int MILK_PER_CUP = 50; // Milliliters
    private static final int COFFEE_BEANS_PER_CUP = 15; // Grams


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the amount of water, milk, coffee beans, and cups of coffee from the user
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAmount = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAmount = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeansAmount = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int requestedCoffeeCups = scanner.nextInt();

        // Calculate the maximum number of cups of coffee that can be made with the given resources
        int maxPossibleCups = calculatePossibleCups(waterAmount, milkAmount, coffeeBeansAmount)

        // Print the result
        if (maxPossibleCups > requestedCoffeeCups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", maxPossibleCups - requestedCoffeeCups);
        } else if (maxPossibleCups == requestedCoffeeCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", maxPossibleCups);
        }
    }

    public static int calculatePossibleCups(int waterAmount, int milkAmount, int coffeeBeansAmount) {
        // Calculate the maximum number of cups of coffee that can be made with the given resources
        int possibleCups = Math.min(Math.min(waterAmount / WATER_PER_CUP, milkAmount / MILK_PER_CUP), coffeeBeansAmount / COFFEE_BEANS_PER_CUP);
        return possibleCups;
    }
}