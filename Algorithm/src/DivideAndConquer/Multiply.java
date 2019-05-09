package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiply {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);

		long result = cal(a,b,c)%c;

		System.out.print(result);
	}

	static long cal(int a, int b, int c){
		long result;

		if(b==1){
			result = a%c;
		}
		else {
			result = cal(a,b/2,c)%c;
			result = (result*result)%c;
			if(b%2==1){
				result = (result*a)%c;
			}
		}
		return result;
	}
}