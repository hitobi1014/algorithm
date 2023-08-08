package 인프런.section5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _01_올바른괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

    static String solution(String str){
        String answer = "NO";
        Stack<Character> stack = new Stack<>();
        if (str.charAt(0) == ')') return "NO";

        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
                continue;
            }
            if (x == ')'){
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    return "NO";
                }
            }

        }

        answer = stack.isEmpty() ? "YES" : answer;
        return answer;
    }
}
