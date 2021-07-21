package Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stick {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int stick = 64;
		int now = 0;
		int count = 0;
		
		while(now!=n){
			if((now+stick)<=n){
				now += stick;
				count++;
			}
			stick /= 2;
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
	}

}
