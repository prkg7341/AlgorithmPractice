package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostParentheses {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = br.readLine();

		String[] input = st.split("-");

		int result = 0;

		if(input[0].contains("+")){
			String[] one = input[0].split("\\+");

			for(int i=0 ; i<one.length ; i++){
				result += Integer.parseInt(one[i]);
			}
		}
		else{
			result += Integer.parseInt(input[0]);
		}

		int index = st.indexOf("-");

		if(index!=-1){
			for(int i=index+1 ; i<st.length() ; i++){
				int count=0;
				while(i<st.length() && st.charAt(i)!='-' && st.charAt(i)!='+'){
					i++;
					count++;
				}
				result-=Integer.parseInt(st.substring(i-count, i));
			}
		}
		System.out.print(result);
	}
}