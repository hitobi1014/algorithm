import java.io.*;
import java.util.*;

/**
 * 문자열 폭발
 */
public class Main {

    static Stack<Character> stack;
    public static void main(String[] args) throws Exception{
        /**
         * 문자열 -> 문자 stack 넣고
         * 문자 stack길이가 폭발문자열보다 크거나 같으면 비교해서
         * 해당 위치 pop
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String originStr = br.readLine();
        int strLen = originStr.length();
        String explosion = br.readLine();
        int exLen = explosion.length();

        // 문자열 -> stack
        stack = new Stack<>();
        for (int i = 0; i < strLen; i++) {
            int cnt = 0;
            stack.push(originStr.charAt(i));

            if (stack.size() >= exLen) {
                for (int j =0; j < exLen; j++) {
                    int curIdx = stack.size()-exLen+j;
                    if (stack.get(curIdx) == explosion.charAt(j)) {
                        cnt++;
                    }
                }

                // 폭발물이랑 일치하면 pop
                if (cnt == exLen) {
                    for (int j = 0; j < cnt; j++) stack.pop();
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        if (stack.isEmpty()) {
            answer.append("FRULA");
        } else {
            for (int i = 0; i < stack.size(); i++) {
                answer.append(stack.get(i));
            }
        }
        System.out.println(answer.toString());

    }
}