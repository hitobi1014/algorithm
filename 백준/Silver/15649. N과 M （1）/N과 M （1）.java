import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] isCheck;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        isCheck = new boolean[N + 1];
        permutation(0);
    }

    static void permutation(int cnt){
        if (cnt == M){
            for (int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(isCheck[i]) continue;
            arr[cnt] = i;
            isCheck[i] = true;
            permutation(cnt + 1);
            isCheck[i] = false;
        }
    }

}
