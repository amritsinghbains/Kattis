import java.util.LinkedList;
import java.util.Scanner;

/**
 * Solution to the Coast Length problem that can be found at https://open.kattis.com/problems/coast
 * @author Ludwig Sidenmark
 *
 */


public class Coast {
	static LinkedList<Integer> list;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int h = scr.nextInt();
		int w = scr.nextInt();

		boolean[][] map = new boolean[h][w];
		boolean[][] outside = new boolean[h][w];
		boolean[][] visited = new boolean[h][w];

		String line = scr.nextLine();
		for (int i = 0; i < h; i++) {
			line = scr.nextLine();
			for (int k = 0; k < w; k++) {
				map[i][k] = (line.charAt(k) - '0' == 1) ? true : false;
			}
		}

		list = new LinkedList<Integer>();
		for (int i = 0; i < w; i++) {
			list.add(0 * 10000 + i);
			list.add((h - 1) * 10000 + i);
		}

		for (int i = 0; i < h; i++) {
			list.add(i * 10000 + 0);
			list.add((i - 1) * 10000 + w - 1);
		}
		while (!list.isEmpty()) {
			int ele = list.removeFirst();
			int aa = ele / 10000;
			int bb = ele % 10000;

			findOutside(aa, bb, map, outside, visited);
		}

		System.out.println(findBorder(outside));
		scr.close();
	}

	private static void findOutside(int h, int w, boolean[][] map,
			boolean[][] outside, boolean[][] visited) {

		if (h < 0)
			return;
		if (w < 0)
			return;
		if (h > map.length - 1)
			return;
		if (w > map[0].length - 1)
			return;
		if (visited[h][w])
			return;

		visited[h][w] = true;

		if (map[h][w] == false) {
			outside[h][w] = true;

			list.add((h - 1) * 10000 + w);
			list.add((h + 1) * 10000 + w);
			list.add(h * 10000 + w - 1);
			list.add(h * 10000 + w + 1);

		}
	}

	private static int findBorder(boolean[][] outside) {
		int h = outside.length;
		int w = outside[0].length;

		boolean[][] mOutside = new boolean[h + 2][w + 2];

		for (int i = 0; i < h + 2; i++) {

			mOutside[i][0] = true;
			mOutside[i][w + 1] = true;

		}

		for (int k = 0; k < w + 2; k++) {
			mOutside[0][k] = true;
			mOutside[h + 1][k] = true;
		}

		for (int i = 1; i < h + 1; i++) {
			for (int k = 1; k < w + 1; k++) {
				mOutside[i][k] = outside[i - 1][k - 1];
			}
		}

		int num = 0;

		for (int i = 1; i < h + 1; i++) {
			for (int k = 1; k < w + 1; k++) {
				if (!mOutside[i][k]) {
					if (mOutside[i + 1][k])
						num++;
					if (mOutside[i - 1][k])
						num++;
					if (mOutside[i][k + 1])
						num++;
					if (mOutside[i][k - 1])
						num++;
				}

				// System.out.printf("%7b",mOutside[i][k]);
			}
			// System.out.println();
		}

		return num;
	}

}