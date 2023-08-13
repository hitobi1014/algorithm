import java.io.*;
import java.util.Stack;

/**
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
public class Main {

    private static int[] inputArr;
    private static int[] answerArr;
    private static int arrLen;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrLen = Integer.parseInt(br.readLine());
        inputArr = new int[arrLen];
        answerArr = new int[arrLen];

        for (int i = 0; i < arrLen; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        if (makeStack()) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }

    }

    private static boolean makeStack() {
        /**
         * - num이 input배열의 현재 idx보다 작거나 같다면 num을 stack에 push
         * - input배열 현재 idx가 현재 stack peek와 같다면 pop
         * input배열의 i번째 idx보다 stack peek의 값이 작다면 그 값이 될때까지 push
         */

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        int idx = 0;

        while (idx < arrLen) {
            if (num <= inputArr[idx]) {
                stack.push(num);
                sb.append('+').append('\n');
                num++;
                continue;
            }

            if (inputArr[idx] == stack.peek()) {
                sb.append('-').append('\n');
                stack.pop();
                idx++;
            } else {
                return false;
            }
        }
        return true;
    }

}