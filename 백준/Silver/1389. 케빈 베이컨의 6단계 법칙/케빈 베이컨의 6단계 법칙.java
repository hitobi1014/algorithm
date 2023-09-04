import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

/**
 * N 유저 수 (2~100)
 * M 친구 관계 수 (1~5000)
 * 사람 번호는 1~N 까지
 */
public class Main {
    static int[][] kevinArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> sToN = Integer::parseInt;
        int N = sToN.apply(st.nextToken());
        int M = sToN.apply(st.nextToken());

        int INF = 100000000;
        kevinArr = new int[N + 1][N + 1];

        // INF 초기 세팅
//        for (int i = 0; i < N + 1; i++) Arrays.fill(kevinArr[i], INF);

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                kevinArr[i][j] = INF;
                if (i==j) kevinArr[i][j] =0;
            }
        }

        // 값 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = sToN.apply(st.nextToken());
            int next = sToN.apply(st.nextToken());
            kevinArr[prev][next] = 1;
            kevinArr[next][prev] = 1;
        }

        int[][] temp = kevinArr.clone();

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (kevinArr[i][j] > kevinArr[i][k] + kevinArr[k][j]) {
                        kevinArr[i][j] = kevinArr[i][k] + kevinArr[k][j];
                    }
                }
            }
        }

        int total = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 1; i < N + 1; i++) {
            int sum = Arrays.stream(kevinArr[i]).skip(1).sum();
            if (total > sum) {
                total = sum;
                answer = i;
            }
        }
        System.out.println(answer);

    }

}