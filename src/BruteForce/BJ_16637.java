package BruteForce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16637 {
	static long max = Integer.MIN_VALUE;
	static long[] first;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] input = br.readLine().toCharArray();

		long[] num_array = new long[n / 2 + 1];
		boolean[] skip = new boolean[n / 2];
		char[] char_array = new char[n / 2];

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				num_array[i / 2] = (int) (input[i] - '0');
			else
				char_array[i / 2] = input[i];
		}

		first = num_array.clone();

		rec(num_array, skip, char_array, n / 2);

		System.out.println(max);
	}

	private static void rec(long[] num_array, boolean[] skip, char[] char_array, int index) {
		if (index <= 0) {
			max = Math.max(max, cal(num_array, skip, char_array));
			return;
		}

		rec(num_array, skip, char_array, index - 1);

		skip[index - 1] = true;

		num_array[index - 1] = cal(num_array[index - 1], char_array[index - 1], num_array[index]);

		rec(num_array, skip, char_array, index - 2);

		skip[index - 1] = false;
		num_array[index - 1] = first[index - 1];
	}

	private static long cal(long a, char c, long b) {
		long ret;

		if (c == '+') {
			ret = a + b;
		} else if (c == '-') {
			ret = a - b;
		} else {
			ret = a * b;
		}

		return ret;
	}

	private static long cal(long[] num_array, boolean[] skip, char[] char_array) {

		long ret = num_array[0];

		for (int i = 0; i < num_array.length - 1; i++) {
			if (!skip[i]) {
				char c = char_array[i];
				long b = num_array[i + 1];
				if (c == '+') {
					ret += b;
				} else if (c == '-') {
					ret -= b;
				} else {
					ret *= b;
				}
			}
		}

		return ret;
	}
}