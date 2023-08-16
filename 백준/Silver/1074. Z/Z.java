import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {

    private static int N, R, C;
    private static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        findVisited(0, 0, (int)Math.pow(2, N));
    }

    private static void findVisited(int row, int col, int size) {
        if (size == 1) {
            System.out.println(answer);
            return;
        }

        int halfSize = size / 2;
        // 1사분면
        if (R < row + halfSize && C < col + halfSize) {
            findVisited(row, col, halfSize);
        }
        // 2사분면
        if (R < row + halfSize && C >= col + halfSize) {
            answer += size * size / 4;
            findVisited(row, col+halfSize, halfSize);
        }
        // 3사분면
        if (R >= row + halfSize && C < col + halfSize) {
            answer += size * size / 4 * 2;
            findVisited(row + halfSize, col, halfSize);
        }
        // 4사분면
        if (R >= row + halfSize && C >= col + halfSize) {
            answer += size * size / 4 * 3;
            findVisited(row + halfSize, col + halfSize, halfSize);
        }
    }


}