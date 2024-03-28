import java.util.*;
class Solution {

    public static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostS = new HashSet<>();
        Set<Integer> reserveS = new HashSet<>();

        for(int r : reserve){
            reserveS.add(r);    
        }
        for(int l : lost){
            if(reserveS.contains(l)){
                reserveS.remove(l);
            }else{
                lostS.add(l);    
            }
        }
        
        for(Integer r : reserveS){
            if(lostS.contains(r - 1)){
                lostS.remove(r - 1);
            }else if(lostS.contains(r + 1)){
                lostS.remove(r + 1);
            }
        }
        return n - lostS.size();
    }
    
}