package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeastEditDistance {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st1 = br.readLine();
		String st2 = br.readLine();

		int[][] ar = new int[st1.length()+1][st2.length()+1];

		for(int i=1 ; i<=st1.length() ; i++){
			ar[i][0] = i;
		}
		for(int i=1 ; i<=st2.length() ; i++){
			ar[0][i] = i;
		}
		for(int i=1 ; i<=st1.length() ; i++){
			for(int j=1 ; j<=st2.length() ; j++){
				int min = st1.charAt(i-1)==st2.charAt(j-1)? ar[i-1][j-1] : ar[i-1][j-1]+1;
				min = Math.min(min, Math.min(ar[i-1][j]+1, ar[i][j-1]+1));
				ar[i][j] = min;
			}
		}
		System.out.println(ar[st1.length()][st2.length()]);
	}
}
