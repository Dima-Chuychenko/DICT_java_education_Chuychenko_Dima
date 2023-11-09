package Hangman;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Print();
        Game();
    }
    public static void Print(){
        System.out.println("HANGMAN\nThe game will be available soon.");
    }

    public static void Game(){
        Scanner scanner = new Scanner(System.in);
        String secretWord = "java";
        String hiddenWord = "____";
        int attempts = 5;

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
