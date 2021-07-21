package carnival;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class C1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		int[][] ar = new int[n][2];

		input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++) {
			ar[i][0] = i+1;
			ar[i][1] = Integer.parseInt(input[i]);
		}

		Arrays.sort(ar, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					if(o1[0]>=k) {
						if(o2[0]>=k) {
							return o1[0] - o2[0];
						}
						else {
							return -1;
						}
					}
					else {
						if(o2[0]>=k) {
							return 1;
						}
						else {
							return o1[0] - o2[0];
						}
					}
				}
				else return o1[1] - o2[1];
			}	
		});

		for(int i=0 ; i<n ; i++) {
			bw.write(String.valueOf(ar[i][0]));
			bw.write(" ");
		}
		bw.flush();
	}
}