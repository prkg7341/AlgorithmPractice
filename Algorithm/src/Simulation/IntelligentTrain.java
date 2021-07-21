package Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IntelligentTrain {
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp;
		int count = 0;
		int max=-1;
		
		for(int i=0 ; i<4 ; i++){
			temp = br.readLine();
			count += Integer.parseInt(temp.split(" ")[1]) - Integer.parseInt(temp.split(" ")[0]); 
			max = Math.max(max, count);
		}
		
		bw.write(max+"");
		bw.flush();
		bw.close();
		
	}
}
