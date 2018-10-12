package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SangSu {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a,b;
		String st = br.readLine();
		a = Integer.parseInt(st.split(" ")[0]);
		b = Integer.parseInt(st.split(" ")[1]);
		a = (a%10)*100 + (a%100-a%10)*10 + a/100;
		b = (b%10)*100 + (b%100-b%10)*10 + b/100;
		bw.write(Math.max(a, b));
		bw.flush();
		bw.close();
	}

}
