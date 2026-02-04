package com.mycompany.inclass3;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
/**
 *
 * @author sangh
 */
class CurrencyService {

    public Map<String, String> getCurrencies() {
        // STEP 1: Just get the first two tests to pass
        // return Map.of("USD", "United States Dollar");
        
        // STEP 2: Make the test pass for multiple entries
        // return Map.of("USD", "United States Dollar", "NZD", "New Zealand Dollar");
        
        // STEP 3: Final Refactor (Data moved to separate class)
        return CurrencyData.ALL_CURRENCIES;
    }

    public boolean isValidCurrency(String code) {
        // STEP 1: Hardcoded check for one currency
        // if (code.equals("USD")) return true;
        
        // STEP 2: Logic added for case sensitivity and nulls
        // if (code != null && code.equalsIgnoreCase("USD")) return true;
        
        // STEP 3: Final Refactor (Uses the full Map)
        if (code == null) return false;
        return CurrencyData.ALL_CURRENCIES.containsKey(code.toUpperCase());
    }

    public String getRateFor(String base, String target) {
        // STEP 1: The "Fake" (Returning a hardcoded string to test the Scanner in Main)
        // return "{\"base\":\"USD\",\"rates\":{\"CAD\":1.35}}";

        // STEP 2: Hardcoded API call (Always asked for CAD)
        /*
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.frankfurter.dev/v1/latest?symbols=CAD"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) { return "Error"; }
        */

        // STEP 3: Final Refactor (Fully dynamic URL with base and target)
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.frankfurter.dev/v1/latest?base=" + base + "&symbols=" + target))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            return "Error fetching rate";
        }
    }
}