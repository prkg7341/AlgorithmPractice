package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EurekaTheory {

	static int count=0;
	static int s;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] ar = new int[45];

		for(int i=0 ; i<45 ; i++){
			ar[i] = (i+1)*(i+2)/2;
		}

		int t = Integer.parseInt(br.readLine());

		for(int tt = 0 ; tt<t ; tt++){
			boolean boo = true;
			int n = Integer.parseInt(br.readLine());
			whole:
				for(int i=0 ; i<45 && ar[i]<=n ; i++){
					for(int j=0 ; j<45 && ar[i]+ar[j]<=n ; j++){
						for(int k=0 ; k<45 && ar[i]+ar[j]+ar[k]<=n ; k++){
							if(ar[i]+ar[j]+ar[k]==n){
								sb.append(1).append("\n");
								boo = false;
								break whole;
							}
						}
					}
				}
			if(boo) sb.append(0).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}