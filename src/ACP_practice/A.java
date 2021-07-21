package ACP_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class A {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String temp = br.readLine();
		
		int pNum, qNum, pY, qY;
		
		pNum = Integer.parseInt(temp.split(" ")[0]);
		qNum = Integer.parseInt(temp.split(" ")[1]);
		
		temp = br.readLine();

		pY = Integer.parseInt(temp.split(" ")[0]);
		qY = Integer.parseInt(temp.split(" ")[1]);
		
		int ySub = pY-qY;
		if(ySub<0) ySub = -ySub;
		
		int[] ar1 = new int[pNum];
		
		temp = br.readLine();
		
		for(int i=0 ; i<ar1.length ; i++){
			ar1[i] = Integer.parseInt(temp.split(" ")[i]);
		}
		
		Arrays.sort(ar1);
		
		int[] ar2 = new int[qNum];
		
		temp = br.readLine();
		
		for(int i=0 ; i<qNum ; i++){
			ar2[i] = Integer.parseInt(temp.split(" ")[i]);
		}
		
		Arrays.sort(ar2);
		
		int min = Integer.MAX_VALUE;
		
		int count=1;
		
		int pi=0;
		int qi=0;
		int sub;
		int check;
		
		while(pi!=ar1.length && qi!=ar2.length){
			sub = ar1[pi] - ar2[qi];
			if(sub<0) {
				sub = -sub;
				pi++;
			}
			else if(sub>0){
				qi++;
			}
			else{
				if(pi==ar1.length-1){
					if(qi==ar2.length-1){
						continue;
					}
					else{
						qi++;
					}
				}
				else{
					if(qi==ar2.length-1){
						pi++;
					}
					else{
						if(ar1[pi+1]>ar2[qi+1]){
							qi++;
						}
						else{
							pi++;
						}
					}
				}
			}
			check = min-sub;
			if(check<0){
				count=1;
				min = sub;
			}
			else count++;
			
		}

		System.out.println(ySub);
		System.out.println(min);
		System.out.println(count);
		
		sb.append(ySub+min).append(" ").append(count);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
