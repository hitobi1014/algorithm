import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {
    static int A,B, V;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToNum = Integer::parseInt;
        StringBuilder sb = new StringBuilder();

        int testCase = sToNum.apply(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = sToNum.apply(br.readLine());
            cnt = 0;
            permutation(n, 0);
            sb.append(cnt).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void permutation(int n, int sum) {
        if (sum >n) return;
        if (sum == n) {
            cnt++;
            return;
        }
        for (int i = 1; i < 4; i++) { // 3까지 사용
            permutation(n, sum + i);
        }
    }

}