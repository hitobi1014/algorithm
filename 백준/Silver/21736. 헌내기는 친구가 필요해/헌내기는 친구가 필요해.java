import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static int N, M, answer;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = sToN.apply(st.nextToken());
        M = sToN.apply(st.nextToken());
        map = new char[N][M];
        int row=0,col=0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char x = str.charAt(j);
                map[i][j] = x;
                if (x == 'I') {row = i; col = j;}
            }
        }
        bfs(row, col);
        System.out.println(answer!=0?answer:"TT");
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        map[row][col] = 'X';

        while (!queue.isEmpty()) {
            int[] rowCol = queue.poll();
            int curRow = rowCol[0];
            int curCol = rowCol[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dx[i];
                int nextCol = curCol + dy[i];

                if(nextRow<0 || nextCol <0 || nextRow>=N || nextCol >= M
                        || map[nextRow][nextCol]=='X') continue;

                if (map[nextRow][nextCol]=='P') answer++;
                queue.offer(new int[]{nextRow, nextCol});
                map[nextRow][nextCol] = 'X';
            }

        }

    }

}