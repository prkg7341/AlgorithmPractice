package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SieveofEratosthenes {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		boolean[] erased = new boolean[n+1];
		int[] order = new int[n+1];
		erased[0] = true;
		erased[1] = true;

		int index = 0;

		for(int i=2 ; i<=n ; i++){
			if(!erased[i]){
				for(int j=i ; j<=n ; j+=i){
					if(!erased[j]){
						erased[j] = true;
						order[index++] = j;
						if(index==k){
							System.out.println(order[k-1]);
							return;
						}
					}
				}
			}
		}
	}
}
