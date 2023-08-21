import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    // 8방 상하좌우 좌상 좌하 우상 우하
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = sToN.apply(st.nextToken());
            int h = sToN.apply(st.nextToken());
            if (w==0 && h==0) break;

            int[][] map = new int[h][w];
            visited = new boolean[h][w];
            int cnt = 0;

            for (int i = 0; i < map.length; i++) {
                map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j, map);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb.toString());

    }

    private static void bfs(int row, int col, int[][] map) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] nowPos = queue.poll();
            int curRow = nowPos[0];
            int curCol = nowPos[1];

            // 8방 탐색
            for (int i = 0; i < 8; i++) {
                int nextRow = curRow + dx[i];
                int nextCol = curCol + dy[i];

                // row,col 범위가 맵을 벗어나면 continue
                if (nextRow < 0 || nextCol <0 || nextRow >= map.length || nextCol >= map[0].length) continue;

                if (map[nextRow][nextCol] != 0 && !visited[nextRow][nextCol]){
                    queue.offer(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }

}