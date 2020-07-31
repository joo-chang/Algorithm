import java.util.Scanner;
//구구단 s부터 f단 까지 입력 받아 출력
public class no_15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int f = sc.nextInt();
		
		for(int j=1; j<10; j++) {
			for(int i=s; i<=f; i++) {
				System.out.print(i+" * "+j+" = " + i*j+"\t");
			}
			System.out.println();
		}
	}
}
