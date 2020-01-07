

import java.util.Scanner;

public class StoneGame1{

	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String result = n%2==1? "SK" : "CY";
		System.out.print(result);
		sc.close();
	}
}