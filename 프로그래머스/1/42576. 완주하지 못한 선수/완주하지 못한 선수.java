import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> remain = new HashMap<>();
        for (String s : participant) {
            remain.put(s, remain.getOrDefault(s, 0) + 1);
        }

        for (String c : completion) {
            remain.put(c, remain.get(c) - 1);
        }

        for ( Map.Entry<String, Integer> me : remain.entrySet()) {
            if (me.getValue() == 1) {
                answer = me.getKey();
                break;
            }
        }

        return answer;
    }
}