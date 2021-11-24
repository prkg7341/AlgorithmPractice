package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_14465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int broken = Integer.parseInt(st.nextToken());

		boolean[] broken_ar = new boolean[n];

		for (int i = 0; i < broken; i++) {
			broken_ar[Integer.parseInt(br.readLine()) - 1] = true;
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n;) {
			int count = 0;
			if (broken_ar[i]) {
				while (i < n && broken_ar[i]) {
					i++;
					count++;
				}
				if (!list.isEmpty() && i != n) {
					list.add(count);
				}
			} else {
				while (i < n && !broken_ar[i]) {
					i++;
					count++;
				}
				list.add(count);
			}
		}

		if (list.isEmpty()) {
			System.out.println(num);
		} else if (list.size() == 1) {
			if (list.get(0) >= num)
				System.out.println(0);
			else
				System.out.println(num - list.get(0));
		} else {
			int min = num;
			int left = 0;
			int right = 0;
			int sum = list.get(0);
			int B = 0;

			while (right < list.size()) {
//				System.out.println(left+" "+right+" "+sum);
				if (sum < num) {
					min = Math.min(min, (num - sum) + B);
					if (right == list.size() - 1)
						break;
					sum += list.get(++right) + list.get(++right);
					B += list.get(right - 1);
				} else if (right == left) {
					System.out.println(0);
					return;
//					if(right==list.size()-1) break;
//					sum += list.get(++right)+list.get(++right);
//					sum -= list.get(++left)+list.get(++left);
				} else {
					min = Math.min(min, B);
					sum -= list.get(left++) + list.get(left++);
					B -= list.get(left - 1);
				}
			}
			System.out.println(min);
		}
	}
}