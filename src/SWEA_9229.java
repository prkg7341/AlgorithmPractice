import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			int[] ar = new int[n];

			for(int i=0 ; i<n ; i++) {
				ar[i] = Integer.parseInt(st.nextToken());
			}

			int result = -1;

			for(int i=0 ; i<n ; i++) {
				for(int j=i+1 ; j<n ; j++) {
					if(ar[i]+ar[j]<=max) {
						result = Math.max(result, ar[i]+ar[j]);
					}
				}
			}

			System.out.printf("#%d %d\n", tt, result);
		}
	}	
}
