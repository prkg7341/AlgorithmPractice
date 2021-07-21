package If;
import java.util.ArrayList;
import java.util.Scanner;
public class HighthanAverage {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a,b,c,e;
		double d,x,y;
		a = sc.nextInt(); //총 개수
		ArrayList<Integer> ar = new ArrayList<Integer>(); //ArrayList 생성
		//평균을 구해
		//비교해서 갯수를 구해
		//퍼센트로 나타내
		for(int i=0 ; i<a ; i++){
			ar.clear();	//ArrayList 초기화
			c = 0; e = 0; //변수 초기화
			b = sc.nextInt(); //각 행의 개수
			for(int j=0 ; j<b ; j++){				
				ar.add(sc.nextInt()); //ArrayList 추가
				c += ar.get(j); //ArrayList 총합 구함					
			}		
			d = c/b; //ArrayList 평균 구함 (실수형)
			for(int k=0 ; k<b ; k++){
				if(ar.get(k)>d){			
				e++; //평균 넘는 사람 수 구함
				}
			}
			x = (double)e/b; //평균 넘는 사람 비율 구함
			y = x*100;
			if((y%1)<0.0005 || (y%1)>=0.9995){
				System.out.println(y+"00%");
			}
			else if((y%0.01)==0){
				System.out.println(y+"0%");
			}
			else if((y%0.001)>=0.0005){
				System.out.println(y-y%0.001+0.001+"%");				
			}
			else {
				System.out.println(y-y%0.001+"%");
			}
		}
	}
	
}
