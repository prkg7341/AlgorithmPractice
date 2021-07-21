package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Resistance {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long result=0;	
		
		String[] ar = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
		
		for(int i=1 ; i<=3 ; i++){
			String input = br.readLine();
			int index = -1;
			if(i==1){
				for(int j=0 ; j<ar.length ; j++){
					if(input.compareTo(ar[j])==0){
						index = j;
						break;
					}
				}
				result += index*10;
			}
			else if(i==2){
				for(int j=0 ; j<ar.length ; j++){
					if(input.compareTo(ar[j])==0){
						index = j;
						break;
					}
				}
				result += index;
			}
			else{
				for(int j=0 ; j<ar.length ; j++){
					if(input.compareTo(ar[j])==0){
						index = j;
						break;
					}
				}
				while(index>0){
					result *= 10;
					index--;
				}
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

		
	
}
