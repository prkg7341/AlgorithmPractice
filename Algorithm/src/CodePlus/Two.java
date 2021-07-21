package CodePlus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Two {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String input;

		input = br.readLine();
		int m = Integer.parseInt(input.split(" ")[0]);

		input = br.readLine();
		int[][] ar = new int[m][3];
		for(int i=0 ; i<m ; i++){
			ar[i][0] = Integer.parseInt(input.split(" ")[i]);
		}

		int check = 0;
		input = br.readLine();
		for(int i=0 ; i<m ; i++){
			ar[i][1] = Integer.parseInt(input.split(" ")[i]);

			if(ar[i][1]>ar[i][0]){
				System.out.println(-1); check=-1; break;
			}
		}

		if(check!=-1){

			int max=1;
			int[][] ar2 = new int[m][2];

			for(int i=m-1 ; i>=0 ; i--){
				ar2[i][1] = max; 
				ar2[i][0] = ar[i][0] + 1;
				max *= ar2[i][0];				
			}

			input = br.readLine();
			int n = Integer.parseInt(input);

			n %= max;
			
			for(int i=0 ; i<m ; i++){
				
				ar[i][1] += n/ar2[i][1];
				n /= ar2[i][0];
				sb.append(ar[i][1]+"");
				System.out.println(n);
			}
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
		}
	}

}
