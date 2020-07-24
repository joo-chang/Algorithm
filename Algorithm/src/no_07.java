import java.util.Scanner;

// 입력된 수가 소수인지 판별

public class no_07 {
	public static void main(String[] args) {
		int num ; 
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		for(int i=2; i<num; i++) {
			if(num%i==0) {
				System.out.println(num+"은 소수가 아닙니다");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println(num+"은 소수 입니다");
		}
	}
}
