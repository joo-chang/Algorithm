//�ֺ�� ���ϱ�
// ���� ���� ������ ���� ����ϼ���
import java.util.Scanner;

public class no_03 {

	public static void main(String[] args) {
		
		int[] num = new int[10];
		
		int[] count = new int[10];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i=0; i<10; i++) {
			count[num[i]]++;
		}
		

		
		int countNum = 0; // �ֺ��
		int countC = 0 ; //�ֺ���� ����Ƚ��
		
		for(int i =0; i<10; i++) {
			if(count[i]>countC) {
				countC = count[i];
				countNum = i;
			}
		}
		System.out.println("�ֺ�� :"+ countNum);
		System.out.println("�ֺ���� ���� Ƚ��:"+ countC);
	
		
	}
}

