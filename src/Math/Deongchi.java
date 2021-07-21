package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deongchi {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n =  Integer.parseInt(br.readLine());

		int[][] ar = new int[n][3];

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			int weight = Integer.parseInt(input[0]);
			int height = Integer.parseInt(input[1]);
			for(int j=0 ; j<i ; j++){
				if(weight>ar[j][0] && height>ar[j][1]){
					ar[j][2]++;
				}
				else if(weight<ar[j][0] && height<ar[j][1]){
					ar[i][2]++;
				}
			}
			ar[i][0] = weight; ar[i][1] = height;
		}
		for(int i=0 ; i<n ; i++){
			sb.append(ar[i][2]+1).append(" ");
		}
		System.out.print(sb.toString());
	}
}
