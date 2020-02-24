package Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_1021 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n,m;
		
		String temp = br.readLine();

		n = Integer.parseInt(temp.split(" ")[0]);
		m = Integer.parseInt(temp.split(" ")[1]);
		
		temp = br.readLine();
		
		int[] ar = new int [m];
		int count = 0;
		int now = 0;
		
		for(int i=0 ; i<m ; i++){
			ar[i] = Integer.parseInt(temp.split(" ")[i])-1;
		}
		
		for(int i=0 ; i<m ; i++){
			int sub = ar[i]-now;
			if(sub<0) sub = -sub;
			sub = Math.min(sub, n-sub);
			count += sub;
			now = ar[i];
			n--;
			for(int j=i+1 ; j<m ; j++){
				if(ar[j]>now) ar[j]--;
			}
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
		
	}

}
