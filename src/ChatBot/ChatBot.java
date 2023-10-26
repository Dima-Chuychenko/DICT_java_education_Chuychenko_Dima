package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NameBotAndBD(scanner);
    }

    static void NameBotAndBD(Scanner scanner) {
        String bot_name = "Bot";
        int birth_year = 2023;
        System.out.println("Hello! My name is " + bot_name + ".");
        System.out.println("I was created in " + birth_year + ".");

    }
}

