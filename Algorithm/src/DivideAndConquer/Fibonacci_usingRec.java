package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_usingRec{

	public static void main(String []args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());

		System.out.println(fib(input));
	}

	static int fib(int num){
		if(num==0){
			return 0;
		}
		else if(num==1){
			return 1;
		}
		else{
			return fib(num-1) + fib(num-2);
		}
	}
}