import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[M];
        visited = new boolean[M];
        sb = new StringBuilder();
        dfs(1, 0);
        System.out.println(sb);

    }

    static void dfs(int start, int cnt) {
        // 백트래킹
        if (cnt == M) {
            // 원소 sb 넣기
            for (int x : arr){
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 반복
        for (int i = start; i <= N; i++) {
            if (visited[cnt]) continue;
            visited[cnt] = true;
            arr[cnt] = i;
            dfs(i, cnt + 1);
            // 원복
            visited[cnt] = false;
        }

    }
}