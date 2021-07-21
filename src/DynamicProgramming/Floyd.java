package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Floyd {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int city = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());

		int[][] ar = new int[city][city];

		for(int i=0 ; i<city ; i++){
			for(int j=0 ; j<city ; j++){
				ar[i][j] = 123456789;
			}
		}

		for(int i=0 ; i<bus ; i++){
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);

			ar[start-1][end-1] = Math.min(ar[start-1][end-1], cost);		
		}
		for(int k=0 ; k<city ; k++){
			for(int i=0 ; i<city ; i++){
				for(int j=0 ; j<city ; j++){
					if(i==j) continue;
					if(ar[i][j]>ar[i][k]+ar[k][j]){
						ar[i][j] = ar[i][k]+ar[k][j];
					}
				}
			}
		}
		for(int k=0 ; k<city ; k++){
			for(int i=0 ; i<city ; i++){
				if(ar[k][i]==123456789){
					ar[k][i] = 0;
				}
				sb.append(ar[k][i]+" ");
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}	
}
