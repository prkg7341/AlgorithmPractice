package DivideAndConquer;

import java.util.Scanner;

public class Hanoi {

	static void rec(int[] hanoi){

			



		/*if(1,0,나머지 || 0,1,나머지){
			//리턴
		}
		else{
			rec(hanoi);
		}*/
	}



	public static void main(String[] args) {
		int[] hanoi = new int[3];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		if(n>20 || n<1){
			System.out.println("Wrong input");
		}
		else{
			int[][] ar = new int[(int) Math.pow(2, n)-1][2];





			rec(hanoi);
			System.out.println(ar.length);
			for(int i=0 ; i<ar.length ; i++){
				System.out.print(ar[i][0]);System.out.print(" ");System.out.print(ar[i][1]);
				System.out.println();
			}
		}
	}

}
