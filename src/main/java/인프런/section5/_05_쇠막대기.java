package 인프런.section5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _05_쇠막대기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] pipe = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i=0; i<pipe.length;i++){
            if (pipe[i] == '('){
                stack.push(pipe[i]);
            } else {
                stack.pop();
                // 바로 앞이 닫는 괄호이면 레이저
                if (pipe[i - 1] == '(') {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
