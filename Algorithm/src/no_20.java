//100±îÁö 369°ÔÀÓ
public class no_20 {
	public static void main(String[] args) {
		for(int i = 1; i<=100; i++) {
			
			if(i/10==3 || i/10==6 || i/10==9) {
				if(i%10>0 &&i%3==0) {
					System.out.print("Â¦");
				}
				System.out.print("Â¦ ");	
			}else if(i%10==3 || i%10==6 || i%10==9) {
				System.out.print("Â¦ ");
			}else {
				System.out.print(i+" ");
			}
		}
	}
}
