package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinMax {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int max = -1000001;
		int min = 1000001;

		for(int i=0 ; i<n ; i++){
			min = Math.min(min, Integer.parseInt(input[i]));
			max = Math.max(max, Integer.parseInt(input[i]));
		}
		System.out.print(min+" "+max);
	}
}