package DivideAndConquer;

import java.math.BigInteger;
import java.util.Scanner;

public class Hanoi {

	static StringBuilder sb;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		sc.close();

		if(n<=20){
			sb = new StringBuilder();

			hanoi(n, 1, 2, 3);

			sb.deleteCharAt(sb.length()-1);

			System.out.println((int)Math.pow(2, n)-1);
			System.out.println(sb.toString());
		}

		else{
			BigInteger result=new BigInteger("1");
			for(int i=0 ; i<n ; i++) {
				result=result.multiply(new BigInteger("2"));
			}
			result=result.subtract(new BigInteger("1"));
			System.out.println(result);
		}
	}

	private static void hanoi(int extras, int t1, int t2, int t3) {
		if(extras==1){
			sb.append(t1 + " " + t3 + "\n");
		}
		else{	
			hanoi(extras-1, t1, t3, t2);
			sb.append(t1 + " " + t3 + "\n");
			hanoi(extras-1,t2,t1,t3);
		}		
	}	
}
