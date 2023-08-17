package test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class 백준 {


    private static int n, pow;
    private static int[] num = {2, 3, 5, 7};
    private static String[] n1 = {"1", "3", "7", "9"};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        find();
//        System.out.println(sb.toString());
    }

    private static boolean find() {
        // (1) 맨 앞자리가 2,3,5,7로 시작하는애들
        // (2) 짝수, 5,7 배수 제외하기
        // (3) 끝자리가 1,3,7,9 얘네인애들
        int pow = 4; // 임시 자리수
        ArrayList<String> listA = new ArrayList<>();
        listA.add("2");
        listA.add("3");
        listA.add("5");
        listA.add("7");
        ArrayList<String> listB;

        for (int k = 0; k < n-1; k++) {
            listB = new ArrayList<>();

            for (int i = 0; i < listA.size(); i++) {
                String n = listA.get(i);

                for (int j = 0; j < n1.length; j++) {
                    String str2 = n + n1[j];
                    if (isPrime(Integer.valueOf(str2))) {
                        listB.add(str2);
                    }
                }

            }
            listA = listB;
        }

        listA.forEach(System.out::println);

        return false;
    }

    private static boolean isPrime(int n) {
        for (int i = 3; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }

}
