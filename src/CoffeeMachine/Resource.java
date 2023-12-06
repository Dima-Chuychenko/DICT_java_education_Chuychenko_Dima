package CoffeeMachine;

import java.util.Scanner;

public class Resource {
    protected int water = 400;
    protected int milk = 540;
    protected int coffeeeBeans = 120;
    protected int cup = 9;
    protected int money = 550;

    //espresso
    protected int espressoWater = 250;
    protected int espressoCoffeeeBeans = 16;
    protected int espressoPrice = 4;
    protected int espressoCup = 1;

    //latte
    protected int latteWater = 350;
    protected int latteMilk = 75;
    protected int latteCoffeeBeans = 20;
    protected int lattePrice = 7;
    protected int latteCup = 1;

    //cappuccino
    protected int cappuccinoWater = 200;
    protected int cappuccinoMilk = 100;
    protected int cappuccinoCoffeeBeans = 12;
    protected int cappuccinoPrice = 6;
    protected int cappuccinoCup = 1;

    protected int getWater() {
        return water;
    }
    protected int getMILK() {
        return milk;
    }
    protected int getCoffeeeBeans() {
        return coffeeeBeans;
    }
    protected int getMoney() {
        return money;
    }
    protected int getCup() {
        return cup;
    }
    protected void take(int takeCache) {
        Scanner scanner = new Scanner(System.in);
        int password;
        do {
            System.out.println("Please, enter password.");
            password = scanner.nextInt();
            if (password != 1111) {

                System.out.println("Password is incorrect! Try again.");
            }
        }
        while (password != 1111);
        System.out.println("I gave you " + money);
        money -= takeCache;
    }
    protected void fill(int fillWater, int fillMilk, int fillCoffee, int fillcups) {
        water += fillWater;
        milk += fillMilk;
        coffeeeBeans += fillCoffee;
        cup += fillcups;
    }

    protected void makeEspresso() {
        water -= espressoWater;
        coffeeeBeans -= espressoCoffeeeBeans;
        cup -= espressoCup;
        money += espressoPrice;
    }

    protected void makeLatte() {
        water -= latteWater;
        milk -= latteMilk;
        coffeeeBeans -= latteCoffeeBeans;
        cup -= latteCup;
        money += lattePrice;
    }

    protected void makeCappuccino() {
        water -= cappuccinoWater;
        milk -= cappuccinoMilk;
        coffeeeBeans -= cappuccinoCoffeeBeans;
        cup -= cappuccinoCup;
        money += cappuccinoPrice;
    }
}
