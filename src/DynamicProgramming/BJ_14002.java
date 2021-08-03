package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_14002{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int[] ar = new int[n];
		ArrayList<Pair> list = new ArrayList<>();
		int[] index = new int[n];

		for(int i=0 ; i<n ; i++) {
			ar[i] = Integer.parseInt(input[i]);
		}

		int maxI = 0;

		for(int i=0 ; i<n ; i++) {
			int now = ar[i];
			if(list.isEmpty()) {
				list.add(new Pair(i, now));
				index[i] = -1;
			}
			else {
				if(now>list.get(list.size()-1).value) {
					list.add(new Pair(i, now));
					index[i] = list.get(list.size()-2).index;
					maxI = i;
				}
				else {
					int temp = biSearch(list, now, 0, list.size()-1);
					list.set(temp, new Pair(i, now));
					index[i] = temp==0? -1 : list.get(temp-1).index;
				}
			}
		}	

		StringBuilder sb = new StringBuilder();

		int count = 0;
		while(maxI!=-1) {
			count++;
			sb.insert(0, " ").insert(0,ar[maxI]);
			maxI = index[maxI];
		}	
		System.out.println(count);
		System.out.println(sb.toString());
	}

	private static int biSearch(ArrayList<Pair> list, int value, int left, int right) {

		if(left>right) {
			return left;
		}

		int mid = (left+right)/2;

		int now = list.get(mid).value;

		if(now==value) return mid;

		else if(now>value) {
			return biSearch(list, value, left, mid-1);
		}
		else {
			return biSearch(list, value, mid+1, right);
		}
	}

	static class Pair{
		int index, value;

		public Pair(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}		
	}
}