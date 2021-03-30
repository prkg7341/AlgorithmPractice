package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class BJ_6500 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			int n = Integer.parseInt(br.readLine());

			if(n==0) break;

			HashSet<Integer> set = new HashSet<>();
			set.add(n);

			while(true) {
				n *=  n;
				n /= 100;
				n %= 10000;
				if(!set.contains(n)) set.add(n);
				else break;
			}

			bw.write(Integer.toString(set.size()));
			bw.write("\n");
		}

		bw.flush();
	}
}
