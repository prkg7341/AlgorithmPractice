package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] ar = new int[n][2];
		int count = 0;

		for(int i=0 ; i<n ; i++){
			String input = br.readLine();
			int start = Integer.parseInt(input.split(" ")[0]);
			int end = Integer.parseInt(input.split(" ")[1]);
			ar[i][0] = start;
			ar[i][1] = end;
		}

		Arrays.sort(ar, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int startIndex = 0;

		/*while(true){
			int min = Integer.MAX_VALUE;
			int minP;
			for(int i=startIndex ; i<n ; i++){				
				if (ar[i][0] > ar[startIndex][1]) continue;				
				minP = min;
				min = Math.min(min, ar[i][1]);			
			}
			if(min != minP){
				startIndex = i;
			}
			if(마지막 회의시간보다 늦게 시작하는 회의가 없으면) break;
		}

		bw.write(count+"");
		bw.flush();
		bw.close();*/
	}
}
