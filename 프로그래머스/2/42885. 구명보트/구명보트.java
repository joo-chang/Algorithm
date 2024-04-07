import java.util.Arrays;

class Solution {
public static int solution(int[] people, int limit) {  
    int answer = 0;  
    Arrays.sort(people);  
 
    int first = 0, end = people.length - 1;  
  
    while (first <= end) {  
        if (people[first] + people[end] <= limit) {  
            first++;  
        }  
        answer++;  
        end--;   
    }  
    return answer;  
}
}