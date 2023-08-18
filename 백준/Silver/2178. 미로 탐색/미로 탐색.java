import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] vals = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = vals[j] - '0';
            }
        }

        bfs(map);
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int[][] map) {
        Queue<int[]> queue = new ArrayDeque<>();
        // 0,0 좌표부터 탐색 시작, 방문예정 체크
        queue.offer(new int[]{0, 0}); // 0번Idx:row | 1번Idx:col
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] rowColInfo = queue.poll();
            // 현재 row col Info
            int cRow = rowColInfo[0];
            int cCol = rowColInfo[1];

            // 인접한 배열 4방 탐색
            for (int dirInfo = 0; dirInfo < 4; dirInfo++) {
                // 인접한 다음 배열의 row col Info
                int nRow = cRow + dx[dirInfo];
                int nCol = cCol + dy[dirInfo];

                // 인접한배열이 map 범위 밖을 벗어날때 다음 반복으로
                if (nRow<0 || nCol<0 || nRow>=N || nCol>=M) continue;

                // 인접한배열의 길이 있으면서 방문예정이 미등록되어있을때 다음 작업에 추가
                if (map[nRow][nCol] != 0 && !visited[nRow][nCol]) {
                    queue.offer(new int[]{nRow, nCol});
                    // 거리 누적해서 해당 칸 값 변경
                    map[nRow][nCol] = map[cRow][cCol] + 1;
                    visited[nRow][nCol] = true;
                }
            }
        }
    }

}
