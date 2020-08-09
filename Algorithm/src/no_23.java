//문자열 뒤집기
public class no_23 {
	public static void main(String[] args) {
		
		String n = "ADGHF";
		char str[] = n.toCharArray();
		char temp;
		
		int len = str.length;
		
		for(int i=0; i<len/2; i++) {
			temp = str[i];
			str[i] = str[len-i-1];
			str[len-i-1]= temp;
		}
		

		n = new String(str);
		System.out.println(n);
		
	}
}
