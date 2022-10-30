package question;

import java.util.Scanner;

// n�� m�� ���
public class no_19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m, sum =1;
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1; i<=m; i++) {
			sum *= n;
		}
		System.out.println(sum);
	}
}
