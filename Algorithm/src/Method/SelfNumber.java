package Method;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SelfNumber {

	private static int selfNum(int n){

		int result=n;

		int length;

		if(n<10) length = 1;
		else if(n<100) length = 2;
		else if(n<1000) length = 3;
		else length = 4;

		String integer = result+"";

		for(int i=0 ; i<length ; i++){
			result += Integer.parseInt(integer.split("")[i]);
		}

		return result;
	}

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[][] ar = new int[10000][2];

		for(int i=0 ; i<10000 ; i++){
			ar[i][0] = i+1;
		}

		for(int i=0 ; i<10000 ; i++){
			if((selfNum(ar[i][0])-1)<10000){
				ar[selfNum(ar[i][0])-1][1] = 1;
			}
		}

		for(int i=0 ; i<10000 ; i++){
			if(ar[i][1]==0){
				sb.append(ar[i][0] + "\n");
			}
		}

		sb.deleteCharAt(sb.length()-1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
