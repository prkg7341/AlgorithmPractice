package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WarehousePolygon {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int max = 0;
		int maxindex = 0;
		int minindex = 0;
		int result = 0;

		int[][] ar = new int[n][2];

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			ar[i][0] = Integer.parseInt(input[0]);
			ar[i][1] = Integer.parseInt(input[1]);
			if(ar[i][1]>max){
				max = ar[i][1];
				maxindex = ar[i][0];
				minindex = ar[i][0];
			}
			else if(ar[i][1]==max){
				maxindex = Math.max(maxindex, ar[i][0]);
				minindex = Math.min(minindex, ar[i][0]);
			}
		}

		Arrays.sort(ar, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});

		for(int i=0 ; ar[i][0]<minindex ; i++){
			int start = ar[i][0];
			int h = ar[i][1];
			while(ar[i][0]<minindex && ar[i+1][1]<=h) i++;
			result += h*(ar[i+1][0]-start);
		}
		for(int i=n-1 ; ar[i][0]>maxindex ; i--){
			int start = ar[i][0];
			int h = ar[i][1];
			while(ar[i][0]>maxindex && ar[i-1][1]<=h) i--;
			result += h*(start-ar[i-1][0]);
		}
		result += max*(maxindex-minindex+1);
		System.out.print(result);
	}
}
