package FindRule;
import java.util.Scanner;
public class Calendar {
	public static void main(String args[]){	
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		a = sc.nextInt();
		b = sc.nextInt();
		for( ; a>1 ; a--){
			switch(a){
			case 1: break;
			case 3: b+=28; break;
			case 5:
			case 7:
			case 10:
			case 12: b+=30; break;	
			case 2: 
			case 4:
			case 6:
			case 8:
			case 9:
			case 11: b+=31; break;			
			}	
		}
		c = b%7;
		switch(c){
		case 0: System.out.println("SUN"); break;
		case 1: System.out.println("MON"); break;
		case 2: System.out.println("TUE"); break;
		case 3: System.out.println("WED"); break;
		case 4: System.out.println("THU"); break;
		case 5: System.out.println("FRI"); break;
		case 6: System.out.println("SAT"); break;
			}
		
	}
}
