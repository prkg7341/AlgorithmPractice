package NaverWebtoon2021;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NW2 {
	public String[] solution(String s) {
        String[] answer;   
        
        int l = 1;
        Queue<String> front = new LinkedList<>();
        Stack<String> back = new Stack<>();
        
        while(s.length()>0) {
        	
        	if(l>s.length()-l) {
        		front.add(s);
        		break;
        	}
        	
        	String left = s.substring(0, l);
        	String right = s.substring(s.length()-l, s.length()); 
        	
        	if(left.equals(right)) {
        		front.add(left);
        		back.add(right);
        		s = s.substring(l, s.length()-l);  
        		l = 1;
        	}
        	else {
        		l++;
        	}
        }
        
        answer = new String[front.size()+back.size()];
        
        int index = 0;
        
        while(!front.isEmpty()) {
        	answer[index++] = front.poll();
        }
        
        while(!back.isEmpty()) {
        	answer[index++] = back.pop();
        }
        
        return answer;
    }
}
