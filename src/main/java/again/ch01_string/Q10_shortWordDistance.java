package again.ch01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Q.
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * Input.
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 *
 * Output.
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 * 예시입력              예시출력
 * teachermode e        1 0 1 2 1 0 1 2 2 1 0
 */
public class Q10_shortWordDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int min, start, end = 0;

        for (int i = 0; i < word[0].length(); i++) {
            start = word[0].indexOf(word[1].charAt(0), i) == -1 ? 999 : word[0].indexOf(word[1].charAt(0), i);
            end = word[0].lastIndexOf(word[1].charAt(0), i) == -1 ? 999 : word[0].lastIndexOf(word[1].charAt(0), i);

            sb.append(Math.min(Math.abs(start - i), Math.abs(end - i)) + " ");

        }
        System.out.println(sb.toString());
    }
}
