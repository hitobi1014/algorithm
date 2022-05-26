package inflearn.section1;

import java.util.*;

/**
 * 2022.05.27
 *
 * 설명
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 * 예시입력 : teachermode e     | 예시출력  : 1 0 1 2 1 0 1 2 2 1 0
 */
public class TextDistance_0110 {
    public static void main(String[] args) {
        TextDistance_0110 T = new TextDistance_0110();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char t = sc.next().charAt(0);
//        System.out.println(T.solution(s, t));
        for (int x : T.solution2(s, t)) {
            System.out.print(x + " ");
        }
    }


    // ## 다른 풀이 방법1 ##
    // 왼쪽부터 한번 스캔후 오른쪽 스캔
    public int[] solution2(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p ++;
                answer[i] = p;
            }
        }
        p=1000;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

//    public String solution(String s, String t) {
//        String answer = "";
//        // ex) teachermode e 가 들어가면
//        for (int i = 0; i < s.length(); i++) {
//            List<Integer> temp = new ArrayList<>();
//            List<Integer> numList = new ArrayList<>();
//            temp.clear();
//            numList.clear();
//            int index = s.indexOf(t);
//
//            while (index != -1) {
//                temp.add(index);
//                int st = Math.abs(s.indexOf(i) - index); // 찾는문자와 현재문자사이 거리 구하기
//                numList.add(st); // 위치값 저장
//                index = s.indexOf(t, index + t.length());
//            }
//            answer += Collections.min(numList) + " ";
//        }
//        return answer;
//    }
}
