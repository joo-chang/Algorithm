class Solution {
    static int y, x;
    static int my, mx;
    static char[][] parks;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        my = park.length;
        mx = park[0].length();
        
        // char array 변환
        parks = new char[my][mx];
        for(int i = 0; i < my; i++){
            parks[i] = park[i].toCharArray();
        }
        
        // 시작점 체크
        for(int i = 0; i < my; i++){
            for(int j = 0; j < mx; j++){
                if(parks[i][j] == 'S') {
                    y = i;
                    x = j;
                }
            }
        }
        
        // routes 돌면서 이동 가능 여부 확인 후 이동
        for(String route : routes){
            String[] r = route.split(" ");
            area(r);
        }
        return new int[]{y, x};
    }
    
    public void area(String[] route){
        int num = Integer.parseInt(route[1]);
        // 한 칸씩 이동하면서 가능한지 확인
        for(int i = 1; i <= num; i++){
            int ny = y;
            int nx = x;
            if(route[0].equals("E")){
                nx += i;
            }else if(route[0].equals("W")){
                nx -= i;
            }else if(route[0].equals("N")){
                ny -= i;
            }else if(route[0].equals("S")){
                ny += i;
            }
            
            // 불가능하면 return
            if(check(ny, nx)) return;
            if(parks[ny][nx] == 'X') return;
        }
        
        // 가능하면 이동
        if(route[0].equals("E")){
            x += num;
        }else if(route[0].equals("W")){
            x -= num;
        }else if(route[0].equals("N")){
            y -= num;
        }else if(route[0].equals("S")){
            y += num;
        }
    }
    
    public boolean check(int y, int x){
        return y < 0 || x < 0 || y >= my || x >= mx;
    }
}