package again.ch01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 설명
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 *
 * 예시 input
 * 3
 * good
 * Time
 * Big
 *
 * 예시 output
 * doog
 * emiT
 * giB
 */
public class Q4_reverseWord {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(br.readLine());
        String[] wordArr = new String[wordCount];

        for (int i = 0; i < wordArr.length; i++) {
            String temp = br.readLine();
            wordArr[i] = "";

            for (int j = temp.length() - 1; j >= 0; j--) {
                wordArr[i] += temp.charAt(j);
            }
            System.out.println(wordArr[i]);
        }

        // 인프런 풀이
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }
        for (String x : solution(n, str)) {
            System.out.println(x);
        }
    }

    /**
     * 인프런 풀이
     */
    public static ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        // 풀이1. StringBuilder reverse 메소드 사용
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        // 풀이2.index로 교환하기
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length()-1;

            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }
}
