package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class 백준 {
    static int N, answer;
    static int[] A, B;
    static Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToNum = Integer::parseInt;
        N = sToNum.apply(br.readLine());
        A = new int[N];
        B = new int[N];

        // A
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.offer(sToNum.apply(st.nextToken()));
        }
        Arrays.sort(queue.toArray());

        // B
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = sToNum.apply(st.nextToken());
        }
        System.out.println();

    }

    private static void findMinValue() {

    }


}