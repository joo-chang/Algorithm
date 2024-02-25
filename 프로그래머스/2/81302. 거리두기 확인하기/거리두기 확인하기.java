import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
                    //  D  R  U  L
    static char[][] arr;
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        // dfs 를 수행하는데, 
        // 4방향에서 x면 패스 / p면 1 return / 0이면 거기서 3방향 체크해서 p가 있는지 없는지 체크
        // 3방향을 어떻게 판단할까
        int index = 0;
        for(String[] place : places){
            arr = new char[5][5];
            
            for(int i = 0; i < place.length; i++){
                arr[i] = place[i].toCharArray();
            }
            answer[index] = search();
            index++;
        }
        
        return answer;
    }
    public int search(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(arr[i][j] == 'P'){
                    if(dfs(i, j, i, j, 0)){
                        return 0;
                    }  
                }
            }
        }
        return 1;
    }
    
    public boolean dfs(int sy, int sx, int y, int x, int depth){
        if(depth >= 2) return false;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(check(ny, nx) || selfCheck(sy, sx, ny, nx)) continue;
            if(arr[ny][nx] != 'X'){
                if(arr[ny][nx] == 'P') return true;
                if(dfs(y, x, ny, nx, depth+1)) return true;
            }
        }
        return false;
    }
    
    public boolean check(int y, int x){
        return y < 0 || x < 0 || y >= arr.length || x >= arr[0].length;
    }
    
    public boolean selfCheck(int sy, int sx, int ny, int nx){
        return sy == ny && sx == nx;
    }
}