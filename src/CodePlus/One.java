package CodePlus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class One {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String input;
		String[][] ar = new String[3][2];
		String year, month, day;
		
		for(int i=0 ; i<3 ; i++){
			input = br.readLine();
			ar[i][0] = input;
			if(input.contains("/")){
				year = input.split("/")[0].substring(input.split("/")[0].length()-2);
				month = input.split("/")[1];
				if(month.length()==1){
					month = "0" + month;
				}
				day = input.split("/")[2].substring(0, 2);
				if((int)day.charAt(1)<48 || (int)day.charAt(1)>57){
					day = "0" + day.charAt(0);
				}
			}
			else if(input.contains("-")){
				year = input.split("-")[0].substring(input.split("-")[0].length()-2);
				month = input.split("-")[1];
				if(month.length()==1){
					month = "0" + month;
				}
				day = input.split("-")[2].substring(0, 2);
				if((int)day.charAt(1)<48 || (int)day.charAt(1)>57){
					day = "0" + day.charAt(0);
				}
			}
			else if(input.contains("년") && input.contains("월") && input.contains("일")){
				year = input.split("년")[0].substring(input.split("년")[0].length()-2);
				month = input.split("년")[1].split("월")[0];
				if(month.length()==1) {
					month = "0" + month;
				}
				day = input.split("년")[1].split("월")[1].split("일")[0];
				if(day.length()==1) {
					day = "0" + day;
				}
			}
			else{
				year = "er";
				month = "ro";
				day = "r!";
			}
			ar[i][1] = year + month + day;
		}
		
		int[][] ar2 = new int[3][2];
		for(int i=0 ; i<3 ; i++){
			ar2[i][0] = Integer.parseInt(ar[i][1]);
			ar2[i][1] = i; 
		}
		
		Arrays.sort(ar2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
		
		for(int i=0 ; i<3 ; i++){
			switch (ar2[i][1]){
			case 0: sb.append(ar[0][0]).append("\n"); break;
			case 1: sb.append(ar[1][0]).append("\n"); break;
			case 2: sb.append(ar[2][0]).append("\n"); break;
			}
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
