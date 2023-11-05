import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] map = number.toCharArray();
        
        int len = map.length - k;
        int start = 0; // 문자 비교 idx
        
        for (int i=0; i<len; i++){
            char max = '0';
            for (int j=start; j<=i+k; j++){
                if (map[j] > max) {
                    max = map[j];
                    start = j+1;
                }
            }
            // 각 자리수에 큰 값 넣기
            sb.append(Character.toString(max));
        }

        answer = sb.toString();
        return answer;
    }
}