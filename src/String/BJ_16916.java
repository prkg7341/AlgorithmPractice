package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] s = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();

		if (p.length > s.length) {
			System.out.println(0);
			return;
		}

		if (s.length == p.length) {
			for (int i = 0; i < s.length; i++) {
				if (s[i] != p[i]) {
					System.out.println(0);
					return;
				}
			}

			System.out.println(1);
			return;
		}

		if (s[0] == p[0]) {
			boolean con = true;
			for (int i = 0; i < p.length && con; i++) {
				if (s[i] != p[i])
					con = false;
			}
			if (con) {
				System.out.println(1);
				return;
			}
		}

		int si = 1, pi = 0;
		int[] ar = new int[s.length];

		while (si < s.length) {
			if (s[si] == p[pi]) {
				ar[si++] = ++pi;
				if (pi == p.length) {
					System.out.println(1);
					return;
				}
			} else {
				if (pi == 0)
					si++;
				else
					pi = ar[pi - 1];
			}
		}
		System.out.println(0);
	}
}