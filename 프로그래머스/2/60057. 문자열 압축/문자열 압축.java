class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1) return 1;
        // i 길이만큼 문자열 s를 자름 (절반만큼 잘랐을때 최대이므로 s.length()/2)
        for (int i = 1; i < s.length() / 2 + 1; i++){
            // 비교할 문자열
            String prev = s.substring(0, i);
            // 중복 문자열 개수
            int count = 1;
            // 새로 만들어질 문자열
            String newString = "";
            // 마지막 문자열
            String last = "";
            
            for (int j = i; j <= s.length(); j += i){
                // 문자 범위 벗어날 경우 남는 문자열을 끝에 붙여줌
                if(i + j > s.length()){
                    last = s.substring(j);
                    continue;
                }
                // 비교 문자열이랑 다음 문자열이랑 같으면 count 증가
                // (0, 3) (3, 6) / abc abc
                if(prev.equals(s.substring(j, j+i))){
                    count++;
                }else{
                    newString += prev;
                    if(count > 1){
                        newString = count + newString;
                    }
                    // 다음 문자열로 변경 (i 만큼)
                    prev = s.substring(j, j + i);
                    count = 1;
                }
            }
            newString += prev + last;
            if(count != 1){
                newString = count + newString;
            }
            answer = Math.min(answer, newString.length());
        }
        return answer;
    }
}