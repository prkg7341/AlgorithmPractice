package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();

		char[] arA = a.toCharArray();
		char[] arB = b.toCharArray();

		int[][] lcs = new int[a.length()+1][b.length()+1];

		for(int i=1 ; i<=a.length() ; i++){
			for(int j=1 ; j<=b.length() ; j++){
				lcs[i][j] = arA[i-1]==arB[j-1]? lcs[i-1][j-1]+1 : Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		System.out.println(lcs[a.length()][b.length()]);
	}
}
