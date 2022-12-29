package again.ch01_string;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Description
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다
 *
 * Input
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 *
 * Output
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
 *
 * 예시 입력
 * it is time to study
 * 예시 출력
 * study
 */
public class Q3_wordSentence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sentenceArr = br.readLine().split(" ");
        String longSentence = sentenceArr[0];

        for (String str : sentenceArr) {
            if (longSentence.length() < str.length()) {
                longSentence = str;
            }
        }

        System.out.println(longSentence);

        // 인프런 풀이
        Scanner sc = new Scanner(System.in);
        String str2 = sc.nextLine();
        System.out.println(solution(str2));

    }

    /**
     * 인프런 풀이
     */
    public static String solution(String str){

        // #################### 풀이 1. ####################
//        String answer = "";
//        int m = Integer.MIN_VALUE; // 가장 작은 수
//        String[] s = str.split(" ");
//
//        for (String x : s) {
//            int len = x.length();
//            if (len > m) { // 가장 작은 수에서 비교,
//                m = len;
//                answer = x;
//            }
//        }
        // #################### 풀이 1. ####################ssssssssssss

        // #################### 풀이 2. ####################
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();

            if (len > m) {
                m = len;
                answer = tmp;
            }

            str = str.substring(pos+1);
        }

        if (str.length() > m) {
            answer = str;
        }
        // #################### 풀이 2. ####################

        return answer;
    }
}
