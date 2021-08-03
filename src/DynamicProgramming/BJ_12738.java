package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_12738 {

	static ArrayList<Integer> list ;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();

		String[] input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++){
			int now = Integer.parseInt(input[i]);
			if(list.isEmpty()) list.add(now);
			else if(now>list.get(list.size()-1)){
				list.add(now);
			}
			else{
				int index = biSearch(now, 0, list.size());
				list.set(index, now);
			}
		}
		System.out.println(list.size());
	}

	private static int biSearch(int now, int start, int end) {

		int index = (start+end)/2;

		if (start > end) return start;

		if(list.get(index)==now){
			return index;
		}
		else if(list.get(index)>now){
			return biSearch(now,start, index-1);
		}
		else{
			return biSearch(now,index+1, end);
		}
	}
}
