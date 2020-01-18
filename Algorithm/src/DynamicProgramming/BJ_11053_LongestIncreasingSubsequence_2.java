package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_11053_LongestIncreasingSubsequence_2 {

	static ArrayList<Integer> list ;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();

		list.add(0);

		String[] input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++){
			int now = Integer.parseInt(input[i]);
			if(now==list.get(list.size()-1)){
				continue;
			}
			else if(now>list.get(list.size()-1)){
				list.add(now);
			}
			else{
				int index = biSearch(now, 1, list.size());
				if(index==-1) {
					continue;
				}
				list.set(index+1, now);
			}
		}
		System.out.println(list.size()-1);
	}

	private static int biSearch(int now, int start, int end) {

		int index = (start+end)/2;

		if (start > end) return end;

		if(list.get(index)==now){
			return -1;
		}
		else if(list.get(index)>now){
			return biSearch(now,start, index-1);
		}
		else{
			return biSearch(now,index+1, end);
		}
	}
}
