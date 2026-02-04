package com.mycompany.inclass3;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;

class CurrencyServiceTest {

    @Test
    void testGetCurrencies() {
        CurrencyService service = new CurrencyService();
        //Using Map to create pairs of Currency Codes and Currency Name
        Map<String, String> currencies = service.getCurrencies();
        
        assertNotNull(currencies);
        assertTrue(currencies.containsKey("USD"));
        assertFalse(currencies.containsKey("XXY"));
        assertTrue(currencies.containsKey("NZD"));
        
    }
    
    @Test
    void testIsValidCurrency() {
        CurrencyService service = new CurrencyService();

        // Test valid inputs
        assertTrue(service.isValidCurrency("USD"));
        assertTrue(service.isValidCurrency("cad"));

        // Test invalid inputs
        assertFalse(service.isValidCurrency("XYZ"));
        assertFalse(service.isValidCurrency(null));
        assertFalse(service.isValidCurrency(""));
    }
    
    @Test
    void testGetRateForDifferentCurrencies() {
        CurrencyService service = new CurrencyService();
        // Test if the String contains the expected keys
        String response = service.getRateFor("USD", "CAD");
        assertTrue(response.contains("USD"));
        assertTrue(response.contains("CAD"));
        assertTrue(response.contains("rates")); // Ensures the API actually gave us a price
    }
}