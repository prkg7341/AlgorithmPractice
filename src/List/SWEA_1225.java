package List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=1 ; t<=10 ; t++) {
			br.readLine();

			int[] ar = new int[8];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i=0 ; i<8 ; i++) {
				ar[i] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			int index = 0;

			while(true) {
				if(index==8) index = 0;
				ar[index] -= ++count;
				if(ar[index]<=0) {
					ar[index] = 0;
					System.out.print("#"+t);
					for(int i=index+1 ; i<8 ; i++) {
						System.out.print(" "+ar[i]);
					}
					for(int i=0 ; i<index+1 ; i++) {
						System.out.print(" "+ar[i]);
					}
					System.out.println();
					break;
				}
				index++;
				if(count==5) count=0;
			}
		}
	}	
}
