package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_4889{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int index = 0;

		while(true) {
			char[] ar = br.readLine().toCharArray();

			if(ar[0]=='-') break;

			bw.write(Integer.toString(++index));
			bw.write(". ");

			int count = 0;
			int num = 0;

			for(int i=0 ; i<ar.length ; i++) {
				char now = ar[i];

				if(now=='{') {
					num++;
				}
				else {
					if(num==0) {
						count++;
						num++;
					}
					else num--;
				}
			}

			count += num/2;

			bw.write(Integer.toString(count));
			bw.write("\n");
		}

		bw.flush();
	}
}