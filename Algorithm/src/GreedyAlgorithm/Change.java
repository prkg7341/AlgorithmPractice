package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Change {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int change = 1000-Integer.parseInt(br.readLine());
		int count=0;

		while(change>0){
			while(change>=500){
				change -= 500;
				count++;
			}
			while(change>=100){
				change -= 100;
				count++;
			}
			while(change>=50){
				change -= 50;
				count++;
			}
			while(change>=10){
				change -= 10;
				count++;
			}
			while(change>=5){
				change -= 5;
				count++;
			}
			count += change;
			change=0;
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();	
	}
}
