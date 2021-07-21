package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ_6603 {

	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true){
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);

			int[] ar = new int[n];

			for(int i=0 ; i<n ; i++){
				ar[i] = Integer.parseInt(input[i+1]);
			}

			btrk(ar, 0, 0, new ArrayList<Integer>());

			if(n==0) break;

			bw.write("\n");
		}

		bw.flush();
	}

	private static void btrk(int[] ar, int index, int count, ArrayList<Integer> list) {

		if(count==6) {
			try {
				for(int n : list) bw.write(n+" ");
				bw.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		if(index==ar.length) return;
		list.add(ar[index]);
		btrk(ar, index+1, count+1, list);
		list.remove(list.size()-1);
		btrk(ar, index+1, count, list);
	}
}
