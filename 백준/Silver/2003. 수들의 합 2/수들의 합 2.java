import java.io.*;
import java.util.*;
public class Main {

    static int N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt=0;
        int rt=0;
        int sum = 0;

        while (true) {
            if (sum > M) {
                sum -= arr[lt++];
            } else if(rt == N) {
                break;
            } else {
                sum += arr[rt++];
            }
            if (sum == M) answer++;
        }

        System.out.println(answer);
    }


}