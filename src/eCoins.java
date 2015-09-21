import java.util.*;

/**
 * Solution to the e-Coins problem that can be found at https://open.kattis.com/problems/ecoins
 * @author Ludwig Sidenmark
 *
 */

public class eCoins {
	static int[][] matrix = new int[301][301];
	static int[] v1 = new int[41];
	static int[] v2 = new int[41];
	
	public static void main(String[] args) {
		int n,m,s;
		int square, least;
		Scanner scr = new Scanner(System.in);
		n = scr.nextInt();
		
		while(n != 0){
			m = scr.nextInt();
			s = scr.nextInt();
			for(int i = 0; i < m; i++){
				v1[i] = scr.nextInt();
				v2[i] = scr.nextInt();
			}
			for(int i = 0; i <= s; i++){
				for(int j = 0; j <= s; j++){
					matrix[i][j] = Integer.MAX_VALUE-1;
				}
			}
			matrix[0][0] = 0;
			for(int i = 0; i < m; i++){
				for(int j = v1[i]; j <= s; j++){
					for(int k = v2[i]; k <= s; k++){
						matrix[j][k] = Math.min(matrix[j][k], 1 + matrix[j-v1[i]][k-v2[i]]);
					}
				}
			}
			
			square = s*s;
			least = Integer.MAX_VALUE - 1;
			
			for(int i = 0; i <=s; i++){
				for(int j = 0; j <= s; j++){
					if (i*i + j*j == square){
						//System.out.println("rot hittad I, J = " + i + " " + j + " värde = " + matrix[i][j]);
						least = Math.min(least, matrix[i][j]);
						//System.out.println("Nytt least: " + least);
					}
				}
			}
			if(least == Integer.MAX_VALUE - 1){
				System.out.println("not possible");
			} else {
				System.out.println(least);
			}
			n--;
		}
		scr.close();
	}
}
