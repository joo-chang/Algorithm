import java.util.Scanner;

// 입력된 수 만큼 n행 n열형태로 연속으로 출력되는 숫자 사각형
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
