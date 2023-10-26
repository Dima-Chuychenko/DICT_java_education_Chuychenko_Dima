package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NameBotAndBD(scanner);
        GuessUserAge(scanner);
        CountingRoom(scanner);
        QuestionTask(scanner);
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

    static void CountingRoom(Scanner scanner) {
        System.out.println("Now I will prove to you that I can count to any positive number you want.");
        int count = scanner.nextInt();
        for (int i = 0; i <= count; i++) {
            System.out.println(i + " !");
        }
    }

    static void QuestionTask(Scanner scanner) {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Select a line containing only logical operators from Java?");
        System.out.println("1. $, !, !=, ^");
        System.out.println("2. ||, &&, !=");
        System.out.println("3. !=, %, ||, &&");
        System.out.println("4. *, ==, !=, &&, ||");
        System.out.println("5. ||, |, &&, &, @");
        int answer;
        do {
            answer = scanner.nextInt();
            if (answer == 2) {
                System.out.println("You right!\nGoodbye, have a nice day!");
                break;
            } else {
                System.out.println("Try again.");
            }
        }
        while (answer != 2);
    }
}

