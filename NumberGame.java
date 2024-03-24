import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!!!\n");

        boolean play = true;
        while (play) {
            int n = random.nextInt(max - min + 1) + min;

            System.out.println("\nI have chosen a number between " + min + " and " + max + ".");
            System.out.println("\nYou have " + attemptsLimit + " attempts to guess it.");

            int attempts = 0;
            boolean guessed = false;

            while (attempts < attemptsLimit && !guessed) {

                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == n) {

                    System.out.println(
                            "Congratulations!! You've guessed the correct number in " + attempts + " attempts!");
                    guessed = true;
                    score += attempts;
                } else {
                    System.out.println("Sorry, that's incorrect.");
                    if (guess < n) {
                        System.out.println("Try a higher number.");
                    } else {
                        System.out.println("Try a lower number.");
                    }
                }
            }

            if (!guessed) {
                System.out.println("\nSorry, you've used all your attempts. The correct number was: " + n);
            }

            System.out.println("\nYour current score is: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next().toLowerCase();
            play = choice.equals("yes");
        }

        System.out.println("Thank you for playing the Number Guessing Game!!!");
        sc.close();
    }
}
