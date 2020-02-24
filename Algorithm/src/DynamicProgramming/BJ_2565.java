package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_2565 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][2];

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			ar[i][0] = a;
			ar[i][1] = b;
		}

		Arrays.sort(ar, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});

		// [1]에 대해서 lis
		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0 ; i<n ; i++){
			int now = ar[i][1];
			if(list.isEmpty()) list.add(now);
			else if(list.get(list.size()-1)<now) list.add(now);
			else if(list.get(list.size()-1)==now) continue;
			else {
				int index = bs(list, now, 0, list.size());
				if(index!=-1) list.set(index, now);
			}
//			System.out.println(String.valueOf(list));
		}

		bw.write(String.valueOf(n-list.size()));

		bw.flush();
	}

	private static int bs(ArrayList<Integer> list, int value, int left, int right) {
		if(right<left) return left;
		int mid = (left+right)/2;
		if(list.get(mid)>value){
			return bs(list, value, left, mid-1);
		}
		else if(list.get(mid)<value){
			return bs(list, value, mid+1, right);
		}
		else return -1;
	}
}
