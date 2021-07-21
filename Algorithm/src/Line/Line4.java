package Line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Line4 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}

		System.out.print(dnq(ar,0,n-1).maxLength);
	}

	private static Pair dnq(int[] ar, int left, int right) {

		if(right==left){
			LinkedList<Integer> list = new LinkedList<>();
			list.add(right);
			return new Pair(0,list);
		}

		else if(right-left==1){
			LinkedList<Integer> list = new LinkedList<>();
			if(ar[right] == ar[left]){				
				list.add(right);
				list.add(left);
			}
			else{
				list.add(ar[right]>ar[left]? right : left);
			}
			return new Pair(1,list);
		}

		else{
			int mid = (left+right)/2;
			Pair p1 = dnq(ar,left,mid);
			Pair p2 = dnq(ar,mid+1,right);
			LinkedList<Integer> list = new LinkedList<>();
			if(ar[p1.maxHeightI.getFirst()] > ar[p2.maxHeightI.getFirst()]){
				list = p1.maxHeightI;
			}
			else if(ar[p1.maxHeightI.getFirst()] < ar[p2.maxHeightI.getFirst()]){
				list = p2.maxHeightI;
			}
			else{
				list.addAll(p1.maxHeightI);
				list.addAll(p2.maxHeightI);
			}

			int maxL = Math.max(p1.maxLength, p2.maxLength);

			if(ar[p1.maxHeightI.getLast()]>ar[p2.maxHeightI.getFirst()]){
				for(int i=mid ; i>=left ; i--){
					maxL = Math.max(maxL, p2.maxHeightI.getFirst()-i);
					if(ar[i]>=ar[p2.maxHeightI.getFirst()]) break;
				}
			}
			else if(ar[p1.maxHeightI.getLast()]<ar[p2.maxHeightI.getFirst()]){
				for(int i=mid+1 ; i<=right ; i++){					
					maxL = Math.max(maxL, i-p1.maxHeightI.getLast());
					if(ar[i]>=ar[p1.maxHeightI.getLast()]) break;
				}
			}
			else{
				maxL = Math.max(maxL, p2.maxHeightI.getFirst()-p1.maxHeightI.getLast());
			}

			return new Pair(maxL, list);
		}
	}

	static class Pair{
		int maxLength;
		LinkedList<Integer> maxHeightI;
		Pair(int maxLength, LinkedList<Integer> maxHeightList){
			this.maxLength = maxLength;
			this.maxHeightI = maxHeightList;
		}
	}
}
