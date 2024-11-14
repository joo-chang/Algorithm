import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            TreeMap<Integer, Integer> queue = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                String[] arr = bf.readLine().split(" ");
                if (arr[0].equals("I")) {
                    queue.put(Integer.parseInt(arr[1]), queue.getOrDefault(Integer.parseInt(arr[1]), 0) + 1);
                } else {
                    if (queue.isEmpty()) continue;
                    Integer num = Integer.parseInt(arr[1]) == 1 ? queue.lastKey() : queue.firstKey();
                    if (queue.put(num, queue.get(num) - 1) == 1) {
                        queue.remove(num);
                    }
                }
            }
            if (queue.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(queue.lastKey()).append(" ").append(queue.firstKey()).append("\n");
            }

        }
        System.out.println(sb);
    }


}


