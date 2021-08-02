
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1289{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			bw.write("#");
			bw.write(Integer.toString(tt));
			bw.write(" ");

			char[] ar = br.readLine().toCharArray();

			char now = '0';

			int count = 0;

			for(int i=0 ; i<ar.length ; i++) {
				if(ar[i]!=now) {
					now = ar[i];
					count++;
				}
			}

			bw.write(Integer.toString(count));
			bw.write("\n");
		}

		bw.flush();
	}
}