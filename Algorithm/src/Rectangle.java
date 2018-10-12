import java.util.Scanner;
public class Rectangle {
	
	double area(double w,double h){
		return w*h;
	}
	double perimeter(double w, double h){
		return 2*(h+w);
	}
	
	
	
	
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
		double w,h;
		w = sc.nextDouble();
		h = sc.nextDouble();
		Rectangle rec = new Rectangle();
		rec.area(w, h);
		rec.perimeter(w, h);
		sc.close();
		
	}
}
