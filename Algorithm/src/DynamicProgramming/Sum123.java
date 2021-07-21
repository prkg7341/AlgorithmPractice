package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sum123 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int[] fac = new int[11];

		fac[0] = 1;

		for(int i=1 ; i<=10 ; i++){
			fac[i] = fac[i-1]*i;
		}

		int count = 0;

		for(int i=0 ; i<t ; i++){
			int n = Integer.parseInt(br.readLine());

			if(n==1) count=1;

			else{

				int[] ar = new int[3];

				ar[2] = n/3;

				if(ar[2]%2==0){				
					ar[1] = (n%3)/2;
					ar[0] = (n%3)%2;
				}
				else{
					ar[0] = n%3;
				}

				while(ar[0]!=n){		

					count += fac[ar[2]+ar[1]+ar[0]] / (fac[ar[2]]*fac[ar[1]]*fac[ar[0]]);
					if(ar[2]%2==0){		

						while(ar[1]!=0){
							ar[1]--;
							ar[0]+=2;
							count += fac[ar[2]+ar[1]+ar[0]] / (fac[ar[2]]*fac[ar[1]]*fac[ar[0]]);
						}
						if(ar[2]!=0){
							ar[2]--;
							ar[0]+=3;
						}
					}
					else{
						while(ar[0]>=2){	
							ar[0]-=2;
							ar[1]++;
							count += fac[ar[2]+ar[1]+ar[0]] / (fac[ar[2]]*fac[ar[1]]*fac[ar[0]]);
						}
						ar[2]--;
						ar[1]++;
						ar[0]++;
						if(ar[0]==2){
							ar[0]=0;
							ar[1]++;
						}
					}
				}
			}

			sb.append(count+"\n");
			count = 0;
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
