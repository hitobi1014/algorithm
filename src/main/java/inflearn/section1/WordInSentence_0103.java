package inflearn.section1;

import java.util.Scanner;

/**
 * 2022.05.23
 *
 * 설명 :
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 *
 * 입력 :
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력 :
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
 * 단어를 답으로 합니다.
 */
public class WordInSentence_0103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordInSentence_0103 T = new WordInSentence_0103();

        // 입력 받을 문자열
        String inputStr = sc.nextLine();
        String ret = T.solution(inputStr);
//        String ret2 = T.inflearn(inputStr);
        System.out.println(ret);
//        System.out.println(ret2);
    }

    public String solution(String inputStr){
        String ret = "";
        String strArr[] = null;
        // 문자열 가장 긴 단어 저장
        strArr = inputStr.split(" ");
        ret = strArr[0]; // 첫번째 단어 ret에 저장
        for (String str : strArr) {
            if (ret.length() < str.length()) { // ret에 저장된 단어보다 str의 단어길이가 더 길면 ret에 str을 저장한다.
                ret = str;
            }
        }

       return ret;
    }

//    private String inflearn(String str){
//        String answer = "";
//        int m = Integer.MIN_VALUE;
//        String[] s = str.split(" ");
//        for (String x : s){
//            int len = x.length();
//            if (len > m) {
//                m = len;
//                answer = x;
//            }
//        }
//
//        return answer;
//    }
}
