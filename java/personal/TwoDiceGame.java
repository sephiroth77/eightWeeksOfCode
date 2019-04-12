import java.util.Random;
import java.util.Scanner;

public class TwoDiceGame {

	public static void main(String[] args) throws InterruptedException {
		Random random;
		random = new Random();

		Scanner obj = new Scanner(System.in);
		Scanner obj2 = new Scanner(System.in);
		int x, y;
		int num = 1;
		// boolean done = false;
		x = (random.nextInt(6) + 1);
		y = (random.nextInt(6) + 1);
		String first;

		int result = x + y;
		System.out.println("VERIFICATION NEEDED.");
		System.out.println("Please enter 'tiger' and press enter.");
		String password = obj.next();
		System.out.println("");
		if (!password.equals("tiger")) {
			num = 99;
			boolean done = false;
			if (password.equals("TIGER")) {
				System.out.print("Sorry, I asked for tiger not TIGER");
			} else if (password.equals("Tiger")) {
				System.out.print("Sorry, I asked for tiger not Tiger");
			} else {
				System.out.print("Sorry. That does not spell tiger.");
			}
		}
		// while(!done) {
		if (num == 1) {
			System.out.println("Would you like to play a game?");
			System.out.println("You will roll the dice twice and I will add " + "them for you.");
		}
		System.out.println("");
		while (password.equals("tiger")) {
			System.out.println("Please enter 'x' to roll the first dice " + "('q' to quit): ");
			first = obj.next();
			System.out.println("");

			if (first.equals("x")) {
				System.out.println("You rolled the dice!");
				System.out.println("You rolled a " + x + "!");
				break;
			} else if (first.equals("q")) {
				System.out.println("Thank you for playing.");
				num = 3;
				password = "orange";
				break;
			} else {
				System.out.println("This is not what I asked you to press");
			}

		}
		while (password.equals("tiger")) {
			System.out.println("Please enter 'y' to roll the second dice " + "('q' to quit): ");
			System.out.println("");
			first = obj.next();
			if (first.equals("y")) {
				System.out.println("You rolled the dice again!");
				System.out.println("You rolled a " + y + "!");
				break;
			} else if (first.equals("q")) {
				System.out.println("Thank you for playing.");
				num = 2;
				break;
			} else {
				System.out.println("No. That is not what I asked you to press");
			}
		}
		if (num == 1) {
			String second;
			System.out.println("So you rolled a " + x + " and a " + y + "!");
			System.out.println("\nComputing................");
			Thread.sleep(4000);
			System.out.println("\nComputation Complete!");
			System.out.println(x + " + " + y + " = " + result);
			System.out.println("Thank you so much for playing!\n");
			//System.out.println("Would you like to play again? (y/n): ");
			second = obj2.next();
		} else if (num == 99) {
			System.out.println("You did not pass the verification process.");
		} else {
			System.out.println("Come back anytime!");
		}

	}

}
