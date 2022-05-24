package inflearn.section1;

import java.util.Scanner;

/**
 * 2022.05.25
 *
 * 설명 :
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 * 입력 :
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력 :
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 */
public class RemoveDupWord_0106 {

    public static void main(String[] args) {
        RemoveDupWord_0106 T = new RemoveDupWord_0106();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));
    }

    private String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) { // i번째 인덱스와 i번째 문자의 인덱스를 비교 ex) tteet 라고했을때 2번째 t의 i값은 1, indexOf의 값은 0 (첫번째나오는 문자의 위치를 찾기때문)
                answer += str.charAt(i);
            }
        }
        return answer;
    }
}
