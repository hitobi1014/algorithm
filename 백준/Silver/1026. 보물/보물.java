import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Main {
    static int N, answer;
    static int[] A, B;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToNum = Integer::parseInt;
        N = sToNum.apply(br.readLine());
        A = new int[N];
        B = new int[N];

        // A
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = sToNum.apply(st.nextToken());
        }
        Arrays.sort(A);

        // B
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = sToNum.apply(st.nextToken());
        }
        Integer[] tmp = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            answer += A[i] * tmp[i];
        }
        System.out.println(answer);

    }

}