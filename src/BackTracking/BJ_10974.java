package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ_10974 {

	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>(n);
		ArrayList<Integer> ans = new ArrayList<>(n);

		for(int i=1 ; i<=n ; i++) {
			list.add(i);
		}

		btrk(list, ans);

		bw.flush();
	}

	private static void btrk(ArrayList<Integer> list, ArrayList<Integer> ans) throws IOException {

		if(list.isEmpty()){
			for(int i : ans) {
				bw.write(i+" ");
			}
			bw.write("\n");
			return;
		}

		for(int i=0 ; i<list.size() ; i++){
			ans.add(list.remove(i));
			btrk(list, ans);
			list.add(i, ans.remove(ans.size()-1));
		}
	}
}
