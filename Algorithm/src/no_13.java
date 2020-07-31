import java.util.Scanner;

public class no_13 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int[][] arr = new int[a][a];
		int count = 1;
		for(int i=0; i<a; i++) {
			for(int j=0; j<a; j++) {
				arr[i][j]=count*(j+1);
				System.out.printf("%4d",arr[i][j]);
			}
			System.out.println();
			count ++;
		}
		
		
	}
}
