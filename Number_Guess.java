import java.util.InputMismatchException;
import java.util.Scanner;

public class Number_Guess {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to the Game");
        number_Guessing_Game();
    }

    public static void number_Guessing_Game() {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random());  
        int k_trails = 5;  

        System.out.println("Guess a number between 1 and 100. You have " + k_trails + " chances.");

        for (int i = 0; i < k_trails; i++) {
            System.out.println("Attempt " + (i + 1) + ": Guess the number: ");
            try {
                int guess_no = sc.nextInt();

                if (guess_no == number) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    break;
                } else if (guess_no > number && i != k_trails - 1) {
                    System.out.println("The guessed number is too high.");
                } else if (guess_no < number && i != k_trails - 1) {
                    System.out.println("The guessed number is too low.");
                }

               
                if (i == k_trails - 1) {
                    System.out.println("Sorry, you've completed all attempts.");
                    System.out.println("The number was: " + number);
                }

               
                Thread.sleep(2000);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next();  
                i--;  
            } catch (InterruptedException e) {
                System.out.println("An error occurred while waiting.");
                Thread.currentThread().interrupt();  
                break;
            }
        }

        System.out.println("Thank you for playing the game!");
    }
}
