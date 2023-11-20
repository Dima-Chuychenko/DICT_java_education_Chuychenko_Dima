package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Game();
    }

    public static void Game() {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];
        StringBuilder hiddenWord = new StringBuilder("-".repeat(secretWord.length()));
        int health = 8;

        System.out.println("HANGMAN");
        System.out.println(hiddenWord);

        while (health > 0) {
            System.out.print("Input a letter: > ");
            String guess = scanner.nextLine();

            if (!Character.isLowerCase(guess.charAt(0))) {
                System.out.println("Please enter a lowercase English letter.");
                continue;
            }

            if (guess.length() != 1) {
                System.out.println("You should input a single letter.");
                continue;
            }

            if (hiddenWord.indexOf(guess) != -1) {
                System.out.println("You've already guessed this letter.");
                continue;
            }

            boolean found = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess.charAt(0)) {
                    if (hiddenWord.charAt(i) == '-') {
                        hiddenWord.setCharAt(i, guess.charAt(0));
                        found = true;
                    } else {
                        System.out.println("No improvements");
                        found = true;
                    }
                }
            }

            if (!found) {
                health--;
                System.out.println("That letter doesn't appear in the word");
            }

            System.out.println(hiddenWord);

            if (hiddenWord.indexOf("-") == -1) {
                System.out.println("You!\n" +
                        "We'll see how well you did in the next stage");
                return;
            }
        }
        System.out.println("You lost!");
    }

}