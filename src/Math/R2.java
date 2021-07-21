package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int r1 = Integer.parseInt(input[0]);
		int s = Integer.parseInt(input[1]);
		
		int result = 2*s-r1; 
		System.out.println(result);		
	}
}
