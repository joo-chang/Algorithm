import java.util.*;
class Solution {
    /*
    소요 시간 : 2시간
    풀이 : 해당 좌표를 기준으로 오른쪽, 아래, 대각선이 한 세트
    1. 모든 좌표에 4블록을 만들 수 없을 때까지 반복
    2. 2중 반복문 돌면서 4블록 만들 수 있는지 찾기
    3. visited 배열로 4블록 체크해서 한번에 지우기 0으로 변경
    4. 블럭 내리기 - 0 아닌 값들만 큐에 먼저 넣고, 남은 개수 0 넣기, 이후 큐에서 꺼내면서 판 세팅
    */
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean[][] visited;
        char[][] b = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                b[i][j] = board[i].charAt(j);
            }
        }
        while(true){
            visited = new boolean[m][n];
            boolean flag = false;
            // 4블록 모두 체크
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    if(b[i][j] != '0' &&
                       b[i][j] == b[i + 1][j] && 
                       b[i][j] == b[i][j + 1] &&
                       b[i][j] == b[i + 1][j + 1]){
                        visited[i][j] = true;
                        visited[i + 1][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            // 4블록이 없으면 종료
            if(!flag) break;
            
            // 4블록 지우기 - visited true를 0으로 치환
            for(int i = 0; i < m; i++){
                for(int j = 0 ; j < n; j++){
                    if(visited[i][j]){
                        b[i][j] = '0';
                    }
                }
            }
            // 블럭 내리기 - 0이 아닌 값들 리스트에 쌓고 0 따로 쌓아주기
            for(int j = 0; j < n; j++){
                Queue<Character> queue = new LinkedList<>();
                for(int i = m - 1 ; i >= 0; i--){
                    if(b[i][j] != '0'){
                        queue.add(b[i][j]);
                    }
                }
                if(m > queue.size()){
                    int temp = m - queue.size();
                    for(int i = 0; i < temp; i++){
                        queue.add('0');
                    }    
                }
                for(int i = m - 1; i >= 0; i--){
                    b[i][j] = queue.poll();
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(b[i][j] == '0'){
                    answer++;
                }
            }
        }
        return answer;
    }
}