import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        System.out.println("🎲 Welcome to the Craps Game! 🎲");

        while (playAgain) {
            // First roll
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("\nYou rolled: " + die1 + " + " + die2 + " = " + sum);

            // Case i: Craps (lose immediately)
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("💀 Craps! You lose!");
            }
            // Case ii: Natural (win immediately)
            else if (sum == 7 || sum == 11) {
                System.out.println("🎉 Natural! You win!");
            }
            // Case iii: Establish the point
            else {
                int point = sum;
                System.out.println("The point is now " + point + ".");
                boolean rolling = true;

                // Keep rolling until point or 7 is rolled
                while (rolling) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("\nRolling again: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("🎯 You made your point! You win!");
                        rolling = false;
                    } else if (sum == 7) {
                        System.out.println("💔 Rolled a 7 — you lose!");
                        rolling = false;
                    } else {
                        System.out.println("Still trying for point...");
                    }
                }
            }

            // Ask user if they want to play again
            System.out.print("\nDo you want to play again? (y/n): ");
            String response = input.nextLine().trim().toLowerCase();
            playAgain = response.equals("y");
        }

        System.out.println("\nThanks for playing! Goodbye!");
        input.close();
    }
}
