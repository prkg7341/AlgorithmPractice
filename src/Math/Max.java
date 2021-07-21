package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Max {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max=0;
		int index=-1;

		for(int i=1 ; i<=9 ; i++){
			int input = Integer.parseInt(br.readLine());

			if(input>max){
				max = input;
				index = i;
			}
		}
		System.out.println(max);
		System.out.print(index);
	}
}