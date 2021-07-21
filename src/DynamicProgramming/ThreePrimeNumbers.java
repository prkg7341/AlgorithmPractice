package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ThreePrimeNumbers {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] notSosu = new boolean[1001];
		ArrayList<Integer> list = new ArrayList<>();

		for(int i=2 ; i<1001 ; i++){
			if(!notSosu[i]){
				list.add(i);
				for(int j=i*2 ; j<1001 ; j+=i){
					notSosu[j] = true;
				}
			}
		}

		int t = Integer.parseInt(br.readLine());

		loop:
			for(int tt=0 ; tt<t ; tt++){
				int n = Integer.parseInt(br.readLine());

				for(int i=0 ; i<list.size() ; i++){
					for(int j=i ; j<list.size() ; j++){
						for(int k=j ; k<list.size() ;k++){
							if(list.get(i)+list.get(j)+list.get(k)==n){
								sb.append(list.get(i)).append(" ").append(list.get(j)).append(" ").append(list.get(k)).append("\n");
								continue loop;
							}
						}
					}
				}
			}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}