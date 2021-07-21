package KakaoEnterprise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class KE3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int made = Integer.parseInt(input[0]);
		int make = Integer.parseInt(input[1]);

		long max = -1;

		long[] trees = new long[made];

		for(int i=0 ; i<trees.length ; i++) {
			trees[i] = Math.round(Double.parseDouble(br.readLine())*1000);
			max = Math.max(max, trees[i]);
		}

		long left = 0;
		long right = max;

		double ret = 0;

		while(left<right) {
			long mid = (left+right)/2;

			long count = 0;

			for(int i=0 ; i<trees.length ; i++) {
				count += trees[i]/mid;
			}

			if(count>=make) {
				left = mid+1;
				ret = Math.max(ret, mid);
			}
			else {
				right = mid-1;
			}
		}
		ret /= 1000.0;
		System.out.println(String.format("%.2f", ret));
	}
}