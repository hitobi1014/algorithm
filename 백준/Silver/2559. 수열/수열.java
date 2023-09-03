import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

/**
 * N 온도 전체 날짜 수
 * K 합을 구하기 위한 연속날짜 수
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = sToN.apply(st.nextToken());
        int K = sToN.apply(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = sToN.apply(st.nextToken());
        }

        // index
        int lt = 0, rt = K - 1;
        // 전처리
        for (int i = lt; i <= rt; i++) {
            answer += arr[i];
        }

        int calc=answer;
        while (rt < N - 1) {
            rt++;
            lt++;

            calc = calc - arr[lt - 1] + arr[rt];
            if (calc > answer) answer = calc;
        }

        System.out.println(answer);
    }

}