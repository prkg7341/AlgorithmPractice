package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SDS_1_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();		

		int t = Integer.parseInt(br.readLine().split(" ")[0]); // 테스트 케이스 갯수

		for(int i=1 ; i<=t ; i++){
			
			int n,m;
			String input[] = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			
			int result=0;
			int carSum=0;
			
			int[] color, car;
			
			color = new int[m+1];
			car = new int[n+1];
			
			input = br.readLine().split(" ");
			for(int j=1 ; j<=m ; j++){
				color[j] = Integer.parseInt(input[j-1]);
				carSum += color[j];
			}

			input = br.readLine().split(" ");
			for(int j=1 ; j<=n ; j++){
				car[j] = Integer.parseInt(input[j-1]);
			}

			int[] colorP = new int[color.length];
			
			for(int q=1 ; q<color.length ; q++){
				colorP[q] = color[q];
			}
			
			for(int j=1 ; j<=n-carSum+1 ; j++){
				for(int k=0 ; k<carSum ; k++){
					if(color[car[j+k]]==0){
						color[0] = -1;
						break;
					}
					else{
						color[car[j+k]]--;
					}
				}
				if(color[0]!=-1){
					result = j;
					break;
				}
				else{
					for(int q=0 ; q<color.length ; q++){
						color[q] = colorP[q];
					}
				}
			}			
			sb.append("#"+i+" "+result+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
