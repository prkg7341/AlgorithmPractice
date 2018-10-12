package Kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class ShortCoding {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String st = br.readLine();
		String[][] ar = new String[st.split("&&").length][2];

		for(int i=0 ; i<st.split("&&").length ; i++){
			ar[i][0] = st.split("&&")[i];
			ar[i][1] = null;

			if(ar[i][0].contains("==")){
				ar[i][1] = ar[i][0].split("==")[1];
				ar[i][0] = ar[i][0].split("==")[0];
			}
			else{
				ar[i][1] = ar[i][0].split("!=")[1];
				ar[i][0] = ar[i][0].split("!=")[0];
			}
		}

		for(int i=0 ; i<st.split("&&").length ; i++){
			String firstDigit = ar[i][1].split("")[0];
			if(firstDigit.compareTo("0")==0 || firstDigit.compareTo("1")==0 
					|| firstDigit.compareTo("2")==0 || firstDigit.compareTo("3")==0 
					|| firstDigit.compareTo("4")==0 || firstDigit.compareTo("5")==0 
					|| firstDigit.compareTo("6")==0 || firstDigit.compareTo("7")==0 
					|| firstDigit.compareTo("8")==0 || firstDigit.compareTo("9")==0 
					|| firstDigit.compareTo("-")==0){

				for(int j=0 ; j<st.split("&&").length ; j++){
					if(ar[j][1].compareTo(ar[i][0])==0){
						ar[j][1] = ar[i][1];
					}
				}
			}			
		}
		
		for(int i=0 ; i<st.split("&&").length ; i++){
			int minLength=ar[i][0].length();
			String str;
			for(int j=i+1 ; j<st.split("&&").length ; j++){
				if(ar[j][1].compareTo(ar[i][1])==0){
					if(ar[j][0].length()<minLength){
						minLength = ar[j][0].length();
						str = ar[j][0];
					}
				}
			}
		}
		




	}
	

}
