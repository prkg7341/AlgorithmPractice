package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1188 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		n %= num;

		if (n == 0 || n == num) {
			System.out.println(0);
			return;
		}

		int n_ = n;
		int num_ = num;

		int div;

		while (true) {
			if (n_ > num_) {
				int temp = n_;
				n_ = num_;
				num_ = temp;
			}

			if (num_ % n_ == 0) {
				div = n_;
				break;
			} else {
				num_ -= n_;
			}
		}

		n /= div;
		num /= div;

		int result = (n * (num / n) + (num % n - 1)) * div;

		System.out.println(result);

	}
}