package Kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Doll {
	
	static double av(int[] ar, int left, int right){
		double sum=0;
		for(int i=left ; i<=right ; i++){
			sum+=ar[i];
		}
		
		return sum/(right-left+1);
	}
	
	static double var(int[] ar, int left, int right, double m) {

		double result=0;
		
		for(int i=left ; i<=right ; i++){
			result+=Math.pow(ar[i]-m, 2);
		}	
		return result/(right-left+1);
	}
	
	static double minVar(int[] ar, int k){
		
		double result=0;
		double minresult = Double.MAX_VALUE;
		double average = 0;
		
		for(int i=0 ; i<ar.length-k+1 ; i++){
			average = av(ar, i, i+k-1);
			result = var(ar,i,i+k-1, average);
			if(result<minresult){
				minresult = result;
			}
		}		
		return minresult;
	}	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n,k;
		String st;
		
		st = br.readLine();
		n = Integer.parseInt(st.split(" ")[0]);
		k = Integer.parseInt(st.split(" ")[1]);
		
		int[] ar = new int[n];
		
		st = br.readLine();
		
		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(st.split(" ")[i]);
		}
		
		bw.write(Math.pow(minVar(ar,k), 0.5)+"");
		bw.flush();
		bw.close();

	}

}
