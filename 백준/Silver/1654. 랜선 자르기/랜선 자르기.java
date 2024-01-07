import java.io.*;
import java.util.*;

public class Main {

    static int K, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        long max = 0;

        // 입력받은 max랜선길이 갱신
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // max에서 +1 -> {1,1}인 경우 min을 0으로 시작했을때 min:0, max:1 -> (0+1)/2 => 0 런타임 에러 발생하기때문에
        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {
            // 중간길이 구하기
            mid = (min + max) / 2;

            // 랜선길이 카운팅
            long count = 0;

            // mid로 몇 개의 랜선이 구해지는지
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            /**
             * [upper bound 적용]
             * 1) 목표 랜선길이 수가 안나오면 좀 더 촘촘하게 잘라야하기때문에
             * 중간값을 max로 변경
             *
             * 2) 그 외의 경우엔 자르는 길이를 더 늘려야 하므로 최소 길이를
             * mid + 1로 변경
             */
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }


}