import java.util.Scanner;
// 지그재그로 내려가는 숫자 사각형
public class no_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count =0; 
		int n = sc.nextInt();
		int[][] num = new int[n][n]; 
		
		for(int i=0 ; i<n; i++) {
			if(i%2==0) {
				for(int j=0; j<n; j++) {
					num[i][j] = i*n +j +1;
					System.out.printf("%4d",num[i][j]);
				}
			}else if(i%2==1){
				for(int j=n-1; j>=0; j--) {
					num[i][j] = i*n + j+1 ;
					System.out.printf("%4d",num[i][j]);
				}
			}

			System.out.println();
		}
		
	}
}
