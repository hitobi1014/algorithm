import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 */
public class Main {
    static int N, M;
    static char[] S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        // ### 추가
        S = br.readLine().toCharArray();

        int cnt = 0;
        int answer = 0;

        for (int i = 1; i < S.length - 1; ) {
            if (S[i] == 'O' && S[i + 1] == 'I') {
                cnt++;
                if (cnt == N) {
                    if (S[i - (N * 2 - 1)] == 'I') {
                        answer++;
                    }
                    cnt--;
                }
                i += 2;
            } else {
                cnt = 0;
                i++;
            }
        }

        System.out.println(answer);
    }
}