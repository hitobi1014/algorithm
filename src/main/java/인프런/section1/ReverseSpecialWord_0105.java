package 인프런.section1;

import java.util.Scanner;

/**
 * 2022.05.24
 *
 * 설명 :
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 * 입력 :
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다
 *
 * 출력 :
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 */
public class ReverseSpecialWord_0105 {
    public static void main(String[] args) {
        ReverseSpecialWord_0105 T = new ReverseSpecialWord_0105();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));

    }

    public String solution(String str) {
        char[] c = str.toCharArray();
        int lt= 0, rt = str.length()-1;

        while (lt < rt) {
            char tmp = ' ';
            if (Character.isLetter(c[lt])) { // c[i]가 문자가 맞을경우 tmp = c[i]
                tmp = c[lt];
            } else {
                lt++;
                continue;
            }

            if (Character.isLetter(c[rt])) { // c[end-1]가 문자가 맞을경우 앞 문자와 뒤 문자 뒤집기
                c[lt] = c[rt];
                c[rt] = tmp;
            } else {
                rt--;
                continue;
            }
            lt++;
            rt--;
        }
        String ret = String.valueOf(c);

        // ### 다른풀이방법 ###
        /**
         * while(lt < rt) {
             * if (lt == 특수문자) {
             *    lt++;
             * } else if (rt == 특수문자) {
             *    rt--;
             * } else {
             *   tmp = c[lt];
             *   c[lt] = c[rt];
             *   c[rt] = tmp;
             * }
         * }
        */
        return ret;
    }
}
