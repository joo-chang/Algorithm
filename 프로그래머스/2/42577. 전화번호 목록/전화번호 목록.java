import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        // 정렬을 하게되면 인접한 값이 가장 유사한 값이므로
        // 뒤에 값과 비교하면서 체크하면 됨
        Arrays.sort(phone_book);
        
        for(int i = 0 ; i < phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            };
        }
        return true;
    }
}