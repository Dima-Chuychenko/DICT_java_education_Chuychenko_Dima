package Hangman;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args){
        Game();
    }

    public static void Game(){
        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];
        String hiddenWord = secretWord.substring(0, 2) + "-".repeat(secretWord.length() - 2);
        int attempts = 8;

        System.out.println("HANGMAN");
        System.out.println("Guess the word: " + hiddenWord);

        while (attempts > 0) {
            String guess = scanner.nextLine();

            if (guess.equalsIgnoreCase(secretWord)) {
                System.out.println("You survived!");
                return;
            } else {
                attempts--;
                System.out.println("Guess the word: " + hiddenWord);
            }
        }

        System.out.println("You lost!");
    }

}
