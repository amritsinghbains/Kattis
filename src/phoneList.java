import java.util.Scanner;

/**
 * Solution to the Phone List problem that can be found at https://open.kattis.com/problems/phonelist
 * @author Ludwig Sidenmark
 *
 */

public class phoneList {

	private static Trie trie = new Trie();
	private static boolean isConsistent = true;

	public static void main(String[] args) {

		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		for (int i = 0; i < n; i++) {
			int m = scr.nextInt();
			scr.nextLine();
			trie = new Trie();
			isConsistent = true;
			for (int j = 0; j < m; j++) {
				String phone = scr.nextLine();
				if (isConsistent)
					buildTrie(phone);
			}
			if (isConsistent)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		scr.close();
	}

	private static void buildTrie(String phone) {
		int length = phone.length();
		Trie tmpTrie = trie;

		for (int i = 0; i < length; i++) {
			int ch = Integer.parseInt(phone.substring(i, i + 1));
			Trie tmp = tmpTrie.next[ch];

			if (tmp == null) {
				tmp = new Trie();
				tmp.node = 1;
				if (i == length - 1) {
					tmp.isLast = true;
				}
				tmpTrie.next[ch] = tmp;
				tmpTrie = tmp;
			} else {
				if (tmp.isLast) {
					isConsistent = false;
					break;
				}
				if (i == length - 1) {
					isConsistent = false;
					break;
				}
				tmpTrie = tmp;
			}
		}

	}

	private static class Trie {
		int node = 0;
		boolean isLast = false;
		Trie[] next = new Trie[10];

	}

}
