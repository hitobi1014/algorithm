package baekjoon.bronze.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제
 * X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
 * 교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 입력은 총 28줄로 각 제출자(학생)의 출석번호 n(1 ≤ n ≤ 30)가 한 줄에 하나씩 주어진다. 출석번호에 중복은 없다.
 *
 * 출력
 * 출력은 2줄이다. 1번째 줄엔 제출하지 않은 학생의 출석번호 중 가장 작은 것을 출력하고, 2번째 줄에선 그 다음 출석번호를 출력한다.
 */
public class Bronze5_5597 {
    public static void main(String[] args) throws IOException {
        // 30명 중 2명이 과제 제출x 번호는 1~30번 .. 안낸사람 찾기
        // input : 28 line ,
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] student = new int[30];
        int[] subStudent = new int[28];

        // 총 학생
        for (int i = 0; i < 30; i++) {
            student[i] = i + 1;
        }

        // 제출 학생
        for (int j = 0; j < 28; j++) {
            int subStu = Integer.parseInt(br.readLine());

            for (int k = 0; k < 30; k++) {
                if (student[k] == subStu) {
                    student[k] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < 30; i++) {
            if (student[i] != 0) {
                sb.append(student[i]).append("\n");
            }
        }

        System.out.println(sb);

        // 아래는 다른 사람 풀이
        /**
         import java.io.BufferedReader;
         import java.io.IOException;
         import java.io.InputStreamReader;

         public class Main {

         public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         boolean arr[] = new boolean [30];

         for(int i = 0; i < 28; i++ ) {
         arr[Integer.parseInt(br.readLine()) - 1] = true;
         }

         for(int i = 0; i < 30; i++ ) {
         if(arr[i] == false) {
         System.out.println(i + 1);
         }
         }
         }
         }
         */
    }
}
