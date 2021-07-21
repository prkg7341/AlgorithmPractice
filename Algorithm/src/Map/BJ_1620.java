package Map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class BJ_1620 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		String[] name = new String[n];

		HashMap<String, Integer> map = new HashMap<>();

		for(int i=0 ; i<n ; i++) {
			String now = br.readLine();
			map.put(now, i+1);
			name[i] = now;
		}

		for(int i=0 ; i<m ; i++) {
			String temp = br.readLine();
			try{
				int num = Integer.parseInt(temp);
				bw.write(name[num-1]+"\n");
			}catch(Exception e){
				bw.write(map.get(temp)+"\n");
			}
		}

		bw.flush();
	}
}
