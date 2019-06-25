package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Max2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = -1;
		int x = -1;
		int y = -1;

		for(int i=1 ; i<=9 ; i++){
			String[] input = br.readLine().split(" ");
			for(int j=1 ; j<=9 ; j++){
				int now = Integer.parseInt(input[j-1]);
				if(now>max){
					max = now;
					x = i;
					y = j;
				}
			}
		}

		System.out.println(max);
		System.out.print(x+" "+y);		
	}
}
