package Naver2021;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class N2 {
	public int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        
        Deque<Integer> dq = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0 ; i<ball.length ; i++) {
        	dq.add(ball[i]);
        }
        
        int index = 0;
        
        for(int i=0 ; i<order.length ; i++) {
        	int now = order[i];
        	if(dq.peekFirst()==now) {
        		answer[index++] = dq.removeFirst();
        		while(!map.isEmpty() && !dq.isEmpty() && map.containsKey(dq.peekFirst())) {
        			answer[index++] = dq.removeFirst();
        		}
        	}
        	else if(dq.peekLast()==now) {
        		answer[index++] = dq.removeLast();
        		while(!map.isEmpty() && !dq.isEmpty() && map.containsKey(dq.peekLast())) {
        			answer[index++] = dq.removeLast();
        		}
        	}
        	else {
        		map.put(now, 1);
        	}
        }        
        
        return answer;
    }	
}
