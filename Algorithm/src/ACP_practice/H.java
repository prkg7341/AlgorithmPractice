package ACP_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class H {

	public H() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp = br.readLine();
		
		int n = Integer.parseInt(temp);
		
		int[] ar = new int[n];
		
		temp = br.readLine();
		
		for(int i=0 ; i<n; i++){
			ar[i] = Integer.parseInt(temp.split(" ")[i]);
		}
		
		Arrays.sort(ar);
		
		int front, back;
		
		front = ar[0]*ar[1];
		back = ar[ar.length-1]*ar[ar.length-2];
		
		int max = Math.max(front, back);
		
		if(max==front){
			max = Math.max(max, max*ar[2]);
		}
		
		else{
			max = Math.max(back, back*ar[ar.length-3]);
		}
		
		bw.write(max+"");
		bw.flush();
		bw.close();

	}

}
