package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення основної суми кредиту
        System.out.println("Enter the loan principal:");
        int principal = scanner.nextInt();

        // Вибір, що розраховувати
        System.out.println("What do you want to calculate?");
        System.out.println("type \"m\" - for number of monthly payments,");
        System.out.println("type \"p\" - for the monthly payment:");
        String choice = scanner.next();

        if (choice.equals("m")) {
            System.out.println("Enter the monthly payment:");
            int monthlyPayment = scanner.nextInt();
            double months = (double) principal / monthlyPayment;
            int roundMonths = (int) Math.round(months);
            System.out.println("It will take " + roundMonths + " months to repay the loan");
        } else if (choice.equals("p")) {
            System.out.println("Enter the number of months:");
            int months = scanner.nextInt();
            double monthlyPayment = Math.ceil((double) principal / months);
            int lastPayment = principal - (months - 1) * (int) monthlyPayment;
            String result = lastPayment == (int) monthlyPayment ? "Your monthly payment = " + (int) monthlyPayment
                    : "Your monthly payment = " + (int) monthlyPayment + " and the last payment = " + lastPayment;
            System.out.println(result);
        }
    }
}

