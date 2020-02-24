import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_4999 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String pat = br.readLine();
		String doc = br.readLine();
		
		if(pat.length()>=doc.length()) bw.write("go");
		else bw.write("no");
		
		bw.flush();
	}
}
