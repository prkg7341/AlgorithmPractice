import java.util.Scanner;

public class AplusB {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a,b,c,d;
		a = sc.nextInt();
		//a = 5*b + 3*c; ¾Æ´Ï¸é -1
		b = a/5;
		d = a%5;
		for(int i=0;i<1000;i++){
			if(b<0) {System.out.println(-1); break;}
			else{
					if(d%3==0) {
					c=d/3;
					System.out.println(b+c);
					break;
				}
				else{
					b--; d+=5;
				}
			}
		}
	}
}
