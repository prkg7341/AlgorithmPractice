import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2230 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int dif = Integer.parseInt(st.nextToken());

		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(ar);

		int left = 0;
		int right = 0;
		int min = 2000000000;

		while (true) {
			if (ar[right] - ar[left] >= dif) {
				min = Math.min(min, ar[right] - ar[left]);
				left++;
			} else if (right < n - 1) {
				right++;
			} else
				break;
			if (min == dif)
				break;
		}
		System.out.println(min);
	}
}