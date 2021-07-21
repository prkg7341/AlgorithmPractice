package NHNgodo;

public class NG1 {
	public int solution(int[] goods){

		int a,b,c;

		a = goods[0];
		b = goods[1];
		c = goods[2];

		int ret = 0;

		if(a>=50) {
			ret += a-10;
			if(b>=50) {
				ret += b-10;
				if(c>=50) {
					ret += c-10;
				}
				else {
					ret += c;
				}
			}
			else {
				if(b+c>=50) {
					ret += b+c-10;
				}
				else {
					ret += b+c;
				}
			}
		}

		else {
			if(b>=50) {
				ret += b-10;
				if(a+c>=50) {
					ret += a+c-10;
				}
				else {
					ret += a+c;
				}
			}
			else {
				if(c>=50) {
					ret += c-10;
					if(a+b>=50) {
						ret += a+b-10;
					}
					else {
						ret += a+b;
					}
				}
				else {
					if(a+b+c>=50) {
						ret += a+b+c-10;
					}
					else {
						ret += a+b+c;
					}
				}
			}
		}
		return ret;
	}
}
