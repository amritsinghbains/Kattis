import java.util.*;

/**
 * Solution to the Reversed Binary Numbers problem that can be found at https://open.kattis.com/problems/reversebinary
 * @author Ludwig Sidenmark
 *
 */

public class reversebinary {

	public static void main(String[] args) {

		Scanner scr = new Scanner(System.in);

		int x = scr.nextInt();
		int b = 0;
		while (x != 0) {
			b <<= 1;
			b |= (x & 1);
			x >>= 1;
		}
		System.out.println(b);
		scr.close();
	}
}
