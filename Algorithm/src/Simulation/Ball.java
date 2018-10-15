package Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ball {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int position = 1; // one of 1,2,3
		
		for(int i=0 ; i<n ; i++){
			String input = br.readLine();
			int a = Integer.parseInt(input.split(" ")[0]);
			int b = Integer.parseInt(input.split(" ")[1]);
			
			if(a!=b){
				if(a==position || b==position){
					if((a==position)) position = b;
					else position = a;
				}
			}
		}
		
		bw.write(position+"");
		bw.flush();
		bw.close();

	}

}
