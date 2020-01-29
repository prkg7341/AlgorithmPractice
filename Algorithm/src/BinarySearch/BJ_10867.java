package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ_10867 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0 ; i<n ; i++){
			int now = Integer.parseInt(input[i]);
			if(list.isEmpty()) list.add(now);
			else {
				int index = bs(list, now, 0, list.size()-1);
				if(index==-1) continue;
				else list.add(index, now);
			}
		}

		for(int i : list) bw.write(String.valueOf(i)+" ");

		bw.flush();
	}

	private static int bs(ArrayList<Integer> list, int value, int left, int right) {

		int mid = (right+left)/2;

		if(left>right) return left;

		if(list.get(mid)>value){
			return bs(list, value, left, mid-1);
		}
		else if(list.get(mid)<value){
			return bs(list, value, mid+1, right);
		}
		else{
			return -1;
		}
	}
}
