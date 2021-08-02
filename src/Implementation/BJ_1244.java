package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int length = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		boolean[] ar = new boolean[length+1];

		for(int i=0 ; i<length ; i++){
			ar[i+1] = Integer.parseInt(input[i])==1? true : false;
		}

		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++) {			
			input = br.readLine().split(" ");

			int s = Integer.parseInt(input[0]);
			int num = Integer.parseInt(input[1]);

			if(s==1) {
				for(int j=1 ; j<ar.length ; j++) {
					if(j%num==0) ar[j] = !ar[j];
				}
			}
			else{
				ar[num] = !ar[num];
				for(int j=1 ; j<ar.length ; j++) {
					int left = num-j;
					if(left==0) break;
					int right = num+j;
					if(right==ar.length) break;
					if(!(ar[left]^ar[right])) {
						ar[left] = ar[right] = !ar[left];
					}
					else break;
				}
			}
		}

		for(int index=1 ; index<ar.length ; index++) {
			if(ar[index]) System.out.print(1+" ");
			else System.out.print(0+" ");
			if(index%20==0) System.out.println();
		}
	}	
}
