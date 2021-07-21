package Implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class Taxi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		DecimalFormat df6 = new DecimalFormat("#######.000000");
		  
		String a = df6.format(Math.PI*Math.pow(n, 2));
		String b = df6.format(2*n);
		
		sb.append(a+"\n"+b);
		bw.write(sb.toString());
		bw.flush();
		bw.close();		
	}

}
