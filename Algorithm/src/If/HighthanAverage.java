package If;
import java.util.ArrayList;
import java.util.Scanner;
public class HighthanAverage {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a,b,c,e;
		double d,x,y;
		a = sc.nextInt(); //�� ����
		ArrayList<Integer> ar = new ArrayList<Integer>(); //ArrayList ����
		//����� ����
		//���ؼ� ������ ����
		//�ۼ�Ʈ�� ��Ÿ��
		for(int i=0 ; i<a ; i++){
			ar.clear();	//ArrayList �ʱ�ȭ
			c = 0; e = 0; //���� �ʱ�ȭ
			b = sc.nextInt(); //�� ���� ����
			for(int j=0 ; j<b ; j++){				
				ar.add(sc.nextInt()); //ArrayList �߰�
				c += ar.get(j); //ArrayList ���� ����					
			}		
			d = c/b; //ArrayList ��� ���� (�Ǽ���)
			for(int k=0 ; k<b ; k++){
				if(ar.get(k)>d){			
				e++; //��� �Ѵ� ��� �� ����
				}
			}
			x = (double)e/b; //��� �Ѵ� ��� ���� ����
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
