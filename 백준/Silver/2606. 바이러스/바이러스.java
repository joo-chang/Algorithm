import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        dfs(1);
        
        System.out.println(answer);
    }
    
    public static void dfs(int n){
        visited[n] = true;
        
        for(int num : list.get(n)){
            if(!visited[num]){
                answer++;
                dfs(num);
            }
        }
    }
}