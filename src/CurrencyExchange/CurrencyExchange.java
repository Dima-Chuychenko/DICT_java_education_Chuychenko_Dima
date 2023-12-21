package CurrencyExchange;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter the number of coins you have: ");
        double myCoins = scanner.nextDouble();

        // Курси обміну для різних валют
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("ARS", 0.82);
        exchangeRates.put("HNL", 0.17);
        exchangeRates.put("AUD", 1.9622);
        exchangeRates.put("MAD", 0.208);

        DecimalFormat df = new DecimalFormat("#.##");

        for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
            String currency = entry.getKey();
            double rate = entry.getValue();
            double result = myCoins * rate;
            System.out.println("I will get " + df.format(result) + " " + currency + " from the sale of " + df.format(myCoins) + " mycoins.");
        }
    }
}
