import java.util.Scanner;
public class Sum {
	public static void main(String args[]){	
		Scanner sc = new Scanner(System.in);
		int a,c;
		double b;
		a = sc.nextInt();
		b = sc.nextDouble();
		c = 0;
		for( ; a>0 ; a--){
			c += (int)(b/Math.pow(10, a-1));
			b %= Math.pow(10, a-1);
			System.out.print(b); 		//확인용
			System.out.println("  "+c); //확인용
		}
		System.out.println((int)c);
		
	}
}