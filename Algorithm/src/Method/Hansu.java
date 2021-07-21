package Method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Hansu {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int count=0;
		
		for(int i=1 ; i<=n ; i++){
			if(i==1000) break;
			else if(i>=100){
				if((i/100-(i/10)%10)==((i/10)%10)-i%10){
					count++;
				}
			}
			else if(i>=10) {
				count++;
			}
			else count++;			
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();	

	}

}
