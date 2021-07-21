package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Histogram2 {

	static long max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		while(true){

			max = 0;

			String[] input = br.readLine().split(" ");

			int n = Integer.parseInt(input[0]);

			if(n==0){
				sb.deleteCharAt(sb.length()-1);
				System.out.print(sb.toString());
				return;
			}

			long[] ar = new long[n];

			for(int i=0 ; i<n ; i++){
				ar[i] = Long.parseLong(input[i+1]);
			}

			max = rec(ar,0,ar.length-1);

			sb.append(max).append("\n");
		}
	}

	static long rec(long[] ar, int left, int right){
		if(right==left){
			return ar[left];
		}
		else{
			int mid = (left+right)/2;
			return Math.max(Math.max(rec(ar,left,mid), rec(ar,mid+1,right)), getMid(ar,left,right));
		}
	}

	static long getMid(long[] ar, int left, int right) {
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