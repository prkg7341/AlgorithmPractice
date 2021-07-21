package Naver2021_Intern;

import java.util.HashMap;

public class N1 {
	public int solution(int[][] boxes) {
		
		int size = boxes.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0 ; i<boxes.length ; i++) {
        	int a = boxes[i][0];
        	int b = boxes[i][1];
        	
        	if(a!=b) {
        		if(map.containsKey(a)) {
        			map.remove(a);
            		size--;
        		}
        		else map.put(a, 1);
        		if(map.containsKey(b)) {
        			map.remove(b);
            		size--;
        		}
        		else map.put(b, 1);
        	}
        	else {
        		size--;
        	}
        }
        
        return size;
    }
}
