package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Alphabet {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		byte[] ar = new byte[str.length()];
		for(int i=0 ; i<ar.length ; i++){
			ar[i] = str.getBytes()[i];
		}

		byte b = "a".getBytes()[0];

		byte[][] alpha = new byte[26][2];
		for(int i=0 ; i<26 ; i++){
			alpha[i][0] = b++;
			alpha[i][1] = -1;
		}

		for(byte i=0 ; i<ar.length ; i++){
			for(int j=0 ; j<alpha.length ; j++){
				if(ar[i]==alpha[j][0]){
					if(alpha[j][1] == -1){
						alpha[j][1]=i; break;
					}
					else break;
				}
			}
		}

		for(int j=0 ; j<alpha.length ; j++){
			sb.append(alpha[j][1] + " ");
		}

		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
