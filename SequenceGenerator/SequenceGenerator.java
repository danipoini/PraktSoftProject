/**
 * @author Cleo Pau
 *
 */
import java.util.Scanner;

public class SequenceGenerator {
	
	public static void main(String[] args) {

		Scanner choiceScan = new Scanner(System.in);
		String choice = "";
		
		System.out.println("Sequence Generator");
		
		while (!choice.equals("17")) {
			System.out.println("----------------------------------------");
			System.out.println("");
			System.out.println("0 - Pentagonal numbers");
			System.out.println("1 - Hexagonal Sequenece");
			System.out.println("2 - Catalan Numbers");
			System.out.println("3 - Prime Numbers");
			System.out.println("5 - Triangular Numbers");
			System.out.println("6 - Magic Squares sequence");
			System.out.println("7 - Fibonacci Numbers");
			System.out.println("8 - Armstrong Numbers");
			System.out.println("9 - Syracuse (Collatz) sequence (see here)");
			System.out.println("10 - Padovan sequence");
			System.out.println("11 - Lazy Caterer's numbers");
			System.out.println("12 - Consecutive numbers sequence");
			System.out.println("13 - Squares whose digits are squares sequence");
			System.out.println("14 - Final digit of cubes sequence");
			System.out.println("15 - Hofstadter sequence 1 (sums)");
			System.out.println("16 - Hofstadter sequence 2 (products)");
			System.out.println("17 - Quit");

			System.out.print("Please enter the number of the sequence you would like to work with: ");
			choice = choiceScan.nextLine();
			int choice_num = Integer.parseInt(choice);

			switch (choice_num) {
			default:
				if (choice_num > 17 || choice_num < 0) {
					System.out.println("Invalid Choice");
				}
				break;
			}
		}
		choiceScan.close();
		System.out.println(">> Good Bye");
	}
}
