package Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OXQuiz {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] st = new String[n];
		
		for(int i=0 ; i<n ; i++){
			st[i] = br.readLine();
			String[] ar = new String[st[i].length()];
			int o=0;
			int op=o;
			for(int j=0 ; j<ar.length ; j++){
				ar[j] = ""+st[i].charAt(j);
				
				if(ar[j].compareTo("O")==0){
					o += ++op;
				}
				else {
					op=0;
				}
			}
			sb.append(""+o+"\n");
		}
		String last = sb.toString();
		sb.deleteCharAt(last.length()-1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
