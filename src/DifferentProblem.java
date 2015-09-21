import java.util.Scanner;

/**
 * Solution to the "A different Problem" problem that can be found at https://kth.kattis.com/problems/different
 * @author Ludwig Sidenmark
 *
 */

public class DifferentProblem {

	
	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		while(scr.hasNext()){
			String line = scr.nextLine();
			String[] numbers = line.split(" ");
			long nr1 = Long.parseLong(numbers[0]);
			long nr2 = Long.parseLong(numbers[1]);
			System.out.println(Math.abs(nr1 - nr2));
		}
		scr.close();
	}
}
