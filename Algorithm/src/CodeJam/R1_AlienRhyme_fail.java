package CodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class R1_AlienRhyme_fail {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tt = Integer.parseInt(br.readLine());

		for(int t=1 ; t<=tt ; t++){
			int n = Integer.parseInt(br.readLine());

			ArrayList<ArrayList<String>> all = new ArrayList<>(26);

			for(int j=0 ; j<26 ; j++){
				all.add(new ArrayList<String>());
			}

			for(int i=0 ; i<n ; i++){	
				String input = new StringBuilder(br.readLine()).reverse().toString();
				all.get(input.charAt(0)-65).add(input.substring(1));
			}

			int result = 0;

			for(int j=0 ; j<26 ; j++){
				Collections.sort(all.get(j));
				while(all.get(j).size()>=2){
					int max = -1;
					int index = -1;
					for(int i=1 ; i<all.get(j).size() ; i++){
						int temp = -1;
						for(int k=0 ; k<all.get(j).get(i).length() && k<all.get(j).get(i-1).length() ; k++){
							if(all.get(j).get(i).charAt(k)==all.get(j).get(i-1).charAt(k)){
								temp = k+2;
							}
							else break;
						}
						if(temp>max){
							max = temp;
							index = i-1;
						}
					}
					if(index==-1) {
						result += all.get(j).size()/2;
						break;
					}
					all.get(j).remove(index);
					all.get(j).remove(index);
					result += max;
				}
			}
			sb.append("Case #").append(t).append(": ").append(result).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}