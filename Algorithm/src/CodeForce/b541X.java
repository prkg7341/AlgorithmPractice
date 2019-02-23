package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b541X {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int beforeA=0, beforeB=0, count=1;

		for(int i=0 ; i<n ; i++){
			String input[] = br.readLine().split(" ");

			int nowA = Integer.parseInt(input[0]);
			int nowB = Integer.parseInt(input[1]);

			if(beforeA==beforeB){
				if(nowA==nowB){
					count+=nowA-beforeA;
				}
				else if(nowA>nowB){
					count+=nowB-beforeB;
				}
				else{
					count+=nowA-beforeA;
				}
			}
			else if(beforeA>beforeB){
				if(nowA==nowB){
					count+=1+nowA-beforeA;
				}
				else if(nowA>nowB){
					if(beforeA==nowB){
						count+=1;
					}
					else if(beforeA<nowB){
						count+=1+nowB-beforeA;
					}
					else{
						count+=0;
					}
				}
				else{
					count+=1+nowA-beforeA;
				}
			}
			else{
				if(nowA==nowB){
					count+=1+nowB-beforeB;
				}
				else if(nowA>nowB){
					count+=1+nowB-beforeB;
				}
				else{
					if(beforeB==nowA){
						count+=1;
					}
					else if(beforeB<nowA){
						count+=0;
					}
					else{
						count+=1+nowA-beforeB;
					}
				}
			}
			beforeA = nowA;
			beforeB = nowB;
		}
		System.out.println(count);
	}
}
