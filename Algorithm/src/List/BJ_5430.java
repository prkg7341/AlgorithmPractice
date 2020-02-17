package List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		f1:
			for(int tt=0 ; tt<t ; tt++){
				char[] method = br.readLine().toCharArray();
				int n = Integer.parseInt(br.readLine());			
				LinkedList<Integer> list = new LinkedList<>();

				String[] input = br.readLine().replaceAll("\\[", "").replaceAll("\\]", "").split(",");

				for(int i=0 ; i<n ; i++){
					list.add(Integer.parseInt(input[i]));
				}

				boolean reverse = false;

				StringBuilder sb = new StringBuilder();

				for(int i=0 ; i<method.length ; i++){
					if(method[i]=='R'){
						reverse = reverse? false : true;
					}
					else{
						if(list.size()==0) {
							System.out.println("error");
							continue f1;
						}
						if(reverse){
							list.pollLast();
						}
						else{
							list.pollFirst();
						}
					}
				}
				if(list.size()==0){
					sb.append("[]");
				}
				else if(reverse){
					sb.append("[");
					while(!list.isEmpty()){
						sb.append(list.pollLast()).append(",");
					}
				}
				else{
					sb.append("[");
					while(!list.isEmpty()){
						sb.append(list.pollFirst()).append(",");
					}
				}
				sb.replace(sb.length()-1, sb.length(), "]");
				System.out.println(sb.toString());
			}
	}
}