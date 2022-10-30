package question;

//*
// ?????? ??? HelLoWorlD >> hELlOwORLd
public class no_05 {
	public static void main(String[] args) {
		
		String input = "HelLoWorlD";
		
		char[] arr ;
		arr = input.toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>='a' && arr[i] <='z' ) {
				arr[i] = (char)(arr[i] + ('A'-'a'));
			}else if(arr[i]>='A' && arr[i] <= 'Z'){
				arr[i] = (char)(arr[i] - ('A'-'a'));
			}
		}
		System.out.println(arr);
	}
}
