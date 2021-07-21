package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepresentativeValue {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double ave = 0;
		int most = 0;
		int count = 0;
		int[] ar = new int[101];

		for(int i=0 ; i<10 ; i++){
			int now = Integer.parseInt(br.readLine());
			ave += now;
			ar[now/10]++;
		}
		ave /= 10;
		ave = Math.round(ave);
		for(int i=1 ; i<ar.length ; i++){
			int num = ar[i];
			if(num>count) {
				count = num;
				most = i*10;
			}
		}
		System.out.println((int)ave);
		System.out.print(most);
	}
}
