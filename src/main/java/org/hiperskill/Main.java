package org.hiperskill;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Write how many cups of coffee you will need: ");
//        Scanner scanner = new Scanner(System.in);
//        int amount = scanner.nextInt();
//        System.out.printf("""
//            For %d cups of coffee you will need:
//            %d ml of water
//            %d ml of milk
//            %d g of coffee beans""", amount, amount*200, amount*50, amount*15);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAmount = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAmount = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeansAmount = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int coffeeCupsAmount = scanner.nextInt();
    }
    int returnHowManyCupsCanBeMade(int waterAmount, int milkAmount, int coffeeBeansAmount, int coffeeCupsAmount) {
        return  Math.min(Math.min(waterAmount / 200, milkAmount / 50), coffeeBeansAmount / coffeeBeansAmount);
    }
}