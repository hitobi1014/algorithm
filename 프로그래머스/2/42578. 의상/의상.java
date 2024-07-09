import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

		for (String[] clothe : clothes) {
			String key = clothe[1];
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }
        return answer - 1;
    }
}