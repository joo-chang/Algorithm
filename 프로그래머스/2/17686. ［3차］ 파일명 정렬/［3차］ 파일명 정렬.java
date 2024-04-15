import java.util.*;
class Solution {
    /*
    소요 시간 : 60분
    풀이 : head 찾기
    HEAD 정렬, NUMBER 정렬
    */
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, (o1, o2) -> {
            String[] arr1 = setFileName(o1);
            String[] arr2 = setFileName(o2);
            if(arr1[0].equals(arr2[0])){
                return Integer.parseInt(arr1[1]) - Integer.parseInt(arr2[1]);
            }else{
                return arr1[0].compareTo(arr2[0]);
            }
        });
        return files;
    }
    
    String[] setFileName(String file){
        String[] result = new String[3];
        boolean flag = false;
        for(int i = 0 ; i < file.length(); i++){
            if(Character.isDigit(file.charAt(i))){
                if(!flag){ // 처음으로 숫자가 나왔을 경우
                    result[0] = file.substring(0, i).toLowerCase();
                    flag = true;
                }
                if(i == file.length() - 1){
                    result[1] = ""+Integer.parseInt(file.substring(result[0].length()));
                    break;
                }
            }else if(!Character.isDigit(file.charAt(i)) && flag){ // TAIL 부분
                result[1] = ""+Integer.parseInt(file.substring(result[0].length(), i));
                break;
            }
        }
        return result;
    }
}