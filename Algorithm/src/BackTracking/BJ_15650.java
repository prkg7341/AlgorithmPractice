package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ_15650 {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]); // ¹üÀ§
		int m = Integer.parseInt(input[1]); // °¹¼ö
		
		ArrayList<Integer> list = new ArrayList<>(n);
		
		for(int i=1 ; i<=n ; i++) {
			list.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		btrk(list, m, 0, 0, sb);
		
		bw.flush();
	}

	private static void btrk(ArrayList<Integer> list, int m, int num, int index, StringBuilder sb) {

		if(num==m) {
			try {
				bw.write(sb.toString());
				bw.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		for(int i=index ; i<list.size() ; i++) {
			int now = list.get(i);
			sb.append(now).append(" ");
			if(list.size()-i>=m-num)
				btrk(list, m, num+1, i+1, sb);
			sb.delete(sb.length()-2, sb.length());
		}
	}
}
