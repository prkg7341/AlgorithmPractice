package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ_11054_LongestBitonicSubsequence {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int len = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] ar = new int[len];

		for(int i=0 ; i<len ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}

		int[] result = new int[len];

		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);

		for(int i=0 ; i<len ; i++){
			int now = ar[i];
			if(list.isEmpty()) {
				list.add(now);
			}
			else{
				int stan = list.get(list.size()-1);
				if(now>stan){
					list.add(now);
				}
				if(now<stan){
					int index = biSearch(list, now, 1, list.size());
					if(index==-1) {
						continue;
					}
					list.set(index+1, now);
				}
			}
			result[i] = list.size()-1;
		}

		list.clear();
		list.add(0);

		for(int i=len-1 ; i>=0 ; i--){
			int now = ar[i];
			if(list.isEmpty()) list.add(now);
			else{
				int stan = list.get(list.size()-1);
				if(now>stan){
					list.add(now);
				}
				if(now<stan){
					int index = biSearch(list, now, 1, list.size());
					if(index==-1) {
						continue;
					}
					list.set(index+1, now);
				}
			}
			result[i] += list.size()-2;
		}

		int max = 0;

		for(int i=0 ; i<len ; i++){
			max = Math.max(max, result[i]);
		}

		bw.write(String.valueOf(max));

		bw.flush();
	}

	private static int biSearch(ArrayList<Integer> list, int now, int start, int end) {

		int index = (start+end)/2;

		if (start > end) return end;

		if(list.get(index)==now){
			return -1;
		}
		else if(list.get(index)>now){
			return biSearch(list, now,start, index-1);
		}
		else{
			return biSearch(list, now,index+1, end);
		}
	}
}
