import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            visited = new boolean[n];
            if (n == 0) {
                return;
            }
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }    

            dfs(0, 0, "");
            System.out.println();
        }
    }
    static void dfs(int index, int depth, String lotto){
        if (depth == 6) {
            System.out.println(lotto);
            return;
        }
        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, lotto +arr[i] + " ");    
                visited[i] = false;
            }
        }
    }
}
