package CurrencyExchange;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyExchange {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        try {
            // Запрашиваем код валюты
            System.out.print("Please, enter the currency code (USD, EUR): ");
            String currencyCode = new java.util.Scanner(System.in).nextLine().toUpperCase();

            // Формируем запрос на сайт для заданной валюты
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://www.floatrates.com/daily/" + currencyCode + ".json"))
                    .build();

            // Получаем ответ на запрос
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Обрабатываем JSON-ответ
            JSONObject jsonObject = new JSONObject(response.body());

            // Получаем курс для доллара (USD) и евро (EUR)
            double usdRate = jsonObject.getJSONObject("usd").getDouble("rate");
            double eurRate = jsonObject.getJSONObject("eur").getDouble("rate");

            System.out.println("USD rate: " + usdRate);
            System.out.println("EUR rate: " + eurRate);

        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }
}
