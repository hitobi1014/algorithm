import java.io.*;
import java.util.*;

public class Main {

    static int R,C, K;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] map;
    static int answer;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[R][C];
        visited[R - 1][0] = true;
        answer = 0;

        dfs(R-1, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int y, int x, int count) {
        // 백트래킹
        if (count > K) return;

        // 도착지점
        if (y == 0 && x == C - 1) {
            if (count == K) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || map[ny][nx] == 'T') continue;

            visited[ny][nx] = true;
            dfs(ny, nx, count + 1);
            visited[ny][nx] = false;

        }
    }

}