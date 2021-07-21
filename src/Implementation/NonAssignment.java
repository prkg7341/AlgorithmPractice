package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NonAssignment {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int[] ar = new int[30];
		
		for(int i=0 ; i<30 ; i++){
			ar[i] = i+1;
		}
		
		for(int i=0 ; i<28 ; i++){
			ar[Integer.parseInt(br.readLine())-1] = 0;
		}
		
		for(int i=0 ; i<30 ; i++){
			if(ar[i]!=0){
				sb.append(ar[i]+"\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();	
	}
}
