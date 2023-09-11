import java.io.*;
import java.util.*;

/**
 * N 세로 M 가로 K 개수
 *
 */
public class Main {
    static int answer, N, M, K;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] foods;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        foods = new boolean[N+1][M+1];
        // 전처리
        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int rc = Integer.parseInt(st.nextToken());
            int lc = Integer.parseInt(st.nextToken());
            foods[rc][lc] = true;
        }

        answer = 0;

        for (int rc=1; rc<=N; rc++){
            for (int lc=1; lc<=M; lc++){
                if (foods[rc][lc]) {
                    int compare = bfs(rc, lc, 0);
                    if (compare > answer) answer = compare;
                }
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int rc, int lc, int cnt){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{rc,lc});
        foods[rc][lc] = false;
        cnt++;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int curRc = poll[0];
            int curLc = poll[1];

            for (int i=0; i<dx.length; i++){
                int nextRc = curRc + dx[i];
                int nextLc = curLc + dy[i];

                if (nextRc < 1 || nextLc <1 || nextRc >N || nextLc>M || !foods[nextRc][nextLc]) continue;
                foods[nextRc][nextLc] = false;
                cnt++;
                queue.offer(new int[]{nextRc, nextLc});
            }
        }

        return cnt;
    }
}