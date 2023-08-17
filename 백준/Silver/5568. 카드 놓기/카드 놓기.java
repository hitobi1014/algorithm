import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Main {
    static int N, K, cards[], numbers[];
    static boolean[] isVisited;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToNum = Integer::parseInt;
        N = sToNum.apply(br.readLine());
        K = sToNum.apply(br.readLine());
        cards = new int[N];
        isVisited = new boolean[N];
        numbers = new int[K];

        for (int i = 0; i < N; i++) {
            cards[i] = sToNum.apply(br.readLine());
        }
        permutation(0);
        System.out.println(set.size());
    }

    private static void permutation(int cnt) {
        if (cnt == K) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < K; i++) {
                sb.append(String.valueOf(numbers[i]));
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        // 유도파트
        for (int i = 0; i < N; i++) {
            if(isVisited[i]) continue;
            numbers[cnt] = cards[i];
            isVisited[i] = true;
            permutation(cnt+1);
            isVisited[i] = false;
        }

    }
}