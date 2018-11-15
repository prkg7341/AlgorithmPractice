package JongMan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Josephus {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringBuilder sb = new StringBuilder();

		int c = Integer.parseInt(br.readLine());

		for(int i=0 ; i<c ; i++){
			
			String input = br.readLine();
			int n,k;
			n = Integer.parseInt(input.split(" ")[0]);
			k = Integer.parseInt(input.split(" ")[1]);
			
			int index=0;

			LinkedList<Integer> list = new LinkedList<>();
			for(int j=0 ; j<n ; j++){
				list.add(j+1);
			}
			while(list.size()!=2){
				while(index>=list.size()) {
					index -= list.size();
				}
				list.remove(index);
				index += k-1;						
			}
			while(list.size()!=0){
				sb.append(Integer.valueOf(list.removeFirst())+" ");
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
		}	
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
