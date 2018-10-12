package Kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Booster {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n,q,a,b,hp;
		String st;

		st = br.readLine();
		n = Integer.parseInt(st.split(" ")[0]);
		q = Integer.parseInt(st.split(" ")[1]);

		int[] arx = new int[n];
		int[] ary = new int[n];

		for(int i=0 ; i<n ; i++){

			st = br.readLine();
			arx[i] = Integer.parseInt(st.split(" ")[0])+(int)Math.pow(10, 9);
			ary[i] = Integer.parseInt(st.split(" ")[1])+(int)Math.pow(10, 9);
		}
		/*int[] arxp = arx;
		int[] aryp = ary;

		Arrays.sort(arxp);
		Arrays.sort(aryp);

		int ar[][] = new int[(arxp[arxp.length-1])-arxp[0]][(aryp[aryp.length-1])-aryp[0]];
		for(int i=0 ; i<(arxp[arxp.length-1])-arxp[0] ; i++){
			for(int j=0 ; j<(aryp[aryp.length-1])-aryp[0] ; j++){

				ar[arx[i]][ary[j]] = 1;
			}
		}//점찍기*/
		
		for(int i=0 ; i<q; i++){
			
			st = br.readLine();
			a = Integer.parseInt(st.split(" ")[0]);
			b = Integer.parseInt(st.split(" ")[1]);
			hp = Integer.parseInt(st.split(" ")[2]);
			
			if(a>b){
				int temp=a;
				a=b;
				b=temp;						
			}
			
			int xd,yd;
			
			xd = arx[b-1]-arx[a-1];
			yd = ary[b-1]-ary[a-1];
			
			if(xd<yd){
				int temp=xd;
				xd=yd;
				yd=temp;
			}//xd가 크거나 같게
			
			int min = yd;
			
			if(hp>=min){
				sb.append("YES"+"\n");
			}
			else{
				sb.append("NO"+"\n");
			}
			
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		
		
		bw.flush();
		bw.close();
	}

}
