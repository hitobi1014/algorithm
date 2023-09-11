import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//
class Solution {
    public int[] solution(String input) {
        int[] answer = {};
        Map<String, Integer> dictionary = new HashMap<>();
        int num = 1;

        // 전처리
        for (int i = 1; i <= 26; i++) {
            char x = (char) ('A' + i - 1);
            dictionary.put(String.valueOf(x), num++);
        }

        // STEP1 입력처리할 문자가 포함되어있으면 다음문자 붙여서 포함되어있는지 확인
        int lt = 0;
        String s = "";
        String add = "";
        ArrayList<Integer> intList = new ArrayList<>();

        while (true) {
            if (lt >= input.length()) break;
            if (lt == input.length() - 1) {
                String getS = String.valueOf(input.charAt(lt));
                intList.add(dictionary.get(getS));
                break;
            }
            s = String.valueOf(input.charAt(lt));
            String prev = "";

            while (true) {

                if (dictionary.containsKey(s)) {
                    prev = s;
                    lt++;
                    if (lt == input.length()) {
                        intList.add(dictionary.get(prev));
                        dictionary.put(s, num++);
                        break;
                    }
                    s += String.valueOf(input.charAt(lt));
                    continue;
                } else {
                    intList.add(dictionary.get(prev));
                    dictionary.put(s, num++);
                    break;
                }

            }
        }

        answer = new int[intList.size()];
        for (int i=0; i<intList.size();i++){
            answer[i] = intList.get(i);
        }
        
        return answer;
    }
}