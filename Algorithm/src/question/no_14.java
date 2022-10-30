package question;

import java.util.Scanner;

public class no_14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int[] arr = new int[10];
		int count;
		
		while(num>0) {
		
			count = num%10;
			num /= 10;
			arr[count]++;
			
		}
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println(i+": "+arr[i]);
		}
	}
}
