package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1725_Histogram {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}
		long result = rec(ar,0,ar.length-1);
		System.out.print(result);
	}

	static long rec(int[] ar, int left, int right){
		if(right==left){
			return ar[left];
		}
		else{
			int mid = (left+right)/2;
			return Math.max(Math.max(rec(ar,left,mid), rec(ar,mid+1,right)), getMid(ar,left,right));
		}
	}

	static long getMid(int[] ar, int left, int right) {
		int mid = (left+right)/2;
		int mid2 = mid+1;
		long length = mid2-mid+1;
		long min = Math.min(ar[mid],ar[mid2]);
		long max = min*length;

		while(true){
			if(mid==left && mid2==right) break;
			while(mid2!=right && ar[mid2+1]>=min){
				mid2++;
				length++;
			}
			while(mid!=left && ar[mid-1]>=min){
				mid--;
				length++;
			}
			max = Math.max(max, min*length);
			if(mid2!=right && mid!=left){
				if(ar[mid2+1]>=ar[mid-1]){
					mid2++;
					length++;
					min = ar[mid2];
				}
				else{
					mid--;
					length++;
					min = ar[mid];
				}
				max = Math.max(max, min*length);
			}
			else if(mid2==right && mid!=left){
				mid--;
				length++;
				min = ar[mid];
				max = Math.max(max, min*length);
			}
			else if(mid2!=right && mid==left){
				mid2++;
				length++;
				min = ar[mid2];
				max = Math.max(max, min*length);
			}
			else{
				break;
			}
		}
		return max;
	}
}