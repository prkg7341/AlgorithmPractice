package FindRule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Apartment2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int layer=0;
		int index=0;

		int[][] ar = new int[15][14];

		for(int i=0 ; i<14 ; i++){
			ar[0][i] = i+1;//0Ãþ
			ar[i][0] = 1;
		}
		ar[14][0] = 1;
		
		for(int i=1 ; i<=14 ; i++){
			for(int j=1 ; j<14 ; j++){
				ar[i][j] = ar[i][j-1] + ar[i-1][j];
			}
		}

		while(n--!=0){
			layer = Integer.parseInt(br.readLine());
			index = Integer.parseInt(br.readLine());
			sb.append(ar[layer][index-1]+"\n");
		}

		sb.deleteCharAt(sb.length()-1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
