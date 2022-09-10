package dynamic_programming;

import java.util.Scanner;

/** 1로 만들기
 * 정수 X가 주어졌을 때, 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지이다.
 * 1. X가 5로 나누어 떨어지면, 5로 나눈다.
 * 2. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 3. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 4. X에서 1을 뺀다.
 *
 * 정수 X 가 주어졌을 때, 연산 4개를 적절히 사용해서 값을 1로 만들고자 한다. 연산을 사용하는 최소 횟수를 출력
 *
 * 입력:
 * 첫째 줄에 정수 X가 주어진다.
 * 출력:
 * 첫째 줄에 연산을 하는 횟수의 최소값을 출력한다.
 *
 * 최적 부분 구조, 중복되는 부분 문제를 만족한다.
 *
 */
public class make1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] d = new int[30001];

        for (int i = 2; i < d.length; i++) {
            d[i] = d[i-1] + 1;

            if (i % 2 == 0){
                d[i] = Math.min(d[i], d[i/2] + 1);
            }
            if (i % 3 == 0){
                d[i] = Math.min(d[i], d[i/3] + 1);
            }
            if (i % 5 == 0){
                d[i] = Math.min(d[i], d[i/5] + 1);
            }
        }

        System.out.println(d[num]);
    }
}
