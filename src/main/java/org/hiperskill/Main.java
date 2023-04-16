package org.hiperskill;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        System.out.printf("""
            For %d cups of coffee you will need:
            %d ml of water
            %d ml of milk
            %d g of coffee beans""", amount, amount*200, amount*50, amount*15);
    }
}