package DivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_14501 {

	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][2];

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			ar[i][0] = Integer.parseInt(input[0]);
			ar[i][1] = Integer.parseInt(input[1]);
		}

		rec(ar, 1, 0, 0);

		bw.write(String.valueOf(max));

		bw.flush();
	}

	private static void rec(int[][] ar, int day, int last, int sum) {

		if(last>ar.length) return;

		if(day==ar.length) {
			if(ar[day-1][0]==1 && last<day) sum += ar[day-1][1];
			max = Math.max(max, sum);
			return;
		}

		if(last<day){
			rec(ar, day+1, day+ar[day-1][0]-1, sum+ar[day-1][1]);
		}
		rec(ar, day+1, last, sum);
	}
}
