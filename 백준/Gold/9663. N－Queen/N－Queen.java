import java.util.Scanner;

public class Main {
    private static int N;
    private static boolean[] col, slash, backSlash;
    private static int answer;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 1열부터 체크하기 위해 +1
        col = new boolean[N];
        // 대각선 체크를 위해 배열크기 2*N개
        slash = new boolean[2 * N -1];
        backSlash = new boolean[2 * N-1];

        backTracking(0);
        System.out.println(answer);
    }

    private static void backTracking(int r) {
        if (r == N) {
            answer++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (isAvailable(r, c)) {
                col[c] = slash[r + c] = backSlash[r - c + N - 1] = true;
                backTracking(r + 1);
                col[c] = slash[r + c] = backSlash[r - c + N - 1] = false;
            }
        }
    }

    private static boolean isAvailable(int r, int c) {
        if (col[c] || slash[r+c] || backSlash[r-c + N-1]){
            return false;
        }
        return true;
    }

}