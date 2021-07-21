package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MetalRod {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		int num=0;
		int count=0;
		int result=0;

		for(int i=0 ; i<input.length ; i++){
			switch(input[i]){
			case '(':
				if(input[i+1]==')'){
					result += count;
					i++;
				}
				else{
					num++;
					count++;
				}
				break;
			case ')':
				count--;
			}
		}
		System.out.print(result+num);
	}
}
