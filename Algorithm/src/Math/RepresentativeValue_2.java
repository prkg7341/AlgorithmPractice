package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RepresentativeValue_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double ave = 0;
		int count = 0;
		int[] ar = new int[11];

		int[] temp = new int[5];

		for(int i=0 ; i<5 ; i++){
			int now = Integer.parseInt(br.readLine());
			ave += now;
			ar[now/10]++;
			temp[i] = now;
		}
		ave /= 5;
		ave = Math.round(ave);
		for(int i=1 ; i<ar.length ; i++){
			int num = ar[i];
			if(num>count) {
				count = num;
			}
		}
		Arrays.sort(temp);
		System.out.println((int)ave);
		System.out.print(temp[2]);
	}
}
