import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1}; 
    int[] dy = {1, 0, -1, 0};
    boolean[][] visited;
    int xl;
    int yl;
    public int solution(int[][] maps) {
        yl = maps.length;
        xl = maps[0].length;
        visited = new boolean[yl][xl];
        bfs(0, 0, maps);
        if(maps[yl - 1][xl - 1] == 1){
            return -1;
        }
        return maps[yl - 1][xl - 1];
    }

    public void bfs(int y, int x, int[][] map){
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{y, x});
        
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int ny = loc[0] + dy[i];
                int nx = loc[1] + dx[i];
                
                if(check(ny, nx) || map[ny][nx] == 0) continue;
                if(map[ny][nx] == 1 && !visited[ny][nx]){
                    queue.add(new int[]{ny, nx});
                    map[ny][nx] = map[loc[0]][loc[1]] + 1;
                }
            }
        }
    }
    
    public boolean check(int y, int x){
        return y < 0 || x < 0 || y >= yl || x >= xl;
    }
}