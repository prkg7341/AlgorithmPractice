package FindRule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RoomNumber {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String st = br.readLine();
		int[] ar = new int[st.length()];
		for(int i=0 ; i<ar.length ; i++){
			ar[i] = Integer.parseInt(st.split("")[i]);
		}
		int max;
		int c0=0;
		int c1=0;
		int c2=0;
		int c3=0;
		int c4=0;
		int c5=0;
		int c6=0;
		int c7=0;
		int c8=0;
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
			case 9: c6++; break;
			}
		}
		if(c6%2==0){
			c6/=2;			
		}
		else{
			c6 = c6/2+1;
		}		
		max = Integer.max(Integer.max(Integer.max(Integer.max(c1,c2),Integer.max(c3,c4)), 
							Integer.max(Integer.max(c5,c6),Integer.max(c7,c8))),c0);		
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
}
