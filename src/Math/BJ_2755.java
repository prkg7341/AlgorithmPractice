package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2755 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		double sum = 0;
		int total = 0;
		
		for (int i = 0; i < n; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			
			int num = Integer.parseInt(st.nextToken());
			total += num;
			
			double score;
			
			String score_ = st.nextToken();
			
			score = (int) ('E'-score_.charAt(0));
			if(score<0) {
				continue;
			}
			
			char pl = score_.charAt(1);
			
			if(pl=='+') score+=0.3;
			else if(pl=='-') score-=0.3;
			
			score *= num;
			
			sum += score;
		}
		
		sum /= total;
		
		System.out.println(String.format("%.2f", sum));
	}
}