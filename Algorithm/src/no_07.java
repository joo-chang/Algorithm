import java.util.Scanner;

// �Էµ� ���� �Ҽ����� �Ǻ�

public class no_07 {
	public static void main(String[] args) {
		int num ; 
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		for(int i=2; i<num; i++) {
			if(num%i==0) {
				System.out.println(num+"�� �Ҽ��� �ƴմϴ�");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println(num+"�� �Ҽ� �Դϴ�");
		}
	}
}
