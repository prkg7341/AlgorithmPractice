package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SortingCoordinates {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		ArrayList<Pair> list = new ArrayList<>();

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");

			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);

			if(list.size()==0){
				list.add(new Pair(x,y));
			}
			else if(x>list.get(list.size()-1).x || (x==list.get(list.size()-1).x && y>list.get(list.size()-1).y)){
				list.add(new Pair(x,y));
			}
			else{
				list.add(biSearch(list, 0, list.size()-1, new Pair(x,y)), new Pair(x,y));
			}
		}
		for(Pair pair : list){
			sb.append(pair.x+" "+pair.y+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	static int biSearch(ArrayList<Pair> list, int start, int end, Pair pair) {
		if(start>end) return start;

		int mid = (start+end)/2;

		if(list.get(mid).x>pair.x || (list.get(mid).x==pair.x && list.get(mid).y>pair.y)){
			return biSearch(list, start, mid-1, pair);
		}

		if(list.get(mid).x<pair.x || (list.get(mid).x==pair.x && list.get(mid).y<pair.y)){
			return biSearch(list, mid+1, end, pair);
		}

		return -1;
	}

	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}	
}
