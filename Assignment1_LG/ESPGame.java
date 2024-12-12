/*
 * Class: CMSC203 
 * Instructor:Prof. Aygun
 * Description: The program should randomly select the name of a color from list of words in a file colors.txt 
 * Due: September 16th, 2024
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Leslie N. Guevara Amaya
*/
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {
    public static void main(String[] args) {
        final int NUM_COLORS = 16; // 16 colors in the file
        final int NUM_TRIALS = 3;  // Number of rounds in the game
        final String FILENAME = "colors.txt"; // the name of the file with colors

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Array to temporarily store the colors
        String[] colors = new String[NUM_COLORS];
        int colorCount = 0;

        // Read colors from the file
        try (Scanner fileScanner = new Scanner(new File(FILENAME))) {
            while (fileScanner.hasNextLine() && colorCount < NUM_COLORS) {
                colors[colorCount++] = fileScanner.nextLine();
            }
            if (colorCount < NUM_COLORS) {
                System.err.println("Error: Not enough colors in the file.");
                return;
            }
        } catch (IOException e) {
            System.err.println("Something went wrong while reading the file: " + e.getMessage());
            return;
        }

        // Show the colors to the user
        System.out.println("Here are the colors:");
        for (int i = 0; i < NUM_COLORS; i++) {
            System.out.println((i + 1) + ". " + colors[i]);
        }

        int correctGuesses = 0;

        // Main game loop
        for (int round = 1; round <= NUM_TRIALS; round++) {
            System.out.println("\nRound " + round);
            System.out.println("I'm thinking of one of the colors from the list above.");
            System.out.print("Can you guess which one? ");

            String guess = scanner.nextLine();
            String selectedColor = colors[random.nextInt(NUM_COLORS)];

            // Convert both guess and selected color to lower case for comparison
            String normalizedGuess = guess.toLowerCase().strip();
            String normalizedSelectedColor = selectedColor.toLowerCase().strip();

            if (normalizedGuess.equals(normalizedSelectedColor)) {
                System.out.println("Correct! I was thinking of " + selectedColor + ".");
                correctGuesses++;
            } else {
                System.out.println("Not quite. I was thinking of " + selectedColor + ".");
            }
        }

        // Game over message
        System.out.println("\nGame Over!");
        System.out.println("You got " + correctGuesses + " out of " + NUM_TRIALS + " correct.");

        // Get user details
        System.out.print("What's your name? ");
        String name = scanner.nextLine();

        System.out.print("Tell us a bit about yourself: ");
        String description = scanner.nextLine();

        System.out.print("What's your due date (MM/DD)? ");
        String dueDate = scanner.nextLine();

        // Show the collected information
        System.out.println("Thanks for playing!");
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Due Date: " + dueDate);

        scanner.close();
    }
}
