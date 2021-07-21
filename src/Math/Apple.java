package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apple {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		int sum = 0;

		for (int i = 0; i < num; i++) {
			String[] input = br.readLine().split(" ");
			int stu = Integer.parseInt(input[0]);
			int apple = Integer.parseInt(input[1]);

			sum += apple % stu;
		}
		System.out.print(sum);
	}
}
