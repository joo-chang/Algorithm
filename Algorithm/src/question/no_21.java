package question;

import java.util.Scanner;

//1~100���� ���ڰ� �ԷµǾ��� �� �ߺ� ���� �� ���
public class no_21 {
	public static void main(String[] args) {
		int[] n = new int[10];
		int[] count = new int[100];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			n[i] = sc.nextInt();
		}
		for(int i=0; i<count.length; i++) {
			for(int j=0; j<n.length; j++) {
				if(i==n[j]) {
					count[i]=n[j];
				}
			}
		}
		
		for(int i=0; i<count.length; i++) {
			if(count[i]==0) {
				continue;
			}else {
				System.out.printf("%d ",count[i]);
			}
		}
	}
}
