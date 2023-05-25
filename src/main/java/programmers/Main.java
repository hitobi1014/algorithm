package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] target = {"ABCD", "AABB"};

        Set<String> set = new HashSet<>(Arrays.asList(keymap));
        set.remove("");

        for (String str : set) {
            System.out.println(str);
        }

        System.out.println(set.toString());

//        System.out.println(Arrays.toString(solution(keymap, target)));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int count = 0;

            for (char x : targets[i].toCharArray()) {
                String ch = String.valueOf(x);
                int[] keyArr = new int[keymap.length];

                for (int j = 0; j < keymap.length; j++) {
                    keyArr[j] = keymap[j].indexOf(ch);
                }
                // 배열안에 있는 요소들 값이 -1이 아니면서 제일 작은값
                int min = keyArr[0] == -1 ? Integer.MAX_VALUE : keyArr[0] + 1;
                for (int k = 1; k < keyArr.length; k++) {
                    if (keyArr[k] != -1 && keyArr[k] < min) {
                        min = keyArr[k] + 1;
                    }
                }

                if (min == Integer.MAX_VALUE) {
                    count = -1;
                    break;
                } else {
                    count += min;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

}
