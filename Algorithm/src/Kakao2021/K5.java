package Kakao2021;

import java.util.Arrays;
import java.util.Comparator;

public class K5 {
	public String solution(String play_time, String adv_time, String[] logs) {        
        int p1,p2,p3,a1,a2,a3;
        String[] pt = play_time.split(":");
        String[] at = adv_time.split(":");
        p1 = Integer.parseInt(pt[0]);
        p2 = Integer.parseInt(pt[1]);
        p3 = Integer.parseInt(pt[2]);
        a1 = Integer.parseInt(at[0]);
        a2 = Integer.parseInt(at[1]);
        a3 = Integer.parseInt(at[2]);
        
        int p_time = p1*3600+p2*60+p3;
        int a_time = a1*3600+a2*60+a3;
        
        int[] temp_ar = new int[p_time+1];
        
        int[][] ar = new int[p_time][2];
        
        for(int i=0 ; i<ar.length ; i++) {
        	ar[i][0] = i;
        }
        
        for(int i=0 ; i<logs.length ; i++) {
        	String[] temp = logs[i].split("-");
        	String[] from = temp[0].split(":");
        	String[] to = temp[1].split(":");
        	int h1 = Integer.parseInt(from[0]);
        	int m1 = Integer.parseInt(from[1]);
        	int s1 = Integer.parseInt(from[2]);
        	int h2 = Integer.parseInt(to[0]);
        	int m2 = Integer.parseInt(to[1]);
        	int s2 = Integer.parseInt(to[2]);
        	
        	int start = h1*3600+m1*60+s1;
        	int end = h2*3600+m2*60+s2;
        	
        	for(int j=start ; j<=end ; j++) {
        		temp_ar[j]++;
        	}
        }
        
        for(int i=0 ; i<=a_time ; i++) {
        	ar[0][1] += temp_ar[i];
        }
        
        for(int i=1 ; i<ar.length-a_time ; i++) {
        	ar[i][1] = ar[i-1][1]+temp_ar[i+a_time]-temp_ar[i-1];
        }
        
        Arrays.sort(ar, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]<o2[1]) return 1;
				else if(o1[1]>o2[1]) return -1;
				else {
					return o1[0]-o2[0];
				}
			}        	
        });
        
        int time = ar[0][0];
        int hour = time/3600;
        int min = time%3600/60;
        int sec = time%60;
        
        StringBuilder sb = new StringBuilder();
        
        if(hour<10) {
        	sb.append(0);
        }
        sb.append(hour).append(":");
        if(min<10) {
        	sb.append(0);
        }
        sb.append(min).append(":");
        if(sec<10) {
        	sb.append(0);
        }
        sb.append(sec);
        
        return sb.toString();
    }
}
