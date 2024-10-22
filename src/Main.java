import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continuePlaying = true;

        while (continuePlaying) {
            // Roll the dice
            int die1 = random.nextInt(6) + 1; // Roll die 1
            int die2 = random.nextInt(6) + 1; // Roll die 2
            int sum = die1 + die2; // Calculate sum

            // Display dice values and sum
            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            // Check game outcome
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                // The point is established
                System.out.println("The point is now: " + sum);
                boolean pointAchieved = false;

                while (!pointAchieved) {
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    sum = die1 + die2;

                    // Display the new roll
                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == 7) {
                        System.out.println("Got a seven! You lose.");
                        pointAchieved = true;
                    } else if (sum == 12 || sum == 3 || sum == 2) {
                        System.out.println("Craps! You crapped out.");
                        pointAchieved = true;
                    } else if (sum == 7 || sum == 11) {
                        System.out.println("Natural! You win.");
                        pointAchieved = true;
                    } else if (sum == sum) { // Check if the point is made
                        System.out.println("Made point! You win.");
                        pointAchieved = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            continuePlaying = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}