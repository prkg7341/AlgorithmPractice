import java.util.Scanner;

public class Shom {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n<=6){
			System.out.println((n-1)*1000+666);
			return;
		}
		
		int count = 6;
		int toGo = 6659;
		
		while(true){
			
			toGo++;
			if(String.valueOf(toGo).contains("666")){
				count++;
			}
			
			if(count==n) {
				System.out.println(toGo);
				break;
			}
		}
	}
}
