package FindRule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			int n = Integer.parseInt(br.readLine());

			int standard = n/2;
			int sum = 0;

			for(int i=0 ; i<n ; i++){
				String[] input = br.readLine().split("");
				for(int j=0 ; j<n ; j++) {
					if(mht(standard,i,j)<=standard) sum +=Integer.parseInt(input[j]);
				}
			}

			System.out.printf("#%d %d\n", tt, sum);
		}
	}

	private static int mht(int standard, int i, int j) {		
		return Math.abs(standard-i)+Math.abs(standard-j);
	}	
}
