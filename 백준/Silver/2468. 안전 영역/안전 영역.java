import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 안전영역
 */
public class Main {
    static int N, answer, maxRainfall, cnt;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        N = sToN.apply(br.readLine());
        arr = new int[N][N];
        maxRainfall = Integer.MIN_VALUE;
        answer = 1;


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                maxRainfall = Math.max(maxRainfall, x);
                arr[i][j] = x;
            }
        }

        for (int i = 1; i <= maxRainfall; i++) {
            cnt = 0;
            visited = new boolean[N][N];
            visit(i);

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k]){
                        cnt++;
                        dfs(j, k);
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }

    private static void visit(int rainfall) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j]<=rainfall) visited[i][j] = true;
            }
        }
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N || visited[nextRow][nextCol]) continue;

            dfs(nextRow, nextCol);
        }
    }
}