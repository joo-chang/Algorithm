class Solution {
    /*
    소요 시간 : 75분
    풀이 : 정사각형을 네 등분 해서 각각 dfs 수행
    한 칸까지 나눠진다면 탈출
    dfs 들어가면 모든 좌표 값이 같은지 체크
    같으면 개수 체크 후 탈출
    반복
    */
    int one, zero;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        one = 0;
        zero = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0) zero++;
                else one++;
            }
        }
        
        dfs(arr, 0, arr.length - 1, 0, arr[0].length - 1);
        return new int[]{zero, one};
    }
    
    void dfs(int[][] arr, int sy, int ey, int sx, int ex){
        if(ex - sx == 0 && ey - sy == 0) return;
        
        if(compress(arr, arr[sy][sx], sy, ey, sx, ex)) return;
        int len = (ey - sy) / 2 + 1;
        dfs(arr, sy, ey - len, sx, ex - len);
        dfs(arr, sy, ey - len, sx + len, ex);
        dfs(arr, sy + len, ey, sx, ex - len);
        dfs(arr, sy + len, ey, sx + len, ex);
    }
    
    boolean compress(int[][] arr, int num, int sy, int ey, int sx, int ex){
        for(int i = sy; i <= ey; i++){
            for(int j = sx; j <= ex; j++){
                if(arr[i][j] != num) return false;
            }
        }
        
        if(num == 0){
            zero -= Math.pow((ey - sy + 1), 2) - 1;
        } else{
            one -= Math.pow((ey - sy + 1), 2) - 1;

        }
        return true;
    }
}