//피보나치 수열
//An = An-1 + An-2
public class no_02 {
	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		arr[0]= 1;
		arr[1] = 1;
		
		for(int i=2; i<10; i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		
		for(int ar :arr) {
			System.out.print(ar+" ");
		}
		
		
	}
}
