//최빈수 구하기
// 가장 많이 출현한 수를 출력하세요
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
		

		
		int countNum = 0; // 최빈수
		int countC = 0 ; //최빈수가 나온횟수
		
		for(int i =0; i<10; i++) {
			if(count[i]>countC) {
				countC = count[i];
				countNum = i;
			}
		}
		System.out.println("최빈수 :"+ countNum);
		System.out.println("최빈수가 나온 횟수:"+ countC);
	
		
	}
}

