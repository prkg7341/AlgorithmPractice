import java.util.Scanner;
public class For {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		a = sc.nextInt();			
		b = 0;
		c = a;
		for(int i=0 ; i<a ; i++){
			for(int j=0 ; j<b ; j++){
				System.out.print(" ");
			}
			for(int k=0 ; k<c ; k++){
				System.out.print("*");
			}			
			System.out.println("");
			b++;
			c--;
		}
	}
}
