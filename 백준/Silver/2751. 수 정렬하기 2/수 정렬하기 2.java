import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[2_000_001];
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())+1_000_000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                sb.append(i-1_000_000).append('\n');
            }
        }

        System.out.println(sb);

    }
}