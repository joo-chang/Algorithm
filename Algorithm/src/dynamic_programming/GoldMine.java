package dynamic_programming;

import java.util.Scanner;

/** 금광
 * n x m 크기의 금광이 있다. 금광은 1 x 1 크기의 칸으로 나누어져 있으며,
 * 각 칸은 특정한 크기의 금이 들어 있다.
 * 채굴자는 첫 번째 열부터 출발하여 금을 캐기 시작한다. 맨 처음에는 첫 번째 열의 어느 행에서든 출발할 수 있다.
 * 이후에 m - 1 번에 걸쳐서 매번 오른쪽 위, 오른쪽, 오른쪽 아래 3가지 중 하나의 위치로 이동해야 한다.
 * 결과적으로 채굴자가 얻을 수 있는 금의 최대 크기를 출력하세요.
 *
 * 입력:
 * 첫째 줄에 테스트 케이스 T가 입력된다. (1 <= T <= 1000)
 * 매 테스트 케이스 첫째 줄에 n과 m 이 공백으로 구분되어 입력된다. (1 <= n, m <= 20)
 * 둘째 줄에 n x m 개의 위치에 매장된 금의 개수가ㅋ 공백으로 구분되어 입력된다.
 *
 * 출력:
 * 테스트 케이스마다 채굴자가 얻을 수 있는 금의 최대 크기를 출력한다.
 * 각 테스트 케이스는 줄 바꿈을 이용해 구분한다.
 * */
public class GoldMine {

    static int testCase, n, m;
    static int[][] arr = new int[20][20];
    static int[][] dp = new int[20][20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();

        for (int tc = 0; tc < testCase; tc++){
            n = sc.nextInt();
            m = sc.nextInt();

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    dp[i][j] = arr[i][j];
                }
            }

            for (int j = 1; j < m; j++){
                for (int i = 0; i < n; i++){
                    int leftUp, left, leftDown;

                    if (i == 0) leftUp = 0;
                    else leftUp = dp[i - 1][j - 1];

                    if (i == n - 1) leftDown = 0;
                    else leftDown = dp[i + 1][j - 1];

                    left = dp[i][j - 1];
                    dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown));
                }
            }
            int result = 0;
            for (int i = 0; i < n; i++){
                result = Math.max(result, dp[i][m - 1]);
            }
            System.out.println(result);
        }
    }
}
