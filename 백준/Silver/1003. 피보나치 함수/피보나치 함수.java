import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        dp = new int[41][2];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            fibonacci(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

    static void fibonacci(int n) {
        // fibo(n) = fibo(n-1)에서 1와 0이 나올 개수 + fibo(n-2)에서 1와 0이 나올 개수
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            if (i >= n) break;
        }
    }

}