import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    // D S L R 중 하나를 선택해서 A -> B 를 가기위한 최단 경로 구하기
    // D : n*2, S : n-1, L : 2341, R : 4123
    // bfs를 수행하면서 각 숫자가 갈 수 있는 경우의 수를 기록.
    // 이미 방문한 곳은 최단 경로 이므로 패스
    // 가장 먼저 B에 도착하면 종료
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];
            String ans = bfs(a, b, visited);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static String bfs(int a, int b, boolean[] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, ""));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int num = now.num;
            String str = now.instruction;
            for (Node node : new Node[]{
                new Node(d(num), str+"D"),
                new Node(s(num), str+"S"),
                new Node(l(num), str+"L"),
                new Node(r(num), str+"R")})
            {
                if (visited[node.num]) continue;
                if (node.num == b) {
                    return node.instruction;
                }
                queue.add(node);
                visited[node.num] = true;
            }
        }
        return null;
    }

    public static class Node {
        int num;
        String instruction;

        public Node(int num, String instruction) {
            this.num = num;
            this.instruction = instruction;
        }
    }

    public static int d(int n) {
        return (n * 2) % 10000;
    }
    public static int s(int n) {
        return n == 0 ? 9999 : n - 1;
    }

    public static int l(int n) {
        return (n % 1000) * 10 + (n / 1000);
    }

    public static int r(int n) {
        return (n % 10) * 1000 + (n / 10);
    }
}


