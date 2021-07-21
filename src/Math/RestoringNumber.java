package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RestoringNumber {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] notSosu = new boolean[100001];

		for(int i=2 ; i<=100000 ; i++){
			if(!notSosu[i]){
				for(int j=2*i ; j<=100000 ; j += i){
					notSosu[j] = true;
				}
			}
		}

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++){
			int n = Integer.parseInt(br.readLine());

			int index = 1;
			int count = 0;
			boolean end = false;

			while(true){

				index++;

				if(notSosu[index]) continue;

				while(n%index==0 && n!=1){
					n /= index;
					count++;
					if(n==1) {
						end = true;
						break;
					}
				}
				if(count!=0){
					bw.write(String.valueOf(index));
					bw.write(" ");
					bw.write(String.valueOf(count));
					bw.write("\n");
					count = 0;
				}
				if(end){
					break;
				}
			}
		}

		bw.flush();
	}
}
