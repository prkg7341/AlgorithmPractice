package Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Average {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] ar = new int[5];
		int sum = 0;
		
		for(int i=0 ; i<5 ; i++){
			ar[i] = Integer.parseInt(br.readLine());
			if(ar[i]<40) ar[i] = 40;
			sum += ar[i];
		}
		
		int average = sum/5;	
		bw.write(average+"");
		bw.flush();
		bw.close();
	}

}
