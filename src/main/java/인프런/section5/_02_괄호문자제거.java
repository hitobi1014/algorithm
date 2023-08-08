package 인프런.section5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _02_괄호문자제거 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
//        System.out.println(solution(str));
        System.out.println(infSolution(str));
    }

    static String infSolution(String string) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char x : string.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(') {}
            } else {
                stack.push(x);
            }
        }
        for (char x : stack) answer.append(x);

        return answer.toString();
    }

    static String solution(String str){
        StringBuilder sb = new StringBuilder();
        int cnt=0;

        for (char x : str.toCharArray()) {
            if (x == '(') {
                cnt++;
                continue;
            } else if (x == ')') {
                cnt--;
                continue;
            }

            if (cnt == 0) {
                sb.append(x);
            }
        }
        return sb.toString();
    }
}
