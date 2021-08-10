package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=1 ; t<=10 ; t++) {
			int n = Integer.parseInt(br.readLine());

			boolean fin = false;

			for(int i=0 ; i<n ; i++){
				StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

				stringTokenizer.nextToken(); //num
				char val = stringTokenizer.nextToken().charAt(0);

				if(stringTokenizer.hasMoreTokens()) {
					if(val<='9' && val>='0') {
						fin = true;
					}
				}
				// leaf
				else {
					if(val>'9' || val<'0') {
						fin = true;
					}
				}

			}
			if(!fin) System.out.println("#"+t+" 1");
			else System.out.println("#"+t+" 0");
		}	
	}	
}
