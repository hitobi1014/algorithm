import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc=0; tc<testCase; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로길이
            N = Integer.parseInt(st.nextToken()); // 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추위치 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            // 배추개수 만큼
            for (int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                map[row][col] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);

    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curRow = poll[0];
            int curCol = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dx[i];
                int nextCol = curCol + dy[i];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || visited[nextRow][nextCol]) continue;

                // 4방이 배추인지 확인
                if (map[nextRow][nextCol] == 1) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}