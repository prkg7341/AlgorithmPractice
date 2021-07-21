package NaverWebtoon2021;

import java.util.Arrays;
import java.util.Collections;

public class NW1 {
	public int solution(int[] prices, int[] discounts) {
		int answer = 0;
		
		Integer[] p = new Integer[prices.length];
		for(int i=0 ; i<p.length ; i++) {
			p[i] = prices[i];
		}
		
		Integer[] d = new Integer[discounts.length];
		for(int i=0 ; i<d.length ; i++) {
			d[i] = discounts[i];
		}

		Arrays.sort(p,Collections.reverseOrder());
		Arrays.sort(d,Collections.reverseOrder());

		int length = Math.min(p.length, d.length);

		for(int i=0 ; i<length ; i++) {
			answer += p[i]/100*(100-d[i]);
		}

		if(length<p.length) {
			for(int i=length ; i<p.length ; i++) {
				answer += p[i];
			}
		}

		return answer;
	}
}
