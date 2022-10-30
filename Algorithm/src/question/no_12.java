package question;

import java.util.Scanner;
// ������ �� �������� ���� �簢��
public class no_12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count =1;
		int[][] arr = new int[a][a];
		
		for(int i=0; i<a; i++) {
			for(int j=0; j<a; j++) {
				arr[j][i] = count;
				count ++;
			}
		}
		
		for(int i=0; i<a; i++) {
			for(int j=0; j<a; j++) {
				System.out.printf("%4d",arr[i][j]);
			}
			System.out.println();
		}
	}
}
