package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_14888 {

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int[] ar = new int[num];

		for(int i=0 ; i<num ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}

		int[] ars = new int[4];

		input = br.readLine().split(" ");
		for(int i=0 ; i<4 ; i++){
			ars[i] = Integer.parseInt(input[i]);
		}

		for(int i=0 ; i<4 ; i++) {
			ars[i]--;
			btrk(ar, ars, 1, i, ar[0]);
			ars[i]++;
		}

		bw.write(String.valueOf(max));
		bw.write("\n");
		bw.write(String.valueOf(min));

		bw.flush();
	}

	private static void btrk(int[] ar, int[] ars, int index, int sindex, int sum) {

		for(int i=0 ; i<4 ; i++) {
			if(ars[i]<0) return;
		}

		if(sindex==0) {
			sum += ar[index];
		}
		else if(sindex==1) {
			sum -= ar[index];
		}
		else if(sindex==2) {
			sum *= ar[index];
		}
		else {
			sum /= ar[index];
		}

		index++;

		if(index==ar.length) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);			
			return;
		}

		for(int i=0 ; i<4 ; i++) {
			ars[i]--;
			btrk(ar, ars, index, i, sum);
			ars[i]++;
		}
	}
}
