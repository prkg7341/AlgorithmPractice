package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class f541XX {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		boolean[] checked = new boolean[n];
		
		ArrayList<Map> list = new ArrayList<>();

		for(int i=0 ; i<n ; i++){
			String input[] = br.readLine().split(" ");
			
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			if(!checked[a-1] && !checked[b-1]){				
				list.add(new Map(a,true));
				list.add(new Map(b,false));
			}
			else if(checked[a-1] && checked[a-1]){
				
			}
			else{
				if(!checked[a-1]){
					list.add(new Map(a,false));					
				}
				else{
					
				}
			}
		}
	}
	static class Map{
		
		int value;
		boolean isStart;
		
		Map(int value, boolean isStart){
			this.value = value;
			this.isStart = isStart;
		}
	}
}
