import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[1001];
        prime[0] = true;
        prime[1] = true;
        // 에라토스테네스체
        for (int i = 2; i < prime.length; i++) {
            for (int j = i*2; j < prime.length; j+=i) {
                if(!prime[j]) prime[j] = true;
            }
        }

        int cnt=0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            if (!prime[x]) cnt++;
        }

        System.out.println(cnt);
    }

}