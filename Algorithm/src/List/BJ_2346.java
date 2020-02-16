package List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2346 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		ArrayList<Pair> list = new ArrayList<>();

		for(int i=0 ; i<n ; i++){
			list.add(new Pair(i, Integer.parseInt(input[i])));
		}

		int index = 0;

		while(!list.isEmpty()){
			Pair now = list.get(index);
			sb.append(now.index+1).append(" ");
			int nextI = index+now.value;
			list.remove(index);
			if(index<nextI) nextI--;
			index = nextI;
			if(!list.isEmpty()){
				while(index<0) index += list.size();
				index %= list.size();
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
	static class Pair{
		int index;
		int value;
		Pair(int index, int value){
			this.index = index;
			this.value = value;
		}
	}
}