package SWM2;

import java.util.Scanner;

public class SWM2_3 {	
	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] ar = new int[n][n];

		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		int max = dnq(ar, 0, 0, n-1, n-1);

		System.out.println(max);
	}

	private static int dnq(int[][] ar, int sr, int sc, int er, int ec) {

		int midr = (sr+er)/2;
		int midc = (sc+ec)/2;
		int max;

		if(sr==er) {
			if(ec-sc==1) return Math.max(ar[sr][sc], ar[sr][ec]);
			int max1 = max(ar, sr, midc+1, er, ec) + dnq(ar, sr, sc, er, midc);
			int max2 = max(ar, sr, sc, er, midc) + dnq(ar, sr, midc+1, er, ec);			
			max = Math.max(max1, max2);
		}

		else if(sc==ec) {
			if(er-sr==1) return Math.max(ar[sr][sc], ar[er][sc]);
			int max1 = max(ar, midr+1, sc, er, ec) + dnq(ar, sr, sc, midr, ec);
			int max2 = max(ar, sr, sc, midr, ec) + dnq(ar, midr+1, sc, er, ec);			
			max = Math.max(max1, max2);
		}

		else {
			int max1 = max(ar, midr+1, sc, er, ec) + dnq(ar, sr, sc, midr, ec);
			int max2 = max(ar, sr, sc, midr, ec) + dnq(ar, midr+1, sc, er, ec);			
			int max3 = max(ar, sr, midc+1, er, ec) + dnq(ar, sr, sc, er, midc);
			int max4 = max(ar, sr, sc, er, midc) + dnq(ar, sr, midc+1, er, ec);			
			max = Math.max(Math.max(max1, max2), Math.max(max3, max4));		
		}
		return max;
	}

	private static int max(int[][] ar, int sr, int sc, int er, int ec) {
		int max = 0;

		for(int i=sr ; i<=er ; i++) {
			for(int j=sc ; j<=ec ; j++) {
				max = Math.max(max, ar[i][j]);
			}
		}
		return max;
	}
}