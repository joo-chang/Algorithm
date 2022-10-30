package greedy;

/** Youtube 동빈나
 *  2. 그리디 & 구현
 *  [문제] 거스름돈
 */

public class change {
    public static void main(String[] args){
        int n = 1260;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        for (int i = 0; i < 4; i++) {
            cnt += n / coinTypes[i];
            n %= coinTypes[i];
        }

        System.out.println(cnt);
    }
}
