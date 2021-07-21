package Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tournament {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String temp = br.readLine();
		
		int n,k,i;
		
		n = Integer.parseInt(temp.split(" ")[0]);
		k = Integer.parseInt(temp.split(" ")[1]);
		i = Integer.parseInt(temp.split(" ")[2]);
		
		int round = 1;
		
		while(k!=i){
			if(k%2==1) k+=1;
			if(i%2==1) i+=1;
			k /= 2;
			i /= 2;
			round++;
		}
		
		round--;
		
		bw.write(round+"");
		bw.flush();
		bw.close();
		
	}

}
