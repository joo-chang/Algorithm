import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static String answer = "sad";
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int store = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            int[] start = new int[2];
            int[] end = new int[2];
            int[][] storeLoc = new int[store][2];
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < store; j++) {
                st = new StringTokenizer(bf.readLine());
                storeLoc[j][0] = Integer.parseInt(st.nextToken());
                storeLoc[j][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            bfs(start, end, storeLoc);
            System.out.println(answer);
            answer = "sad";
        }


    }

    private static void bfs(int[] start, int[] end, int[][] storeLoc) {
        boolean[] visited = new boolean[storeLoc.length];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (Math.abs(now[0] - end[0]) + Math.abs(now[1] - end[1]) <= 1000) {
                answer = "happy";
                return;
            }
            for (int i = 0; i < storeLoc.length; i++){
                if (!visited[i] && Math.abs(now[0] - storeLoc[i][0]) + Math.abs(now[1] - storeLoc[i][1]) <= 1000) {
                    visited[i] = true;
                    q.add(storeLoc[i]);
                }
            }
        }
    }


}
