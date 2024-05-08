import java.util.*;
class Solution {
    /* 
    소요 시간 : 90분
    풀이 : 왼쪽 밑, 오른쪽, 왼쪽 위 순서 반복
    n의 역순으로 개수가 줄어듦
    삼각형을 왼쪽으로 정렬하면 아래, 오른쪽, 왼쪽 위로 바꿀 수 있고, 
    dfs 수행 하는데, n을 가져가고 1개씩 줄어들고, 방향을 넘겨줌
    이런식으로 배열을 만들고 출력
    */
    /*
    00
    10 11
    20 21 22
    30 31 32 33
    40 41 42 43 44
    50 51 52 53 54 55
    */
    
    int[][] arr;
    int num;
    public Integer[] solution(int n) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        arr = new int[n][n];
        
        arr[0][0] = 1;
        for(int i = 0 ; i < n; i++){
            arr[i][0] = i + 1;
        }
        num = n;
        dfs(n - 1, n - 1, 0, 1);
        for(int[] ar : arr){
            for(int a : ar){
                if(a != 0) list.add(a);
            }
        }
        return list.stream().toArray(Integer[]::new);
    }
    
    void dfs(int n, int y, int x, int way){
        if(n == 0) return;
        if(way == 0) {
            down(n, y + 1, x);
            y += n;
            way++;
        }else if(way == 1){
            right(n, y, x + 1);
            x += n;
            way++;
        } else {
            up(n, y - 1, x - 1);
            y -= n;
            x -= n;
            way = 0;
        }
        
        dfs(n-1, y, x, way);
    }
    
    void down(int n, int y, int x){
        for(int i = 0; i < n; i++){
            num++;
            arr[y][x] = num;
            y++;
        }
    }
    void right(int n, int y, int x){
        for(int i = 0; i < n; i++){
            num++;
            arr[y][x] = num;
            x++;
        }
    }
    void up(int n, int y, int x){
        for(int i = 0; i < n; i++){
            num++;
            arr[y][x] = num;
            x--;
            y--;
        }
    }
}