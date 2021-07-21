package UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class BJ_4195 {

	static HashMap<String, String> map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++){
			int n = Integer.parseInt(br.readLine());

			map = new HashMap<>();	

			for(int i=0 ; i<n ; i++){
				String[] input = br.readLine().split(" ");

				String a = input[0];
				String b = input[1];

				union(a, b);

				bw.write(map.get(find(a)));
				bw.write("\n");
			}
		}

		bw.flush();
	}

	private static String find(String a) {
		try{
			Integer.parseInt(map.get(a));
			return a;
		}catch(Exception e){
			map.replace(a, find(map.get(a)));
			return map.get(a);
		}
	}

	private static void union(String a, String b) {
		if(!map.containsKey(a)) map.put(a, String.valueOf(1));
		if(!map.containsKey(b)) map.put(b, String.valueOf(1));
		a = find(a);
		b = find(b);
		if(a.equals(b)) return;
		if(Integer.parseInt(map.get(a))>Integer.parseInt(map.get(b))){
			map.replace(a, String.valueOf(Integer.parseInt(map.get(a)) + Integer.parseInt(map.get(b))));
			map.replace(b, a);
		}
		else{
			map.replace(b, String.valueOf(Integer.parseInt(map.get(b)) + Integer.parseInt(map.get(a))));
			map.replace(a, b);
		}
	}
}
