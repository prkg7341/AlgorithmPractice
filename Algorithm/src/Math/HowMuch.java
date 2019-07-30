package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HowMuch {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++){
			int price = Integer.parseInt(br.readLine());
			int option = Integer.parseInt(br.readLine());
			for(int j=0 ; j<option ; j++){
				String[] input = br.readLine().split(" ");
				price += Integer.parseInt(input[0])*Integer.parseInt(input[1]);
			}
			bw.write(price+"\n");
		}
		bw.flush();
	}
}

