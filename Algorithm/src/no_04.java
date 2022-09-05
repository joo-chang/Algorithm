import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

// 10진수를 2진수로 변환하시오

public class no_04 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		int i= 0;
//		int ten = sc.nextInt();
//
//		while(ten<2) {
//			if(ten%2==1) {
//				arr.add(1);
//			}else if(ten%2==0){
//				arr.add(0);
//			}else {
//				break;
//			}
//			ten /= 2;
//		}
//
//		for(Integer k : arr){//다음값이 있는지 체크
//		    System.out.println(k); //값 출력
//		}
//
		Scanner sc = new Scanner(System.in);

		int ten = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();

		while(ten>0){
			if(ten%2==1){
				arr.add(1);
			}else if(ten%2==0){
				arr.add(0);
			}else{
				break;
			}

			ten /= 2;
		}

		Collections.reverse(arr);

		for(Integer i : arr){
			System.out.print(i);
		}

	}
}


