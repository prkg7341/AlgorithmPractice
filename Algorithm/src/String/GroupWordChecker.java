package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class GroupWordChecker {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String st;
		String[] star;		
		
		int n = Integer.parseInt(br.readLine());		
		int count=0;
		
		
		for(int i=0 ; i<n ; i++){
			st = br.readLine();
			star = st.split("");
			int countA=0;
			int countB=0;
			
			for(int j=0 ; j<star.length-1 ; j++){
				for(int k=j+1 ; k<star.length ; k++){
					if(star[j].compareTo(star[k])==0 && (k-j)==1){countA++;
					}
				}				
			}
			
			Arrays.sort(star);
			
			for(int j=0 ; j<star.length-1 ; j++){
				for(int k=j+1 ; k<star.length ; k++){
					if(star[j].compareTo(star[k])==0 && (k-j)==1){countB++;
					}
				}				
			}
			
			if(countA==countB) count++;
		}
		bw.write(count+"");
		bw.flush();
		bw.close();
	}
}
