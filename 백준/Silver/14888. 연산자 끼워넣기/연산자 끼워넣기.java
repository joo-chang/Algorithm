import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static int[] calc = new int[4];
    static int max = -1000000000;
    static int min = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int depth) {
        if(depth == n){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (calc[i] > 0) {
                calc[i]--;
                if (i == 0) {
                    dfs(num + arr[depth], depth + 1);
                }else if (i == 1) {
                    dfs(num - arr[depth], depth + 1);
                }else if (i == 2) {
                    dfs(num * arr[depth], depth + 1);
                }else if (i == 3) {
                    dfs(num / arr[depth], depth + 1);
                }
                calc[i]++;
            }
        }
    }
}
