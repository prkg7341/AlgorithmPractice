package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] ar = br.readLine().toCharArray();

		if (pel(ar)) {
			if (same(ar)) {
				System.out.println(-1);
			} else {
				System.out.println(ar.length - 1);
			}
		} else {
			System.out.println(ar.length);
		}
	}

	private static boolean pel(char[] ar) {
		for (int i = 0; i < ar.length / 2; i++) {
			if (ar[i] != ar[ar.length - 1 - i])
				return false;
		}
		return true;
	}

	private static boolean same(char[] ar) {
		char c = ar[0];
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] != c)
				return false;
		}
		return true;
	}
}
