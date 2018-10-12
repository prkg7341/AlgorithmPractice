package FindRule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Cain {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		int m=0,n=0,x=0,y=0;
		String st;
		int count;

		while(num--!=0){
			st = br.readLine();
			m = Integer.parseInt(st.split(" ")[0]);
			n = Integer.parseInt(st.split(" ")[1]);
			x = Integer.parseInt(st.split(" ")[2]);
			y = Integer.parseInt(st.split(" ")[3]);

			count=1;

			if(x==y){
				count=x;
			}
			else{
				count=-1;
				if(x<y){
					int temp=x;
					x=y;
					y=temp;
					temp=m;
					m=n;
					n=temp;
				}
				for(int i=1 ; i<=m ; i++){
					if((n*(i))%m==(x-y)){
						count=i*n+y; break;
					}
				}
			}

			sb.append(count+"\n");
		}

		sb.deleteCharAt(sb.length()-1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	/*private static int getGCD(int m, int n) {
		while (n != 0) {
			int temp = m % n;
			m = n;
			n = temp;
		}
		return m;
	}*/

}
