package CurrencyExchange;

import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter the number of mycoins you have: ");
        double myCoins = scanner.nextDouble();

        System.out.print("Please, enter the exchange rate: ");
        double exchangeRate = scanner.nextDouble();

        double dollars = myCoins * exchangeRate;

        System.out.println("The total amount of dollars: " + dollars);
    }
}
