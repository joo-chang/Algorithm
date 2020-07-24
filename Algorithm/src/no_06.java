//*
// 최대공약수 구하기
public class no_06 {
	public static void main(String[] args) {
		int num1, num2;
		
		num1 = 60;
		num2 = 30;
		
		int big, small;
		
		if(num1>num2) {
			big = num1;
			small = num2;
		}
		else {
			big = num2;
			small = num1;
		}
		
		int gcd = 1;
		
		for(int i=1 ; i<=small; i++) {
			if(big%i==0 && small%i==0) {
				gcd = i;
			}
		}
		System.out.println("최대 공약수 :"+gcd);
		
	}
}
