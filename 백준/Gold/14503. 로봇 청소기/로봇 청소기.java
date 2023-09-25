import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {
    static int N, M, answer;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int r,c,d;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        answer = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구현
        dfs(r, c, d);
        // 정답 출력
        System.out.println(answer);
    }

    static void dfs(int r, int c, int d){
        // 현재칸 청소 안됐을경우 청소
        map[r][c] = -1;

        // 4방향 탐색 상 우 하 좌 -> 로봇 반시계방향대로
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + dx[d];
            int nc = c + dy[d];
            // 2. 현재칸 주변 4칸중 청소된칸이 없는경우

            if (nr >= 0 && nr < N && nc >= 0 && nc < M){
                if (map[nr][nc] == 0) {
                    answer++;
                    dfs(nr, nc, d);
                    return;
                }
            }
        }
        // 2-1. 반시계 방향 회전 => 방향 = N-1 < 0 ? 3 : N-1
        // 빈칸이 아닌경우는 다시 2-1 반복
        // 2-2. 바라본 방향으로 앞칸이 빈칸인 경우 전진 후 1.반복


        // 1. 현재칸 주변 4칸 모두 청소되었을경우
        // 1-1. 바라보는 방향유지, 한 칸 후진  (벽일경우 후진x => 실행종료)
        int back = (d + 2) % 4;
        int br = r + dx[back];
        int bc = c + dy[back];

        if (br>=0 && br < N && bc >= 0 && bc<M && map[br][bc] != 1){
            dfs(br, bc, d);
        }

    }

}