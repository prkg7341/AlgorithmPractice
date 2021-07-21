package Google;

import java.util.Arrays;

public class Google1 {

	public static int answer(int[] x, int[] y){
		int result = 0;
		int length;
		Arrays.sort(x);
		Arrays.sort(y);
		if(x.length>y.length){
			length = x.length;
			for(int i=0 ; i<length ; i++){
				if(x[i]!=y[i]){
					result = x[i]; break;
				}
			}
		}
		else{
			length = y.length;
			for(int i=0 ; i<length ; i++){
				if(x[i]!=y[i]){
					result = y[i]; break;
				}
			}
		}	
		
		return result;
	}
}
