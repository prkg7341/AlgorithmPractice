package If;
import java.util.Scanner;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		double d;
		a = sc.nextInt();
		b = sc.nextInt();
		d = b;
		if(a==1) System.out.println(100);
		else{
			for(int i=0 ; i<a-1 ; i++){
				c = sc.nextInt();
				d += c;
				if(c>b){
					b = c;
				}				
			}
			System.out.println(d/b*100/a);
		}
	}
}
