import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class tercespoT {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while(true){
			String input = br.readLine();
			if(input.compareTo("END")==0) break;
			char[] ar = input.toCharArray();
			for(int i=0 ; i<ar.length/2 ; i++){
				char temp = ar[i];
				ar[i] = ar[ar.length-1-i];
				ar[ar.length-1-i] = temp;
			}
			for(int i=0 ; i<ar.length ; i++){
				sb.append(ar[i]);
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
