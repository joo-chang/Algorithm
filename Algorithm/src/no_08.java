import java.util.Scanner;

// 입력된 수의 팩토리얼 구하기
public class no_08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int mul =1;
		for(int i=1 ; i <= num ; i++) {
			mul *= i;
		}
		System.out.println(mul);
	}
}
