package CurrencyExchange;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyExchange {
    private static HashMap<String, Double> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Код валюти, яку у вас є
        System.out.print("Please, enter your currency code: ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        while (true) {
            System.out.print("Please, enter the currency code you want to exchange to (or leave empty to exit): ");
            String targetCurrency = scanner.nextLine().toUpperCase();
            if (targetCurrency.isEmpty()) {
                System.out.println("Exiting the program...");
                break;
            }

            System.out.print("Please, enter the amount of money you want to exchange: ");
            double amount = scanner.nextDouble();

            if (cache.containsKey(targetCurrency)) {
                System.out.println("Checking the cache...");
                System.out.println("It is in the cache!");
                double exchangeRate = cache.get(targetCurrency);
                double exchangedAmount = amount * exchangeRate;
                System.out.printf("You received %.2f %s.%n", exchangedAmount, targetCurrency);
            } else {
                System.out.println("Checking the cache...");
                System.out.println("Sorry, but it is not in the cache!");

                double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
                if (exchangeRate != -1) {
                    cache.put(targetCurrency, exchangeRate);
                    double exchangedAmount = amount * exchangeRate;
                    System.out.printf("You received %.2f %s.%n", exchangedAmount, targetCurrency);
                } else {
                    System.out.println("Unable to retrieve exchange rate for the provided currency.");
                }
            }

            scanner.nextLine(); // Consume newline after reading double
        }
        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://www.floatrates.com/daily/" + baseCurrency + ".json"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(response.body());

            if (jsonObject.has(targetCurrency.toLowerCase())) {
                return jsonObject.getJSONObject(targetCurrency.toLowerCase()).getDouble("rate");
            } else {
                System.out.println("Requested currency not found in the exchange rates.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
