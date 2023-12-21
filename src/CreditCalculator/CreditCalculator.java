package CreditCalculator;

public class CreditCalculator {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: javac CreditCalculator -Dtype=[n/a/p/d] -Dprincipal=[value] -Dperiods=[value] -Dinterest=[value]");
            return;
        }

        String type = System.getProperty("type");
        double principal = Double.parseDouble(System.getProperty("principal"));
        int periods = Integer.parseInt(System.getProperty("periods"));
        double interest = Double.parseDouble(System.getProperty("interest")) / 100 / 12;
        double annuityPayment = Double.parseDouble(System.getProperty("annuityPayment"));
        double monthlyPayment = Double.parseDouble(System.getProperty("monthlyPayment"));

        switch (type) {
            case "n" -> {
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
                annuityPayment = principal * (interest * Math.pow(1 + interest, periods)) /
                        (Math.pow(1 + interest, periods) - 1);
                System.out.printf("Your monthly payment = %.0f!%n", Math.ceil(annuityPayment));
            }
            case "p" -> {
                principal = annuityPayment * ((Math.pow(1 + interest, periods) - 1) /
                        (interest * Math.pow(1 + interest, periods)));
                System.out.printf("Your loan principal = %.0f!%n", principal);
            }
            case "d" -> {
                for (int month = 1; month <= periods; month++) {
                    double differentiatedPayment = principal /
                            periods + interest * (principal - (principal * (month - 1)) / periods);
                    System.out.printf("Month %d: payment is %.0f%n", month, Math.ceil(differentiatedPayment));
                }
            }
        }
    }
}

