/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inclass3;
import java.util.Scanner;
/**
 *
 * @author sangh
 */
public class Inclass3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CurrencyService service = new CurrencyService();

        System.out.print("Enter base currency (e.g., CAD): ");
        String base = input.nextLine().toUpperCase();

        if (!service.isValidCurrency(base)) {
            System.out.println("Error: " + base + " is not a supported currency.");
            return;
        }

        System.out.print("Enter target currency (e.g., USD): ");
        String target = input.nextLine().toUpperCase();

        if (!service.isValidCurrency(target)) {
            System.out.println("Error: " + target + " is not a supported currency.");
            return;
        }

        System.out.println("Connecting to API...");
        System.out.println(service.getRateFor(base, target));
    }
}
