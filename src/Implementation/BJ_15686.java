package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15686 {

	static ArrayList<Position> hList;
	static ArrayList<Position> cList;
	static int min = 123456789;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int num = Integer.parseInt(stringTokenizer.nextToken());

		hList = new ArrayList<>();
		cList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int now = Integer.parseInt(stringTokenizer.nextToken());

				if (now == 1)
					hList.add(new Position(i, j));
				if (now == 2)
					cList.add(new Position(i, j));
			}
		}

		for (Position position : cList) {
			position.times = new int[hList.size()];
			Arrays.fill(position.times, 123456789);
			for (int i = 0; i < position.times.length; i++) {
				position.times[i] = Math.min(position.times[i],
						Math.abs(position.r - hList.get(i).r) + Math.abs(position.c - hList.get(i).c));
			}
		}

		int[] arr = new int[num];
		c(arr, 0, 0);
		System.out.println(min);
	}

	private static void c(int[] arr, int arr_index, int depth) {
		if (depth == arr.length) {
			int sum = 0;

			for (int i = 0; i < hList.size(); i++) {
				int temp = 123456789;
				for (int j = 0; j < arr.length; j++) {
					temp = Math.min(temp, cList.get(arr[j]).times[i]);
				}
				sum += temp;
			}

			min = Math.min(min, sum);
			return;
		}
		if (arr_index == cList.size())
			return;

		arr[depth] = arr_index;
		c(arr, arr_index + 1, depth + 1);
		c(arr, arr_index + 1, depth);
	}

	static class Position {
		int r, c;
		int[] times;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
