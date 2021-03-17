package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_5026 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split("\\+");
			if(input.length==1) {
				bw.write("skipped");
			}
			else {
				bw.write(Integer.toString(Integer.parseInt(input[0])+Integer.parseInt(input[1])));
			}
			bw.write("\n");
		}

		bw.flush();
	}
}
