package NaverWebtoon2021;

public class NW3 {
	public int solution(String s, String t) {        
        String newS = String.valueOf(s);
        
        int before = newS.length();
        int after = newS.length();
        
        while(true) {
        	before = after;
        	newS = newS.replaceAll(t, "");
        	after = newS.length();
        	if(before==after) break;
        }       
        
        return (s.length() - newS.length())/t.length();
    }
}
