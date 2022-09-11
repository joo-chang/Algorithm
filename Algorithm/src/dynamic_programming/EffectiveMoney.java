package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

/** 효율적인 화폐구성
 *
 * N가지 종류의 화폐가 있다. 이 화폐들의 개수를 최소한으로 이용해서 그 가치의 합이 M원이 되도록 하려고 한다.
 * 이때 각 종류의 화폐는 몇 개라도 사용할 수 있다.
 * M원을 만들기 위한 최소한의 화폐 개수를 출력하는 프로그램을 만들어라.
 *
 * 입력:
 * 첫째 줄에 N, M이 주어진다. (1 <= N <= 100, 1 <= M <= 10000)
 * 이후의 N개의 줄에는 각 화폐의 가치가 주어진다. 화폐의 가치는 10000보다 작거나 같은 자연수이다.
 * 출력:
 * 첫째 줄에 최소 화폐 개수를 출력한다.
 * 불가능할 때는 -1 출력한다.
 * */
public class EffectiveMoney {
    public static void main(String[] args) {
        /*
        Ai = 금액 i 를 만들 수 있는 최소한의 화폐 개수
        k = 각 화폐의 단위
        점화식 : 각 화폐 단위인 k를 하나씩 확인하며
            Ai-k 를 만드는 방법이 존재하는 경우, Ai = min(Ai, Ai-k + 1)
            Ai-k 를 만드는 방법이 존재하지 않는 경우, Ai = INF
         */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++){
                if (d[j - arr[i]] != 10001){
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1 );
                }
            }
        }

    }
}
