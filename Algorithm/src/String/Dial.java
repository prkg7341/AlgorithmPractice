package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Dial {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String st = br.readLine();
		String[] star = st.split("");
		int sum=0;
		for(int i=0 ; i<star.length ; i++){
			switch(star[i]){
			case"A": 
			case"B":
			case"C":sum+=3; break;
			case"D":
			case"E":
			case"F":sum+=4; break;
			case"G":
			case"H":
			case"I":sum+=5; break;
			case"J":
			case"K":
			case"L":sum+=6; break;
			case"M":
			case"N":
			case"O":sum+=7; break;
			case"P":
			case"Q":
			case"R":
			case"S":sum+=8; break;
			case"T":
			case"U":
			case"V":sum+=9; break;
			case"W":
			case"X":
			case"Y":
			case"Z":sum+=10; break;
			case"+":
			case"-":
			case"*":
			case"/":sum+=11; break;
					
			}
		}
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
	}

}
