package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasketBallMatch {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] al = new char[26];

		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++){
			String now = br.readLine();
			al[now.charAt(0)-97]++;
		}
		int count=0;
		for(int i=0 ; i<al.length ; i++){
			if(al[i]>=5){
				count++;
				System.out.print((char)(i+97));
			}
		}
		if(count==0){
			System.out.print("PREDAJA");
		}
	}
}
