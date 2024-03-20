import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            System.out.println(dp(n));
        }
    }

    static int dp(int n){
        if (n < 0) return 0;
        if (n == 0) return 1;
        return dp(n - 1) + dp(n - 2) + dp(n - 3);
    }
}