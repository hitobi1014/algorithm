import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int JA=0, JB=0;
        str1 = str1.toUpperCase(); str2 = str2.toUpperCase();
        ConcurrentHashMap<String,Integer> mapA = new ConcurrentHashMap<>();
        ConcurrentHashMap<String,Integer> mapB = new ConcurrentHashMap<>();

        findString(str1, mapA);
        findString(str2, mapB);
        // 교집합구하기
        for(Map.Entry<String,Integer> entry : mapA.entrySet()){
            String key = entry.getKey();
            if(mapB.containsKey(key)) {
                // 교집합이 있으면 둘 중 min값 비교해서 넣기
                JA += Math.min(mapB.get(key), entry.getValue());

                // 합집합 구하기
                JB += Math.max(mapB.get(key), entry.getValue());
                mapA.remove(key);
                mapB.remove(key);
            } else {
                // A집합의 남은 원소수 더하기
                JB += mapA.get(key);
            }
        }

        // 남은 B의 원소수만큼 더하기
        for (Map.Entry<String,Integer> entry : mapB.entrySet()) {
            JB += mapB.get(entry.getKey());
        }

        if (JA == 0 && JB ==0) {
            answer = 65536;
        } else {
            answer = (int) (((double) JA/JB)*65536);
        }
        return answer;
    }
    
    static void findString(String str, ConcurrentHashMap<String, Integer> map){
        for (int i = 1; i < str.length(); i++) {
            char prev = str.charAt(i-1);
            char cur = str.charAt(i);
            if (!Character.isLetter(prev) || !Character.isLetter(cur)) continue;
            String combineStr = Character.toString(prev) + cur;
            map.put(combineStr, map.getOrDefault(combineStr,0)+1);
        }
    }
}