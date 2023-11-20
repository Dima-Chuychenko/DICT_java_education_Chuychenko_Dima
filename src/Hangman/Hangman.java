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
        StringBuilder hiddenWord = new StringBuilder("-".repeat(secretWord.length()));
        int health = 8;

        System.out.println("HANGMAN");
        System.out.println(hiddenWord);

        while (health > 0) {

            System.out.println("Input a letter: > ");
            String guess = scanner.nextLine().toLowerCase();

            boolean found = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess.charAt(0)) {
                    hiddenWord.setCharAt(i, guess.charAt(0));
                    found = true;
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

        System.out.println("Thanks for playing!\n" +
                "We'll see how well you did in the next stage");
    }

}
