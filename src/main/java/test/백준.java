package test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스택 구현
 * https://www.acmicpc.net/problem/10828
 */
public class 백준 {
    private static int[] stack;
    private static int initSize;
    private static int size;


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\00.project\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        initSize = 10;
        stack = new int[initSize];

        int cmdCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cmdCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    answer.append(pop()).append('\n');
                    break;
                case "size":
                    answer.append(size()).append('\n');
                    break;
                case "empty":
                    answer.append(empty()).append('\n');
                    break;
                case "top":
                    answer.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(answer.toString());
    }

    private static void push(int x) {
        // 현재 배열의 원소개수가 할당된 사이즈랑 같으면 크기 늘려서 배열 복사
        if (size() == initSize){
            int[] temp = Arrays.copyOf(stack, initSize *= 2);
            stack = temp.clone();
        }
        stack[size++] = x;
    }

    private static int pop() {
        if (empty() == 1) return -1;
        int num = stack[size-1];
        stack[size--] = 0;

        return num;
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        return size == 0 ? 1 : 0;
    }

    private static int top() {
        if (empty() == 1) return -1;
        return stack[size -1];
    }

}
