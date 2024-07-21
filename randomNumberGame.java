import java.util.Scanner;
import java.util.Random;

public class RandomNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        GameMessages();
        String gameNumber = generateRandomNumber();

        while (true) {
            System.out.println("Enter input: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program...");
                break;
            }

            if (input.equalsIgnoreCase(gameNumber)) {
                System.out.println("---------------------------------------------------------------");
                System.out.println("YOU WON! The number was " + gameNumber);
                System.out.println("---------------------------------------------------------------");
                break;
            }

            EvaluateNumberCloseness(input, gameNumber);
        }

        scanner.close();
    }

    private static String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return Integer.toString(randomNumber);
    }

    private static void GameMessages() {
        System.out.println("Enter 'exit' to quit the program");
        System.out.println("Welcome to the Random Number Game. Enter your number to see how close you are: ");
    }

    private static void EvaluateNumberCloseness(String input, String numberToGuess) {
        int inputNumber = Integer.parseInt(input);
        int gameNumber = Integer.parseInt(numberToGuess);

        if (inputNumber > gameNumber) {
            System.out.println("Your number was: " + input + ", and was too high. Guess again!");
        }

        if (inputNumber < gameNumber) {
            System.out.println("Your number was: " + input + ", and was too low. Guess again!");
        }

        System.out.println("---------------------------------------------------------------");
    }
}