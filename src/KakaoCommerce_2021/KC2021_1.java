package KakaoCommerce_2021;

import java.util.HashMap;

public class KC2021_1 {
	public int solution(int[] gift_cards, int[] wants) {        
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0 ; i<gift_cards.length ; i++) {
			int want = wants[i];
			if(map.containsKey(want)){
				map.put(want, map.get(want)+1);
			}
			else {
				map.put(want, 1);
			}
		}

		for(int i=0 ; i<gift_cards.length ; i++) {
			int card = gift_cards[i];
			if(map.containsKey(card)) {
				if(map.get(card)==1) {
					map.remove(card);
				}
				else {
					map.put(card, map.get(card)+1);
				}
			}
		}

		return map.size();
	}
}
