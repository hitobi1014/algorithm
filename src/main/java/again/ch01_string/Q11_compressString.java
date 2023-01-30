package again.ch01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Q.
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 *
 * Input.
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * Output.
 * 첫 줄에 압축된 문자열을 출력한다.
 *
 * 예시입력        예시출력
 * KKHSSSSSSSE    K2HS7E
 */
public class Q11_compressString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        char prev = str.charAt(0);
        int cnt = 0;

        for (char x : str.toCharArray()) {
            if (prev == x) {
                cnt++;
            } else {
                sb.append(prev).append(cnt == 1?"":cnt);
                cnt = 1;
            }
            prev = x;
        }
        sb.append(prev).append(cnt == 1?"":cnt);
        System.out.println(sb.toString());
    }
}
