package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 0;
        System.out.println(a/5);
    }

    public static int solution(int sugar) {
        int answer = 0;
//        int[] items = {3, 5};
        int remain = 0;

        remain = sugar % 5;
        if (remain == 0) {
            answer = sugar / 5;
        }
        if (remain != 0 && remain % 3 == 0) {
            answer += remain / 3;
        }

//        if (sugar % 5 == 0) {
//            remain = sugar % 5;
//            answer = sugar / 5;
//            if (remain % 3 == 0) {
//                answer += remain / 3;
//            }
//        }
//
//        while (sugar != 0) {
//            remain = sugar % 5;
//
//            if (remain % 3 == 0) {
//
//            }
//        }

        return answer;
    }
}
