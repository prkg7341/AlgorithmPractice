import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Turret {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringBuilder sb = new StringBuilder();
			
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<n ; i++){
			int x1,y1,r1,x2,y2,r2;
			String[] inputAr = br.readLine().split(" ");
			x1 = Integer.parseInt(inputAr[0]);
			y1 = Integer.parseInt(inputAr[1]);
			r1 = Integer.parseInt(inputAr[2]);
			x2 = Integer.parseInt(inputAr[3]);
			y2 = Integer.parseInt(inputAr[4]);
			r2 = Integer.parseInt(inputAr[5]);
			
			if(x1==x2 && y1==y2){
				if(r1==r2){
					sb.append(-1+"\n");
				}
				else{
					sb.append(0+"\n");
				}
			}
			else{
				int rr = (r1+r2)*(r1+r2);
				int rrr = (r1-r2)*(r1-r2);
				int distance = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
				if(rr==distance || distance==rrr){
					sb.append(1+"\n");
				}
				else if(rr<distance){
					sb.append(0+"\n");
				}
				else{
					if(distance<rrr){
						sb.append(0+"\n");
					}
					else{
						sb.append(2+"\n");
					}
				}
			}
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
