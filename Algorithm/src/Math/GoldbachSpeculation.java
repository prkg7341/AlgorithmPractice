package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachSpeculation {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] notSosu = new boolean[4998];

		for(int i=0 ; i<4998 ; i++){
			if(!notSosu[i]){
				for(int j=3*i+3 ; j<4998 ; j+=2*i+3){
					notSosu[j] = true;
				}
			}
		}

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++){
			int n = Integer.parseInt(br.readLine());
			if(n==4){
				sb.append(2+" "+2+"\n");
				continue;
			}			
			int startI = n/2-1; // n+1의 booelan 값을 가진 index
			int other;
			boolean isEven = startI%2==0;
			if(isEven){
				startI = startI/2-1;
				other = startI;
			}
			else{
				startI /= 2;
				other = startI-1;
			}
			while(other>=0){
				if(!notSosu[other] && !notSosu[startI]){
					sb.append((2*other+3) + " " + (2*startI+3) + "\n");
					break;
				}
				other--; startI++;
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}