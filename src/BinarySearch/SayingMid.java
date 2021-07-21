package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SayingMid {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0 ; i<n ; i++) {
			int now = Integer.parseInt(br.readLine());
			list.add(biSearch(list, now, 0, list.size()-1), now);
			sb.append(list.get(((list.size()-1)/2))).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int biSearch(ArrayList<Integer> list, int value, int left, int right) {

		if(left>right) return left;

		int mid = (left+right)/2;

		int mid_value = list.get(mid);

		if(mid_value>value) {
			return biSearch(list, value, left, mid-1);
		}
		else if(mid_value==value) {
			return mid;
		}
		else {
			return biSearch(list, value, mid+1, right);
		}
	}
}
