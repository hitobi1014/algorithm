import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] maze;
    private static int N, M;
    // 상하좌우 4방 dir
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited; // 방문 배열 관리

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];

        for (int i = 0; i < maze.length; i++) {
            char[] numS = br.readLine().toCharArray();
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = numS[j]-'0';
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;
        findMaze();
        System.out.println(maze[N-1][M-1]);

    }

    private static void findMaze(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];

            for (int i = 0; i < dx.length; i++) {
                int nextRow = pos[0] + dx[i];
                int nextCol = pos[1] + dy[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
                if (visited[nextRow][nextCol] || maze[nextRow][nextCol] == 0) continue;

                queue.offer(new int[]{nextRow, nextCol});
                maze[nextRow][nextCol] = maze[row][col] + 1;
                visited[nextRow][nextCol] = true;
            }
        }
    }

}