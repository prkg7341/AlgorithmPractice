package KakaoCodeFestival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class L {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arx1 = new int[8];
		int[] ary1 = new int[8];
		int[] arx2 = new int[8];
		int[] ary2 = new int[8];

		for(int i=0 ; i<n ; i++){

			String st = br.readLine();			

			arx1[i] = Integer.parseInt(st.split(" ")[0]);
			ary1[i] = Integer.parseInt(st.split(" ")[1]);

			arx2[i] = arx1[i];
			ary2[i] = ary1[i];

		}

		Arrays.sort(arx1);
		Arrays.sort(ary1);

		int[][] ar = new int[arx1[arx1.length-1]+1][ary1[ary1.length-1]+1];		
		
		for(int i=0 ; i<n ; i++){
				ar[arx2[i]][ary2[i]] = 1;
		}//Á¡Âï±â

		for(int i=1 ; i<=n ; i++){
			if(i%2==1){//È¦¼ö¹øÂ° ½Ã±â -> xÁÂÇ¥ ¹Ù²ñ
				if(arx2[i-1]<=arx2[i]){
					for(int j=arx2[i-1] ; j < arx2[i%n] ; j++){
						ar[j][ary2[i-1]]=1;
					}
				}
				else{
					for(int j=arx2[i-1] ; j < arx2[i%n] ; j--){
						ar[j][ary2[i-1]]=1;
					}
				}
			}
			else{
				if(ary2[i-1]<=ary2[i%n]){
					for(int j=ary2[i-1] ; j < ary2[i%n] ; j++){
						ar[arx2[i-1]][j]=1;
					}
				}
				else{
					for(int j=ary2[(i-1)%n] ; j < ary2[i%n] ; j--){
						ar[arx2[i-1]][j]=1;
					}
				}
			}
		}//µµÇü±×¸®±â
		
		for(int i=0 ; i<=ary1[ary1.length-1] ; i++){
			for(int j=0 ; j<=arx1[arx1.length-1] ; j++){
				System.out.print(ar[j][i]);
			}
			System.out.println();
		}


		bw.flush();
		bw.close();

	}

}
