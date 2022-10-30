package question;

// ��� ���� �л��� ����
public class no_24 {
	public static void main(String[] args) {
		int[] score = {100,95,90,80,70,60,50};
		int sum = 0;
		//���
		for(int i =0; i<score.length; i++) {
			sum += score[i];
		}
		int avg = sum/score.length;
		int count =0;
		
		for (int i = 0; i < score.length; i++) {
			if(avg<=score[i]) {
				count++;
			}
		}
		System.out.printf("%.4f",count/(float)score.length*100);
	}
}
