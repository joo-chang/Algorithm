class Solution {
    // s 길이를 구하고, 0을 제거 후의 길이를 이진 변환 1보다 크면 count 증가
    // 제거한 0의 개수 구하기 - 이진수 길이에서 제거 후 길이를 뺀다.
    // 이진수 구하는 함수 - Integer.toBinaryString(n);
//     public int[] solution(String s) {
//         int[] answer = new int[2];
//         int sSize = s.length(); // s길이
//         int count = 0; // 횟수
//         int zeroSize = 0; // 제거한 0 개수
        
//         while(true){
//             if(s.equals("10")){
//                 zeroSize++;
//                 count++;
//                 break;
//             }else if(s.equals("1")){
//                 break;
//             }
//             s = s.replace("0", "");

//             zeroSize += sSize - s.length();

//             s = Integer.toBinaryString(s.length());
//             sSize = s.length();

//             count++;
            
//         }
//         answer[0] = count;        
//         answer[1] = zeroSize;
        
//         return answer;
//     }
    public int[] solution(String s) {
        int zero = 0;
        int total = 0;
        
        while(s.length() > 1){
            int size = s.length();
            s = s.replaceAll("0", "");
            
            zero += size - s.length();
            
            s = Integer.toBinaryString(s.length());
            total++;
        }
        
        return new int[]{total, zero};
    }
}
