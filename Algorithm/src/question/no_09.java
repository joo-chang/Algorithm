package question;

import java.util.Scanner;

// �Էµ� ���� �� �ڸ��� ���� ���Ͻÿ�
public class no_09 {
	public static void main(String[] args) {
		int num, sum=0;
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		while(num>0) {
			sum += num %10;
			num /= 10;
		}
		System.out.println(sum);
		
	}
}
