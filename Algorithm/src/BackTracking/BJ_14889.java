package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_14889 {

	static int temp = 0;
	static boolean[] yes;
	static int min = 123456789;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][n];
		yes = new boolean[n];
		yes[0] = true;

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++){
				ar[i][j] = Integer.parseInt(input[j]);
			}
		}

		btrk(ar, 1, 1);

		bw.write(String.valueOf(min));

		bw.flush();
	}

	private static void btrk(int[][] ar, int index, int count) {

		if(count==ar.length/2){
			min = Math.min(min, cal(ar, yes));
			return;
		}

		// 앞으로 다뽑아도 n/2 보다 작으면 break;
		if(count+(ar.length-index)<ar.length/2) return;

		yes[index] = true;
		btrk(ar, index+1, count+1);
		yes[index] = false;
		btrk(ar, index+1, count);
	}

	private static int cal(int[][] ar, boolean[] yes) {
		int YES = 0;
		int NO = 0;
		for(int i=0 ; i<ar.length ; i++){
			for(int j=0 ; j<ar.length ; j++){
				if(i!=j){
					if(yes[i] && yes[j]) YES += ar[i][j];
					else if(!yes[i] && !yes[j]) NO += ar[i][j];
				}
			}
		}
		return Math.abs(YES-NO);
	}
}
