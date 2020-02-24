package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_1931_MeetingRoomAssignment {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int [n][2];

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			ar[i][0] = Integer.parseInt(input[0]);
			ar[i][1] = Integer.parseInt(input[1]);
		}

		Arrays.sort(ar, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int max = 0;
		int count=0;

		for(int i=0 ; i<n ; i++){
			int start = ar[i][0];
			int end = ar[i][1];
			if(start>=max){
				max = end;
				count++;
			}
			else{
				if(end<max){
					max = end;
				}
			}
		}
		System.out.print(count);
	}
}