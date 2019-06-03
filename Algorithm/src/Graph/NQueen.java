package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueen {

	static long count = 0;
	static int n;

	static int[] plus;
	static int[] minus;
	static int[] index;

	final static int impossible = 30;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		plus = new int[n];
		minus = new int[n];
		index = new int[n];

		Arrays.fill(plus, impossible);
		Arrays.fill(minus, impossible);
		Arrays.fill(index, impossible);

		bt(0);

		System.out.print(count);
	}

	private static void bt(int x) {
		if(x==n) {
			count++;
			return;
		}
		for(int b=0 ; b<n ; b++){
			boolean check = true;
			for(int a=0 ; a<x ; a++){
				if(!(plus[a]!=x+b && minus[a]!=x-b && index[a]!=b)){
					check = false;
					break;
				}
			}
			if(check){
				plus[x] = x+b;
				minus[x] = x-b;
				index[x] = b;

				bt(x+1);

				plus[x] = impossible;
				minus[x] = impossible;
				index[x] = impossible;
			}
		}
	}
}
