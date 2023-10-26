package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NameBotAndBD(scanner);
        GuessUserAge(scanner);
    }

    static void NameBotAndBD(Scanner scanner) {
        String bot_name = "Bot";
        int birth_year = 2023;
        String user_name;
        System.out.println("Hello! My name is " + bot_name + ".");
        System.out.println("I was created in " + birth_year + ".");
        System.out.println("Please, remind me your name.");
        user_name = scanner.nextLine();
        System.out.println("Nice to meet you, " + user_name + "!");
    }
    static void GuessUserAge(Scanner scanner) {
        int age;
        int remainder3, remainder5, remainder7;
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        remainder3 = scanner.nextInt();
        remainder5 = scanner.nextInt();
        remainder7 = scanner.nextInt();
        age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to change job");
    }
}

