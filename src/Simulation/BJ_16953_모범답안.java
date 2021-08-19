package Simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16953_모범답안 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		int count = 1;

		while (from != to) {
			if (to < from) {
				System.out.println(-1);
				return;
			} else if (to % 10 == 1) {
				to /= 10;
			} else if (to % 2 == 0) {
				to /= 2;
			} else {
				System.out.println(-1);
				return;
			}
			count++;
		}
		System.out.println(count);
	}
}