package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int l = Integer.parseInt(br.readLine());

			char[] ar = br.readLine().toCharArray();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < l; i++) {
				char now = ar[i];

				if (i == 0) {
					sb.append(now);
				} else if (now >= '0' && now <= '9') {
					if ((ar[i - 1] == '*' || ar[i - 1] == '/')
							&& (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-')) {
						sb.insert(sb.length() - 1, now).insert(sb.length() - 1, ar[i - 1]);
					} else {
						sb.append(now).append(ar[i - 1]);
					}
				}
			}

			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < l; i++) {
				char now = sb.charAt(i);

				if (now >= '0' && now <= '9') {
					stack.add((int) (now - '0'));
				} else {
					switch (now) {
					case '+':
						stack.add(stack.pop() + stack.pop());
						break;
					case '-':
						stack.add(-stack.pop() + stack.pop());
						break;
					case '*':
						stack.add(stack.pop() * stack.pop());
						break;
					case '/':
						int temp = stack.pop();
						stack.add(stack.pop() / temp);
						break;
					}
				}
			}

			System.out.printf("#%d %d\n", t, stack.pop());
		}
	}
}
