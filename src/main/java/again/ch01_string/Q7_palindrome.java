package again.ch01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Q.
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 * Input.
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 * Output.
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *
 * 예시입력1
 * gooG
 *
 * 예시추력1
 * YES
 */
public class Q7_palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String compare = "";

        for (int i = str.length()-1; i >= 0; i--) {
            compare += str.charAt(i);
        }

        System.out.printf("compare : %s    str : %s",compare, str);

        if (str.toUpperCase().equals(compare.toUpperCase())){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
