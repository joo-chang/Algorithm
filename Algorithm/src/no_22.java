import java.util.Scanner;

//팰린드롬 판별  12321
public class no_22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int len = n.length();
		boolean flag = true;
		for(int i=0; i<len/2; i++) {
			if(n.charAt(i) != n.charAt(len-i-1)) {
				flag = false;
			}
		}
		System.out.println(flag);
	}
}
