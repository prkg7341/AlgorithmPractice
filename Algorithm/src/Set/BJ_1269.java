package Set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class BJ_1269 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		HashSet<Integer> set = new HashSet<>();

		input = br.readLine().split(" ");
		for(int i=0 ; i<a ; i++) {
			int temp = Integer.parseInt(input[i]);
			set.add(temp);
		}

		input = br.readLine().split(" ");
		for(int i=0 ; i<b ; i++) {
			int temp = Integer.parseInt(input[i]);
			if(!set.add(temp)) set.remove(temp);
		}

		bw.write(String.valueOf(set.size()));

		bw.flush();
	}
}
