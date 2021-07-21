package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Receipt {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int price = Integer.parseInt(br.readLine());
		for(int i=0 ; i<9 ; i++){
			price -= Integer.parseInt(br.readLine());
		}
		bw.write(String.valueOf(price));
		bw.flush();
		bw.close();	
	}
}
