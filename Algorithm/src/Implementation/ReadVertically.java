package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadVertically {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] ar = new String[5];

		int max = 0;

		for(int i=0 ; i<ar.length ; i++){
			ar[i] = br.readLine();
			max = Math.max(max, ar[i].length());
		}

		for(int i=0 ; i<max ; i++){
			for(int j=0 ; j<ar.length ; j++){
				if(ar[j].length()>i){
					sb.append(ar[j].charAt(i));
				}
			}
		}
		System.out.print(sb.toString());
	}
}
