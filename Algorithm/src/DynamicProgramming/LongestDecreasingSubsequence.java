package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LongestDecreasingSubsequence {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0 ; i<n ; i++){
			int now = Integer.parseInt(input[i]);

			if(i==0){
				list.add(now);
				continue;
			}			
			if(now<list.get(list.size()-1)){
				list.add(now);
			}
			else{
				list.set(biSearch(list, now, 0, list.size()-1), now); 
			}
		}
		System.out.println(list.size());
	}

	private static int biSearch(ArrayList<Integer> list, int now, int start, int end) {

		if(start>end){
			return start;
		}

		int mid = (start+end)/2;

		if(list.get(mid)==now){
			return mid;
		}
		else if(list.get(mid)>now){
			return biSearch(list, now, mid+1, end);
		}
		else{
			return biSearch(list,now,start,mid-1);
		}
	}
}
