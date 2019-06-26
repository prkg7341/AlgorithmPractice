package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class f570 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++){
			int n = Integer.parseInt(br.readLine());

			String[] input = br.readLine().split(" ");

			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			for(int i=0 ; i<n ; i++){
				pq.add(Integer.parseInt(input[i]));
			}

			ArrayList<Integer> list = new ArrayList<>();
			while(!pq.isEmpty()){
				int now = pq.poll();
				if(list.size()==0 || list.get(list.size()-1)!=now){
					list.add(now);
				}
			}

			int max = list.get(0);
			int one=0, two=0, three=0;
			for(int i=0 ; i<list.size() ; i++){
				one = list.get(i);
				for(int j=i+1 ; j<list.size() ; j++){
					int temp = list.get(j);
					if(one%temp!=0){
						two = temp;
						if(j==list.size()-1 || one+two+list.get(j+1)<=max){
							max = Math.max(one+two, max);
							break;
						}
						for(int k=j+1 ; k<list.size() ; k++){
							temp = list.get(k);
							if(one%temp!=0 && two%temp!=0){
								three = temp;
								break;
							}
						}
						max = Math.max(one+two+three, max);
						three = 0;
					}
				}
			}
			sb.append(max).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
