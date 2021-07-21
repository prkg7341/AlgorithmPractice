package Map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class BJ_10816 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0 ; i<n ; i++) {
			int now = Integer.parseInt(input[i]);
			if(map.containsKey(now)){
				map.put(now, map.get(now)+1);
			}
			else{
				map.put(now, 1);
			}
		}

		int m = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");

		for(int i=0 ; i<m ; i++) {
			try{
				bw.write(Integer.toString(map.get(Integer.parseInt(input[i]))));
			}catch(Exception e){
				bw.write(Integer.toString(0));
			}
			bw.write(" ");
		}

		bw.flush();
	}
}
