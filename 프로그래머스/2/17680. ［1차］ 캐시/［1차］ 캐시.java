import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> dq = new LinkedList<>();
        
        for (String str : cities){
            
            if (cacheSize == 0) {
                answer+=5;
                continue;
            }
            
            str = str.toUpperCase();
            // 현재 문자가 있으면 answer +1 
            // 기존 있는 문자 삭제 후 해당 문자 제일 앞으로
            if (dq.contains(str)) {
                answer+=1;
                dq.remove(str);
                dq.offerFirst(str);
            }
            // 없으면 answer +5
            // 제일 오래된 뒤 삭제 후 현재문자 맨 앞 추가
            else {
                answer += 5;
                if (dq.size() >= cacheSize) dq.pollLast(); 
                dq.offerFirst(str);
            }
        }
        
        return answer;
    }
}