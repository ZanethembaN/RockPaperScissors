package za.co.wethinkcode;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    private static final String[] VALID_CHOICES = {"rock", "paper", "scissors"};
    private static int MOVES = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0;
        int computerScore = 0;

        while (MOVES > 0) {
            System.out.println("\nLet's play Rock, Paper, Scissors!");
            String userChoice = getUserChoice(scanner);
            String computerChoice = getComputerChoice(random);

            System.out.println("\nYou chose " + userChoice + ".");
            System.out.println("Computer chose " + computerChoice + ".");

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);

            if (result.contains("You win")) {
                userScore++;
            } else if (result.contains("Computer wins")) {
                computerScore++;
            }

            System.out.println("\nScore - You: " + userScore + ", Computer: " + computerScore);

            MOVES--;
        }

        playAgain(scanner);
    }

    private static String getUserChoice(Scanner scanner) {
        String userChoice;
        while (true) {
            System.out.print("Choose Rock, Paper, or Scissors: ");
            userChoice = scanner.nextLine().toLowerCase();
            if (isValidChoice(userChoice)) {
                break;
            } else {
                System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
            }
        }
        return userChoice;
    }

    private static boolean isValidChoice(String choice) {
        for (String validChoice : VALID_CHOICES) {
            if (validChoice.equals(choice)) {
                return true;
            }
        }
        return false;
    }

    private static String getComputerChoice(Random random) {
        int computerChoiceIndex = random.nextInt(VALID_CHOICES.length);
        return VALID_CHOICES[computerChoiceIndex];
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    private static void playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String playAgain = scanner.nextLine().toLowerCase();
        if (playAgain.equals("yes")) {
            MOVES = 3; // Reset moves for a new game
            main(null); // Restart the game
        } else {
            System.out.println("Thank you for playing Rock, Paper, Scissors!");
            scanner.close();
        }
    }
}
