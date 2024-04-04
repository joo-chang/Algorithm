import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1}; 
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        bfs(0,0, maps);
        return maps[maps.length-1][maps[0].length-1] > 1 ? maps[maps.length-1][maps[0].length-1] : -1;
    }
    
    void bfs(int y, int x, int[][] maps){
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[] {y, x});
        visited[y][x] = true;
        
        while(!queue.isEmpty()){
            int[] n = queue.poll();
            for(int i = 0; i< 4; i++){
                int ny = n[0] + dy[i];
                int nx = n[1] + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length) continue;
                
                if(maps[ny][nx] != 0 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    maps[ny][nx] = maps[n[0]][n[1]] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
        
    }
    // void bfs(int i, int j, int[][] maps){
    //     Queue<int[]> queue = new LinkedList<>();
    //     queue.add(new int[] {i,j});
    //     visited[i][j] = true;
    //     while(!queue.isEmpty()){
    //         int now[] = queue.poll();
    //         for(int k = 0; k < 4; k++){
    //             int x = now[0] + dx[k];
    //             int y = now[1] + dy[k];
    //             if(x >= 0 && y >= 0 && x < maps.length && y < maps[0].length){
    //                 if(maps[x][y] !=0 && !visited[x][y]){
    //                     visited[x][y] = true;
    //                     maps[x][y] = maps[now[0]][now[1]] + 1;
    //                     queue.add(new int[] {x, y});
    //                 }
    //             }
    //         }
    //     }
    // }

}