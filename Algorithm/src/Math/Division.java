package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Division {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());

		n = n/100*100;

		if(n%f==0){
			System.out.println("00");
		}
		else{
			int result = f-n%f;
			if(result<10){
				System.out.println("0"+result);
			}
			else{
				System.out.println(result);
			}
		}
	}
}
