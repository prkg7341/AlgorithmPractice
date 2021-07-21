package Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumOfNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a,b,c,result;
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		result = a*b*c;
		String st = ""+result;
		int[] ar = new int[st.length()];
		for(int i=0 ; i<ar.length ; i++){
			ar[i] = Integer.parseInt(""+st.charAt(i));
		}

		int c0=0;
		int c1=0;
		int c2=0;
		int c3=0;
		int c4=0;
		int c5=0;
		int c6=0;
		int c7=0;
		int c8=0;
		int c9=0;

		for(int i=0 ; i<ar.length ; i++){
			switch(ar[i]){
			case 0: c0++; break;
			case 1: c1++; break;
			case 2: c2++; break;
			case 3: c3++; break;
			case 4: c4++; break;
			case 5: c5++; break;
			case 6: c6++; break;
			case 7: c7++; break;
			case 8: c8++; break;
			case 9: c9++; break;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		bw.write(sb.append(c0).append("\n").append(c1).append("\n").append(c2).append("\n").
					append(c3).append("\n").append(c4).append("\n").append(c5).append("\n").
					append(c6).append("\n").append(c7).append("\n").append(c8).append("\n").append(c9).toString());
		bw.flush();
		bw.close();
	}

}
