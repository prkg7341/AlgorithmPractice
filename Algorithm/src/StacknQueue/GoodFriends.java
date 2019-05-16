package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GoodFriends {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long result = 0;

		String[] input = br.readLine().split(" ");

		int stu = Integer.parseInt(input[0]);
		int limit = Integer.parseInt(input[1]);

		ArrayList<ArrayList<Integer>> list = new ArrayList<>(20);

		for(int i=0 ; i<=20 ; i++) {
			list.add(new ArrayList<Integer>());
		}

		for(int i=0 ; i<stu ; i++){
			String now = br.readLine();
			ArrayList<Integer> llist = list.get(now.length());

			while(llist.size()!=0 && i-llist.get(0)>limit){
				llist.remove(0);
			}

			result += llist.size();
			llist.add(i);
		}
		System.out.print(result);
	}
}
