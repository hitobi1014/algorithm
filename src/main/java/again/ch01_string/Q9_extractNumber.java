package again.ch01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Q.
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 * Input.
 * 첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * Output.
 * 첫 줄에 자연수를 출력합니다.
 *
 * 예시입력           예시출력
 * g0en2T0s8eSoft    208
 */
public class Q9_extractNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int answer = 0;
        int cnt = 0;

        for (int i = word.length() - 1; i >= 0; i--) {
            if (Character.isDigit(word.charAt(i))){
                answer += (int) (Character.getNumericValue(word.charAt(i)) * Math.pow(10, cnt));
                cnt++;
            }
        }

        System.out.println(answer);
    }
}
