import java.io.*;

class Main {


    // 1 = 1
    // 2 = 3
    // 3 = 5
    // 4 = 11
    // 5 = 21
    // 6 = 43
    // dp[n] = dp[n-1] + dp[n-2] * 2;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        System.out.println(dp(n));
    }

    static int dp(int n) {
        if (dp[n] != 0) {
            return dp[n] % 10007;
        }
        dp[n] = dp(n - 1) + dp(n - 2) * 2;
        return dp[n] % 10007;
    }


}


