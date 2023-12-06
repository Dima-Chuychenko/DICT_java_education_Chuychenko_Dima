package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args)
            throws InterruptedException {
        Resource resource = new Resource();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write action: BUY, SHOW, FILL, TAKE or EXIT(on only caps lock)");
            String str = scanner.nextLine();
            Fortunes fortunes = Fortunes.valueOf(str);

            switch (fortunes) {
                case SHOW -> show(resource);
                case FILL -> caseFill(scanner, resource);
                case TAKE -> {
                    resource.take(resource.money);
                    System.out.println();
                }
                case BUY -> caseBuy(scanner, resource);
                case EXIT -> {
                    scanner.close();
                    return;
                }
            }
        }
    }


    protected static void show(Resource resource) {
        System.out.println("The coffee machine has:");
        System.out.println("  • " + resource.getWater() + " of water\n" +
                "  • " + resource.getMILK() + " of milk\n" +
                "  • " + resource.getCoffeeeBeans() + " of coffee beans\n" +
                "  • " + resource.getCup() + " of cups\n" +
                "  • " + resource.getMoney() + " of money.\n");
    }

    protected static void caseBuy(Scanner scanner, Resource resource) throws InterruptedException {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu. (Enter action with caps lock.)\n>");
        String str1 = scanner.nextLine();
        TypeCoffee typeCoffee = TypeCoffee.valueOf(str1);
        switch (typeCoffee) {
            case ESPRESSO:
                caseEspresso(resource);
                break;
            case LATTE:
                caseLatte(resource);
                break;
            case CAPPUCCINO:
                caseCappuccino(resource);
                break;
            case BACK:
                break;
        }
    }

    protected static void caseEspresso(Resource resource) throws InterruptedException {
        if (resource.water > resource.espressoWater && resource.coffeeeBeans > resource.espressoCoffeeeBeans && resource.cup > resource.espressoCup) {
            System.out.println("You choosed espresso.\nWait for cooking ;)");
            Thread.sleep(1500);
            System.out.println("    /  ");
            Thread.sleep(1000);
            System.out.println("    |  ");
            Thread.sleep(1000);
            System.out.println("  █████");
            Thread.sleep(1000);
            System.out.println("  ▼▲▼▲▼");
            Thread.sleep(1000);
            System.out.println("   ▼▲▼ ");
            Thread.sleep(1000);
            System.out.println("   ▀▀▀  ");
            Thread.sleep(2000);
            System.out.println("Take your espresso ♥\n");
            resource.makeEspresso();
        } else {
            System.out.println("Sorry, not enough resources :(");
        }
    }

    protected static void caseLatte(Resource resource) throws InterruptedException {
        if (resource.water > resource.latteWater && resource.coffeeeBeans > resource.latteCoffeeBeans && resource.milk > resource.latteMilk && resource.cup > resource.latteCup) {
            System.out.println("You choosed latte.\nWait for cooking ;)");
            Thread.sleep(2000);
            System.out.println("    /  ");
            Thread.sleep(1000);
            System.out.println("    |  ");
            Thread.sleep(1000);
            System.out.println("  █████");
            Thread.sleep(1000);
            System.out.println("  ▼▲▼▲▼");
            Thread.sleep(1000);
            System.out.println("   ▼▲▼ ");
            Thread.sleep(1000);
            System.out.println("   ▀▀▀  ");
            Thread.sleep(2000);
            System.out.println("Take your latte ♥\n");
            resource.makeLatte();
        } else {
            System.out.println("Sorry, not enough resources :(");
        }
    }

    protected static void caseCappuccino(Resource resource) throws InterruptedException {
        if (resource.water > resource.cappuccinoWater && resource.coffeeeBeans > resource.cappuccinoCoffeeBeans && resource.milk > resource.cappuccinoMilk && resource.cup > resource.cappuccinoCup) {
            System.out.println("You choosed cappuccino.\nWait for cooking ;)");
            Thread.sleep(2000);
            System.out.println("    /  ");
            Thread.sleep(1000);
            System.out.println("    |  ");
            Thread.sleep(1000);
            System.out.println("  █████");
            Thread.sleep(1000);
            System.out.println("  ▼▲▼▲▼");
            Thread.sleep(1000);
            System.out.println("   ▼▲▼ ");
            Thread.sleep(1000);
            System.out.println("   ▀▀▀  ");
            Thread.sleep(2000);
            System.out.println("Take your cappuccino ♥\n");
            resource.makeCappuccino();
        } else {
            System.out.println("Sorry, not enough resources :(");
        }
    }

    protected static void caseFill(Scanner scanner, Resource resource) {
        int password;
        do {
            System.out.println("Please, enter password.");
            password = scanner.nextInt();
            if (password != 12345)
                System.out.println("Password is incorrect! Try again.");
        } while (password != 12345);

        System.out.print("Write how many ml of water you want to add:\n>");
        int fillWater = scanner.nextInt();
        System.out.print("Write how many ml of milk you want to add:\n>");
        int fillMilk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add:\n>");
        int fillCoffeeBeans = scanner.nextInt();
        System.out.print("Write how many disposable coffee cups you want to add:\n>");
        int fillcups = scanner.nextInt();
        resource.fill(fillWater, fillMilk, fillCoffeeBeans, fillcups);
        System.out.println();
    }
}
