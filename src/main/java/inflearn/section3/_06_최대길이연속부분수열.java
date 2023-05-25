package inflearn.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 설명
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 * 이며 그 길이는 8입니다.
 *
 * 입력
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 *
 * 출력
 * 첫 줄에 최대 길이를 출력하세요.
 *
 * 예시 입력 1
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 * 출력1
 * 8
 */
public class _06_최대길이연속부분수열 {
    public static void main(String[] args) throws IOException {
        _06_최대길이연속부분수열 T = new _06_최대길이연속부분수열();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solve(arr, k));

    }

    public int solve(int[] arr, int k) {
        int answer = 0, lt = 0, rt = 0, zeroCnt = 0, max = 0;
        int idx1 = 0, idx2 = 0;

        while (rt < arr.length) {

            if (arr[rt] == 0) {
                zeroCnt++;
                if (zeroCnt == 1) idx1 = rt;
                if (zeroCnt == 2) idx2 = rt;
            }

            if (zeroCnt == k + 1) {
                for (int i = lt; i < rt; i++) {
                    answer++;
                }
                max = Math.max(max, answer);

                lt = idx1 + 1;
                rt = idx2;
                zeroCnt = 0;
                answer = 0;
                continue;
            }

            rt++;
        }

        answer = max;
        return answer;
    }


}
