package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WaterRate {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		int y_fix = Integer.parseInt(br.readLine());
		int y_max = Integer.parseInt(br.readLine());
		int y_add = Integer.parseInt(br.readLine());
		
		int use = Integer.parseInt(br.readLine());
		
		int x_fee = use*x;
		int y_fee = use<=y_max? y_fix : y_fix+(use-y_max)*y_add;
		
		bw.write(String.valueOf(Math.min(x_fee, y_fee)));
		bw.flush();
		bw.close();	
	}
}
