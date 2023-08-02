import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] numArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        numArr = new int[M];
        combination(0, 1, N, M);
        System.out.println(sb);
    }

    static void combination(int cnt, int start, int N, int M) {
        if (cnt == M) {
            for (int x : numArr) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            numArr[cnt] = i;
            combination(cnt+1, i+1, N, M);
        }

    }
}