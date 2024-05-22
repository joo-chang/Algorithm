import java.util.*;
class Solution {
    /*
    소요 시간 : 24/05/22 120분
    풀이 : 시작 시간 기준으로 정렬. 종료 시간 + 10
    리스트를 만들어서 종료 시간을 저장. 만약 시작 시간보다 종료 시간이 크면 리스트를 새로 만든다.
    List를 반복문 돌면서 시작 시간이 더크면 종료 시간 저장하고 탈출
    */
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] books = new int[book_time.length][2];
        for(int i = 0; i < books.length; i++){
            String[] st = book_time[i][0].split(":");
            String[] ed = book_time[i][1].split(":");
            books[i][0] = Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
            books[i][1] = Integer.parseInt(ed[0]) * 60 + Integer.parseInt(ed[1]) + 10;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(books, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        list.add(books[0][1]);
        for(int j = 1; j < books.length; j++){
            boolean flag = false;
            for(int i=0; i< list.size(); i++){
                
                if(list.get(i) <= books[j][0]){
                    list.set(i, books[j][1]);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                list.add(books[j][1]);
            }
        }
        
        return list.size();
    }
}