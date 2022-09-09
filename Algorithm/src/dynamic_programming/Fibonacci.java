package dynamic_programming;

public class Fibonacci {

    public static long[] d = new long[100];

    public static void main(String[] args) {

        //첫 번째 피보나치 수와 두 번째 피보나치 수
        d[1] = 1;
        d[2] = 1;

        int n = 50;

        // 피보나치 함수. 반복문으로 구현 (바텀업 다이나믹 프로그래밍)
        for (int i = 3; i <= n; i++){
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);
    }


}
