package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandPrompt {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] ar = br.readLine().toCharArray();

		for(int i=1 ; i<n ; i++){
			char[] temp = br.readLine().toCharArray();
			for(int j=0 ; j<ar.length ; j++){
				if(ar[j]!='?' && ar[j]!=temp[j]) ar[j] = '?';
			}
		}
		for(char c : ar) System.out.print(c);
	}
}