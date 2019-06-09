package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class d565_LE {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] notSosu = new boolean[2750131+1];
		ArrayList<Integer> sosu = new ArrayList<>();

		for(int i=2 ; i<=2750131 ; i++){
			if(!notSosu[i]){
				sosu.add(i);
				for(int j=2*i ; j<=2750131 ; j+=i){
					notSosu[j] = true;
				}
			}
		}

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		ArrayList<Integer> get = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> toDel = new ArrayList<>();

		for(int i=0 ; i<n*2 ; i++){
			int now = Integer.parseInt(input[i]);
			if(notSosu[now]){
				result.add(now);
				int temp=2;
				while(true){
					if(now%temp==0){
						break;
					}
					temp++;
				}
				int index = Collections.binarySearch(get, now/temp);
				if(index==-1){
					toDel.add(now/temp);
				}
				else{
					get.remove(index);
				}
			}
			else{
				if(get.size()==0){
					get.add(now);
				}
				else{
					get.add(biSearch(get, now, 0, get.size()-1), now);
				}
			}
		}
		for(int i=0 ; i<toDel.size() ; i++){
			int now = toDel.get(i);
			get.remove(Collections.binarySearch(get, now));
		}
		while(!get.isEmpty()){
			int now = get.remove(get.size()-1);
			int index = Collections.binarySearch(sosu, now)+1;
			int temp = Collections.binarySearch(get, index);
			if(temp>-1){
				get.remove(temp);
				result.add(index);
			}
		}	
		for(int i : result){
			sb.append(i+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}

	static int biSearch(ArrayList<Integer> list, int value, int start, int last){

		if(start>last){
			return start;
		}

		int mid = (start+last)/2;

		if(list.get(mid)==value){
			return mid;
		}
		else if(list.get(mid)>value){
			return biSearch(list, value, start, mid-1);
		}
		else{
			return biSearch(list, value, mid+1, last);
		}
	}
}
