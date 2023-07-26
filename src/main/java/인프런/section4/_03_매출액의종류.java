package 인프런.section4;

import java.util.HashMap;
import java.util.Scanner;

public class _03_매출액의종류 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : solution(N, K, arr)) {
            System.out.print(x + " ");
        }


    }

    static int[] solution (int N, int K, int[] arr) {
        int[] answer = new int[N-K+1];
        int lt = 0, rt = K-1, i=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int j = 0; j < K-1; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
        }

        while (rt < N) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer[i] = map.size();
            i++;
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            rt++;
            lt++;
        }
        return answer;
    }
}
