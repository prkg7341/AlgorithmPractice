package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Encryption {

	static StringBuilder sb;
	static int max;
	static int len;
	static char[] ar;
	static boolean[] mo = {true, false, false, false, true, false, false, false, true, false, 
			false, false, false, false, true, false, false, false, false, false, 
			true, false, false, false, false, false};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		max = Integer.parseInt(input[0]);
		len = Integer.parseInt(input[1]);

		char[] temp = br.readLine().toCharArray();

		ar = new char[len];

		for(int i=0 ; i<len ; i++){
			ar[i] = temp[2*i];
		}
		Arrays.sort(ar);
		test(0, "");
		System.out.print(sb.toString());
	}

	static void test(int index, String st){
		if(index==len){
			if(st.length()==max){
				int count1 = 0;
				int count2 = 0;
				for(int i=0 ; i<st.length() ; i++){
					char now = st.charAt(i);
					if(mo[(int)(now-'a')]) count1++;
					else count2++;
					if(count1>=1 && count2>=2){
						sb.append(st).append("\n");
						return;
					}
				}
			}
		}
		else{
			if(st.length()==max){
				test(index+1, st);
			}
			else{
				test(index+1, st+ar[index]);
				test(index+1, st);
			}
		}
	}
}
