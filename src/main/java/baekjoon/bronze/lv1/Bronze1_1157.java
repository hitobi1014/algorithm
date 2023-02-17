package baekjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Q.
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 *
 * Input.
 * 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 *
 * Output.
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 *
 * 예시입력        | 예시출력
 * Mississipi       ?
 *
 * 예시입력2       | 예시출력
 * zZa              Z
 */
public class Bronze1_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        int max = Integer.MIN_VALUE;
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            } else {
                map.put(x,1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if (max < entry.getValue()){
                answer = entry.getKey();
                max = entry.getValue();
            } else if (max == entry.getValue()){
                answer = '?';
                max = entry.getValue();
            }
        }
        System.out.println(answer);
    }
}
