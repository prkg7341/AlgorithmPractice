package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TenthDay {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int count=0;
		
		for(int i=0 ; i<5 ; i++){
			if(Integer.parseInt(input[i])==n){
				count++;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();	
	}
}
