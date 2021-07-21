package HackDay;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class H3 {
	public int solution(int[] T) {
		// write your code in Java SE 8
		int max = T[0];
		int max_max = max;
		int index=0;

		for(int i=1 ; i<T.length ; i++){
			if(T[i]>max_max){
				max_max = T[i];
			}
			else if(T[i]>max){
				continue;
			}
			else{
				index = i;
			}
		}
		return index+1;
	}
}