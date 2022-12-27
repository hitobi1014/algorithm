package again.ch01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Description
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 * Input
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * Output
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 */
public class Q2_caseConversion {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println(sb.toString());

        // 인프런 풀이
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));

    }

    /**
     * 인프런 풀이
     */
    public static String solution(String str) {
        String answer = "";

        // 일반 풀이
//        for (char x : str.toCharArray()) {
//            if (Character.isLowerCase(x)) answer += Character.toUpperCase(x);
//            else answer += Character.toLowerCase(x);
//        }

        // 아스키 풀이
        // 대문자 65~90 , 소문자 97 ~ 122 -> 둘의 차이는 32, 소문자-32 => 대문자
        for (char x : str.toCharArray()) {
            if (97<=x && x<=122) answer += (char)(x-32);
            else answer += (char)(x+32);
        }

        return answer;
    }

}
