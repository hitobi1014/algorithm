package 인프런.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 설명
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 와 같이 총 3가지의 경우가 존재한다.
 *
 * 입력
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 * 출력
 * 첫 줄에 총 경우수를 출력합니다.
 *
 * 예시 입력 1
 * 15
 * 예시 출력 1
 * 3
 */
public class _05_연속된자연수의합 {
    public static void main(String[] args) throws IOException {
        _05_연속된자연수의합 T = new _05_연속된자연수의합();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.print(T.solve(N));
    }

    public int infSolve(int N) {
        int answer = 0, sum = 0, lt=0;
        int m = (N / 2) + 1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = i + 1;

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if(sum==N) answer++;
            while (sum >= N) {
                sum -= arr[lt++];
                if(sum==N) answer++;
            }
        }
        return answer;
    }

    public int solve(int N){
        int answer = 0, sum = 0, lt = 1, rt = 1;
        sum += rt;

        while (lt+rt <= N) {

            if (sum < N) {
                rt++;
                sum += rt;
                continue;
            } else if (sum == N) {
                answer++;
            }
            sum -= lt;
            lt++;
        }

        return answer;
    }
}
