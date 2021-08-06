package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			int n = Integer.parseInt(br.readLine());

			String[] ar = br.readLine().split(" ");

			StringBuilder sb = new StringBuilder();			
			sb.append("#").append(tt);	
			if(n%2==0) {
				for(int i=0 ; i<n/2 ; i++) {
					sb.append(" ").append(ar[i]).append(" ").append(ar[n/2+i]);
				}
			}
			else {
				for(int i=0 ; i<n/2 ; i++) {
					sb.append(" ").append(ar[i]).append(" ").append(ar[n/2+i+1]);
				}
				sb.append(" ").append(ar[n/2]);
			}
			System.out.println(sb.toString());
		}
	}	
}
