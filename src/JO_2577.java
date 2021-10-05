import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_2577 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int num = Integer.parseInt(stringTokenizer.nextToken());
		int k = Integer.parseInt(stringTokenizer.nextToken());
		int c = Integer.parseInt(stringTokenizer.nextToken());

		int[] ar = new int[n];
		int[] count = new int[num + 1];
		int inc = 0;

		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			ar[i] = now;
			if (count[now] == 0)
				inc++;
			if (i < k) {
				count[now]++;
			}
		}
		int max = 0;

		max = inc;
		if (count[c] == 0)
			max++;

		for (int i = 0; i < n; i++) {
			int right_index = (i + k) % n;
			int left_index = i;

			int left = ar[left_index];
			int right = ar[right_index];

			if (left == right)
				continue;

			if (--count[left] == 0)
				inc--;

			if (count[right]++ == 0)
				inc++;

			if (count[c] == 0)
				inc++;
			max = Math.max(max, inc);
		}

		System.out.print(max);
	}
}
