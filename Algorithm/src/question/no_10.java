package question;

import java.util.Scanner;

// �Էµ� �� ��ŭ n�� n�����·� �������� ��µǴ� ���� �簢��
public class no_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count =0; 
		int num = sc.nextInt();
		
		for(int i =0 ; i<num; i++) {
			for(int j=0; j<num; j++) {
				count +=1 ;
				if(count<10) {
					System.out.print(count+"  ");
				}
				else {
					System.out.print(count+" ");
				}
			}
			System.out.println();
		}
	}
}
