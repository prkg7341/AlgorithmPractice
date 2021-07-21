package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int small = Integer.parseInt(br.readLine());
		int big= Integer.parseInt(br.readLine());

		boolean[] notSosu = new boolean[big+1];

		notSosu[1] = true;

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for(int i=2 ; i<=big ; i++){
			if(!notSosu[i]){
				for(int j=2*i ; j<=big ; j+=i){
					notSosu[j] = true;
				}
				if(i>=small) {
					sum += i;
					min = Math.min(min, i);
				}
			}
		}
		if(sum==0){
			System.out.print(-1);
		}
		else{
			System.out.println(sum);
			System.out.print(min);
		}
	}
}
