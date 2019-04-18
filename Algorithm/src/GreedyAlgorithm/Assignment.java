package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Assignment {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][2];

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			ar[i][0] = Integer.parseInt(input[0]);
			ar[i][1] = Integer.parseInt(input[1]);
		}
		Arrays.sort(ar, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0]-o1[0];
			}			
		});

		int last = ar[0][0];
		int max=-1;
		int sum=0;
		int index=-1;

		while(last>0){
			for(int i=0 ; i<n && ar[i][0]>=last ; i++){
				if(ar[i][1]>max){
					max = ar[i][1];
					index = i;
				}
			}
			last--;
			if(index==-1) continue;
			sum += max;
			max = -1;
			ar[index][1] = -1;
			index = -1;
		}
		System.out.print(sum);
	}
}