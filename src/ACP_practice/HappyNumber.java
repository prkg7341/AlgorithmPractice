package ACP_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HappyNumber {
	
	private static int happy(int n){
		int result = 0;
		String temp = n+"";
		int num = temp.split("").length;
		for(int i=0 ; i<num ; i++){
			result += Math.pow(Integer.parseInt(temp.split("")[i]), 2);
		}
		return result;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int np = n;
		
		while(true){
			np = happy(np);
			if(np==4){
				bw.write("UNHAPPY");
				break;
			}
			else if(np==1){
				bw.write("HAPPY");
				break;
			}
			else{
				//System.out.println("error");
			}
		}
		
		bw.flush();
		bw.close();
		
	}

}
