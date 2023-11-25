import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] checked;
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        checked = new boolean[N][N];

        // Input
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            checked[a][b] = true;
        }

        // 연결체크
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (checked[i][k] && checked[k][j]){
                        checked[i][j] = true;
                    }
                }
            }
        }

        int[] cnt = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (checked[i][j] || checked[j][i]){
                    cnt[i]++;
                }
            }
        }

        int result = 0;
        for (int x : cnt) {
            if (x == N-1) result++;
        }
        System.out.println(result);
    }
}