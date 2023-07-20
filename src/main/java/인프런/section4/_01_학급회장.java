package 인프런.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 설명
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
 * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
 *
 * 입력
 * 첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
 * 두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
 *
 * 출력
 * 학급 회장으로 선택된 기호를 출력합니다.
 *
 * 예시 입력 1
 * 15
 * BACBACCACCBDEDE
 *
 * 예시 출력
 * C
 */
public class _01_학급회장 {
    public static void main(String[] args) throws IOException {
        _01_학급회장 T = new _01_학급회장();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(T.solve(str));
    }

    // Map => getOrDefault 사용
    // 찾는 값이 없을때 기본값으로 설정
    public char infSolve(String str) {
        char answer = ' ';

        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public char solve(String str) {
        char answer = ' ';
        Map<Character, Integer> map = new HashMap();

        for (char x : str.toCharArray()) {
            if (map.containsKey(x)) {
                int num = map.get(x);
                map.put(x, ++num);
            } else {
                map.put(x, 1);
            }
        }
        int max = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                answer = entry.getKey();
                max = entry.getValue();
            }
        }

        return answer;
    }
}
