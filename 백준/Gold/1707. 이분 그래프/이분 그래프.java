import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    static int[] arr;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            visited = new boolean[v + 1];
            arr = new int[v + 1];
            for (int j = 0; j <= v; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }
            for (int j = 1; j <= v; j++) {
                if (visited[j]) continue;
                arr[j] = 1;
                dfs(j);
            }

            if (flag) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

            flag = true;
        }
        System.out.println(sb);
    }

    private static void dfs(int i) {
        visited[i] = true;

        for (int n : list.get(i)) {
            if (!visited[n]) {
                arr[n] = arr[i] * -1;
                dfs(n);
            }else if(arr[n] == arr[i]){
                flag = false;
            }
        }
    }
}
