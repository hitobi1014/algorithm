package test;

import java.util.Scanner;

public class 백준 {

    private static int n, pow;
    private static boolean[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new boolean[(int) Math.pow(10,n)];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }

        for (int i = 2; i < arr.length; i++) {
            if(!arr[i]) continue;
            for (int j = 2*i; j < arr.length; j+=i) {
                arr[j] = false;
            }
        }

        System.out.println();
        pow = (int) Math.pow(10, n - 1);

        System.out.println();
    }

    private static boolean find(int z, int idx, int cnt) {

        for (int i = pow; i < arr.length; i++) {
            if(arr[i] && find(i/10, i)){
                if ((int)Math.log10(i)+1 == pow) sb.append(i);
            }
        }

        return false;
    }

}
