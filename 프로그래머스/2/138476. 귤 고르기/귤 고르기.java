import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum =0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int t : tangerine) {
			map.put(t, map.getOrDefault(t, 0) + 1);
		}
		List<Integer> count = new ArrayList(map.values());
		count.sort(Collections.reverseOrder());

		for (int c : count) {
			answer++;
			sum += c;
			if (sum >= k) {
				break;
			}
		};
        return answer;
    }
}