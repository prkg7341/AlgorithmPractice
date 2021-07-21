package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Statistics {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] result = new int [4];
		if(n==1){
			result[0] = Integer.parseInt(br.readLine());
			result[1] = result[0];
			result[2] = result[0];
		}
		else{
			int[][] ar = new int[n][2];
			int sum=0;

			for(int i=0 ; i<n ; i++){
				ar[i][0] = Integer.parseInt(br.readLine());
				sum += ar[i][0]; 
			}

			Arrays.sort(ar, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});

			result[0] = Math.round(((float)sum / n));
			result[1] = ar[n/2][0];		
			result[3] = ar[n-1][0]-ar[0][0];


			ar[0][1] = 1;
			for(int i=1 ; i<n ; i++){
				if(ar[i-1][0]==ar[i][0]){
					ar[i][1] = ar[i-1][1]+1;
				}
				else{
					ar[i][1] = 1;
				}
			}

			Arrays.sort(ar, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[1] - o1[1];
				}
			});

			if(ar[0][1]!=ar[1][1]){
				result[2] = ar[0][1];
			}
			else{
				result[2] = ar[1][0];
			}
		}


		for(int i=0 ; i<4 ; i++){
			sb.append(result[i]+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
