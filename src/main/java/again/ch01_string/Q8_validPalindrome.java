package again.ch01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Q.
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * 알파벳 이외의 문자들의 무시합니다.
 *
 * Input.
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 * Output.
 * 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
 *
 * 예시입력
 * found7, time: study; Yduts; emit, 7Dnuof
 *
 * 예시출력
 * YES
 */
public class Q8_validPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        String answer = "YES";
        int startIndex = 0;
        int lastIndex = word.length()-1;

        while (startIndex<=lastIndex){
            if (!Character.isLetter(word.charAt(startIndex))){
                startIndex++;
                continue;
            } else if (!Character.isLetter(word.charAt(lastIndex))){
                lastIndex--;
                continue;
            } else if ( word.charAt(startIndex) != word.charAt(lastIndex)){
                answer = "NO";
                break;
            }
            startIndex++;
            lastIndex--;
        }
        System.out.println(answer);

    }
}
