package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("type \"n\" for number of monthly payments,");
        System.out.println("type \"a\" for annuity monthly payment amount,");
        System.out.println("type \"p\" for loan principal:");
        String choice = scanner.next();

        switch (choice) {
            case "n" -> {
                System.out.println("Enter the loan principal:");
                double principal = scanner.nextDouble();
                System.out.println("Enter the monthly payment:");
                double monthlyPayment = scanner.nextDouble();
                System.out.println("Enter the loan interest:");
                double interest = scanner.nextDouble() / 100 / 12;

                double base = 1 + interest;
                double n = Math.log(monthlyPayment / (monthlyPayment - interest * principal)) / Math.log(base);
                int months = (int) Math.ceil(n);

                int years = months / 12;
                int remainingMonths = months % 12;

                if (years > 0 && remainingMonths > 0) {
                    System.out.printf("It will take %d years and %d months to repay this loan!%n", years, remainingMonths);
                } else if (years == 0) {
                    System.out.printf("It will take %d months to repay this loan!%n", remainingMonths);
                } else if (remainingMonths == 0) {
                    System.out.printf("It will take %d years to repay this loan!%n", years);
                }

            }
            case "a" -> {
                System.out.println("Enter the loan principal:");
                double principal = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                int periods = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                double interest = scanner.nextDouble() / 100 / 12;

                double annuityPayment = principal * (interest * Math.pow(1 + interest, periods)) /
                        (Math.pow(1 + interest, periods) - 1);
                System.out.printf("Your monthly payment = %.0f!%n", Math.ceil(annuityPayment));

            }
            case "p" -> {
                System.out.println("Enter the annuity payment:");
                double annuityPayment = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                int periods = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                double interest = scanner.nextDouble() / 100 / 12;

                double principal = annuityPayment * ((Math.pow(1 + interest, periods) - 1) /
                        (interest * Math.pow(1 + interest, periods)));
                System.out.printf("Your loan principal = %.0f!%n", principal);
            }
        }
    }
}

