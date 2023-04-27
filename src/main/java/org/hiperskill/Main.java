package org.hiperskill;

import java.util.Scanner;

public class Main {
    private static int waterAmount = 400;
    private static int milkAmount = 540;
    private static int beansAmount = 120;
    private static int cupsAmount = 9;
    private static int money = 550;

    private static final int ESPRESSO_WATER_REQ = 250;
    private static final int ESPRESSO_MILK_REQ = 0;
    private static final int ESPRESSO_BEANS_REQ = 16;
    private static final int ESPRESSO_PRICE = 4;

    private static final int LATTE_WATER_REQ = 350;
    private static final int LATTE_MILK_REQ = 75;
    private static final int LATTE_BEANS_REQ = 20;
    private static final int LATTE_PRICE = 7;


    private static final int CAPPUCCINO_WATER_REQ = 200;
    private static final int CAPPUCCINO_MILK_REQ = 100;
    private static final int CAPPUCCINO_BEANS_REQ = 12;
    private static final int CAPPUCCINO_PRICE = 6;


    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
        String operation = scanner.next();
        switch (operation) {
            case "buy" -> buy(scanner);
            case "fill" -> fill(scanner);
            case "take" -> take(scanner);
            case "remaining" -> remaining();
            case "exit" -> {
            }
            default -> {
                System.out.println("Wrong operation!");
                menu();
            }
        }
    }

    public static void remaining() {
        System.out.printf("""
                                                
                        The coffee machine has:
                        %d ml of water
                        %d ml of milk
                        %d g of coffee beans
                        %d disposable cups
                        $%d of money
                        """,
                waterAmount, milkAmount, beansAmount, cupsAmount, money);
        menu();
    }

    public static void fill(Scanner scanner) {
        System.out.println("\nWrite how many ml of water you want to add: ");
        waterAmount = waterAmount + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkAmount = milkAmount + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beansAmount = beansAmount + scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cupsAmount = cupsAmount + scanner.nextInt();
        menu();
    }

    public static void take(Scanner scanner) {
        System.out.printf("\nI gave you $%d \n", money);
        money = 0;
        menu();
    }

    public static void buy(Scanner scanner) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeType = scanner.next();
        StringBuilder msg = new StringBuilder();
        switch (coffeeType) {
            case "1" -> {                 //espresso For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
                msg = new StringBuilder(getIfCanMakeCoffeeMsg(ESPRESSO_WATER_REQ, ESPRESSO_MILK_REQ, ESPRESSO_BEANS_REQ));
                if (msg.toString().equals("I have enough resources, making you a coffee!")) {
                    waterAmount -= ESPRESSO_WATER_REQ;
                    beansAmount -= ESPRESSO_BEANS_REQ;
                    money += ESPRESSO_PRICE;
                    cupsAmount--;
                }
            }
            case "2" -> {                 //For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
                msg = new StringBuilder(getIfCanMakeCoffeeMsg(LATTE_WATER_REQ, LATTE_MILK_REQ, LATTE_BEANS_REQ));
                if (msg.toString().equals("I have enough resources, making you a coffee!")) {
                    waterAmount -= LATTE_WATER_REQ;
                    milkAmount -= LATTE_MILK_REQ;
                    beansAmount -= LATTE_BEANS_REQ;
                    money += LATTE_PRICE;
                    cupsAmount--;
                }
            }
            case "3" -> {                 //cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
                msg = new StringBuilder(getIfCanMakeCoffeeMsg(CAPPUCCINO_WATER_REQ, CAPPUCCINO_MILK_REQ, CAPPUCCINO_BEANS_REQ));
                if (msg.toString().equals("I have enough resources, making you a coffee!")) {
                    waterAmount -= CAPPUCCINO_WATER_REQ;
                    milkAmount -= CAPPUCCINO_MILK_REQ;
                    beansAmount -= CAPPUCCINO_BEANS_REQ;
                    money += CAPPUCCINO_PRICE;
                    cupsAmount--;
                }
            }
            case "back" -> {
            }
            default -> {
            }
        }
        System.out.println(msg);
//        cupsAmount = cupsAmount > 0 ? cupsAmount-- : cupsAmount;
        menu();
    }

    public static boolean checkIfAnyCups() {
        return cupsAmount > 0 ? true : false;
    }

    public static String getIfCanMakeCoffeeMsg(int waterReq, int milkReq, int beansReq) {
        return waterAmount >= waterReq ?
                (milkAmount >= milkReq ?
                        (beansAmount >= beansReq ?
                                (checkIfAnyCups() ? "I have enough resources, making you a coffee!" :
                                        "Sorry, not enough disposable cups!") :
                                "Sorry, not enough coffee beans!") :
                        "Sorry, not enough milk!") :
                "Sorry, not enough water!";
    }
}