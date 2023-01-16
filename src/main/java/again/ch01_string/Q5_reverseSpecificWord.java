package again.ch01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 설명
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 * 예시 입력 1
 * a#b!GE*T@S
 *
 * 예시 출력 1
 * S#T!EG*b@a
 */
public class Q5_reverseSpecificWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        char[] x = word.toCharArray();
        int lt=0, rt=word.length()-1;

        while (lt < rt) {
            if(Character.isLetter(x[lt]) && Character.isLetter(x[rt])){
                char tmp = x[lt];
                x[lt] = x[rt];
                x[rt] = tmp;
                lt++;
                rt--;
            } else if (Character.isLetter(x[lt])) {
                rt--;
            } else {
                lt++;
            }
        }
        System.out.println(String.valueOf(x));

        // 인프런풀이
        Q5_reverseSpecificWord q5 = new Q5_reverseSpecificWord();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        q5.solution(str);

    }

    // 인프런 풀이
    public String solution(String str) {
        String answer = "";
        return answer;
    }

}
