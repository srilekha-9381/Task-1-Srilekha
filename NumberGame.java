import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        char playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            int target = random.nextInt(100) + 1; // 1 to 100
            int guess = 0;
            int attempts = 0;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("Try to guess it!");

            while (guess != target) {
                try {
                    System.out.print("Enter your guess: ");
                    guess = sc.nextInt();
                    attempts++;

                    if (guess > target) {
                        System.out.println("Too High!");
                    } else if (guess < target) {
                        System.out.println("Too Low!");
                    } else {
                        System.out.println("\nCorrect!");
                        System.out.println("You guessed the number in " + attempts + " attempts.");
                        int roundScore = Math.max(100 - (attempts - 1) * 10, 10);
                        totalScore += roundScore;
                        System.out.println("Round Score: " + roundScore);
                        System.out.println("Total Score: " + totalScore);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    sc.next(); // clear invalid input
                }
            }

            System.out.print("\nPlay Again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Final Score: " + totalScore);
        System.out.println("I Hope You enjoyed this game");
        System.out.println("Thank you for playing!");
        sc.close();
    }
}
