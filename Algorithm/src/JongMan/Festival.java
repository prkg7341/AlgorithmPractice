package JongMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Festival {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c,n,l;
		
		c = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<c ; i++){
			int average, min;
			String st = br.readLine();
			n = Integer.parseInt(st.split(" ")[0]); // 공연장을 대여할 수 있는 날들의 수
			l = Integer.parseInt(st.split(" ")[1]); // 섭외한 공연팀의 수
			int[] ar = new int[n];
			st = br.readLine();
			for(int j=0 ; j<ar.length ; j++){
				ar[j] = Integer.parseInt(st.split(" ")[j]);
			}
			
			while(l<n){
				average = 
				l++;
			}
		}
	}
}
