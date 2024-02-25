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
        // 3방향을 어떻게 판단할까 - 이전 depth 좌표값을 가져가서 이동하려는 위치랑 같으면(이동하기 전 좌표) 패스
        
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
    // 도중에 0이 나오면 다음 대기실로 이동해야하기 때문에 따로 뺐음
    // 그냥 solution단에서 break도 안되고 return도 안되는데 탈출할 방법이 있나?
    public int search(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(arr[i][j] == 'P'){
                    if(dfs(i, j, i, j, 1) == 0){
                        return 0;
                    }  
                }
            }
        }
        return 1;
    }
    
    // 4방향 탐색하고 그 위치에서 한번 더 탐색
    
    public int dfs(int sy, int sx, int y, int x, int depth){
        if(depth > 2) return 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(check(ny, nx) || selfCheck(sy, sx, ny, nx)) continue;
            if(arr[ny][nx] != 'X'){
                // 2 depth에서 true을 뱉어도 1depth가 계속 진행되기 때문에 dfs return 값이 참인지 체크해서 바로 빠져나가게 함
                if(arr[ny][nx] == 'P') return 0;
                if(dfs(y, x, ny, nx, depth+1) == 0) return 0;
            }
        }
        return 1;
    }
    
    public boolean check(int y, int x){
        return y < 0 || x < 0 || y >= arr.length || x >= arr[0].length;
    }
    
    public boolean selfCheck(int sy, int sx, int ny, int nx){
        return sy == ny && sx == nx;
    }
}