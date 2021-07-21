package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindSeatToLay {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][n];

		for(int i=0 ; i<n ; i++){
			String input = br.readLine();
			for(int j=0 ; j<n ; j++){
				ar[i][j] = input.charAt(j)=='.'? 0 : 1;
			}
		}

		int count = 0;

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(ar[i][j]==0){
					int check = j;
					while(j!=n && ar[i][j]==0){
						j++;
					}
					if(j-check>=2)
						count++;
				}
			}
		}
		System.out.print(count+" ");
		count=0;
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(ar[j][i]==0){
					int check = j;
					while(j!=n && ar[j][i]==0){
						j++;
					}
					if(j-check>=2)
						count++;
				}
			}
		}
		System.out.print(count);
	}	
}
