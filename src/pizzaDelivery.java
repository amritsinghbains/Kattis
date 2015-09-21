import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Solution to the Pizza Delivery problem that can be found at https://open.kattis.com/problems/pizza
 * @author Ludwig Sidenmark
 *
 */

public class pizzaDelivery {

	static int n;
	static int y;
	static int x;
	static int least;
	static int[][] g;

	public static void main(String[] args) {

		Scanner scr = new Scanner(System.in);
		n = scr.nextInt();
		while (n != 0) {
			least = Integer.MAX_VALUE;
			x = scr.nextInt();
			y = scr.nextInt();
			g = new int[y][x];
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					g[i][j] = scr.nextInt();

				}
			}
			
			Queue<Tuple<Integer, Integer>> q = new LinkedList<Tuple<Integer, Integer>>();
			q.add(new Tuple<Integer, Integer>(0,0));
			
			while(!q.isEmpty()){
				Tuple<Integer, Integer> curr = q.remove();
				int currValue = countDistance(curr.y,curr.x);
				if(currValue < least){
					least = currValue;
					q.add(new Tuple<Integer, Integer>(curr.y + 1, curr.x));
					q.add(new Tuple <Integer, Integer>(curr.y, curr.x  + 1));
				}
				
			}

			System.out.println(least + " blocks");
			n--;
		}
		scr.close();

	}

	private static int countDistance(int a, int b) {
		int curr = 0;

				for (int k = 0; k < y; k++) {
					for (int l = 0; l < x; l++) {
						curr += ((Math.abs(a - k) * g[k][l]) + (Math.abs(b - l)) * g[k][l]);
					}
				}

			

		return curr;
	}
	public static class Tuple<X, Y> { 
		  public final X x; 
		  public final Y y; 
		  public Tuple(X x, Y y) { 
		    this.x = x; 
		    this.y = y; 
		  } 
		}

}

