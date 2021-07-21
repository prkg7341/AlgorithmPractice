package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LayingBridge_NonDP {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");

			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			if(a==b){
				System.out.println(1);
				continue;
			}

			a = Math.min(a, b-a);

			int result = c(a,b);

			System.out.println(result);
		}
	}

	private static int c(int a, int b) {

		int result=1;

		for(int i=a ; i!=0 ; i--){
			result*=b--;
			result/=(a-i+1);
		}

		return result;
	}
}
