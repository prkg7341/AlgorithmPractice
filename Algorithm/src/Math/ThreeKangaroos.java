package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreeKangaroos {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);

		int[] ar = {a,b,c};

		Arrays.sort(ar);

		int min = ar[0];
		int mid = ar[1];
		int max = ar[2];
		if((max-mid)>(mid-min)){
			System.out.println(max-mid-1);
		}
		else{
			System.out.println(mid-min-1);
		}		
	}	
}
