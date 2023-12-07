package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Loan principal: ");
        int principal = scanner.nextInt();

        System.out.print("Number of months: ");
        int months = scanner.nextInt();

        System.out.print("Monthly payment: ");
        int monthlyPayment = scanner.nextInt();

        for (int month = 1; month <= months; month++) {
            System.out.println("Month " + month + ": repaid " + monthlyPayment);
            principal -= monthlyPayment;

            if (principal <= 0) {
                System.out.println("The loan has been repaid!");
                break;
            }
        }
    }
}

