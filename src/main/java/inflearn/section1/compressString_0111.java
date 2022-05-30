package src.main.java.inflearn.section1;

import java.util.Scanner;

/**
 * 설명
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 줄에 압축된 문자열을 출력한다.
 *
 * 예시입력 KKHSSSSSSSE
 * 예시출력 K2HS7E
 */
public class compressString_0111 {
    public static void main(String[] args) {
        compressString_0111 T = new compressString_0111();
        Scanner sc = new Scanner(System.in);

        String inputStr = sc.next();
        System.out.println(T.solution(inputStr));
    }

    public String solution(String str) {
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((i + 1) == str.length()) {
                sb.append(str.charAt(i));
                if (cnt != 1){
                    sb.append(cnt);
                }
                break;
            }
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
                continue;
            } else {
                if (cnt == 1) {
                    sb.append(str.charAt(i));
                } else {
                    sb.append(str.charAt(i));
                    sb.append(cnt);
                    cnt = 1;
                }
            }
        }
        return sb.toString();
    }
}
