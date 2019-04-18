package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DNA {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		char[][] ar = new char[n][m];

		for(int i=0 ; i<n ; i++){
			ar[i] = br.readLine().toCharArray();
		}

		int sum=0;

		for(int i=0 ; i<m ; i++){
			int[] count = new int[26];
			for(int j=0 ; j<n ; j++){
				count[(int)(ar[j][i])-65]++;
			}
			int index=-1;
			int max = -1;
			for(int j=0 ; j<26 ; j++){
				if(count[j]>max){
					max = count[j];
					index = j;
				}
			}
			sum+=(n-max);
			sb.append((char) (index+65));
		}
		sb.append("\n").append(sum);
		System.out.print(sb.toString());
	}
}