import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            sb.append('#').append(num).append(' ');

            Queue<Integer> queue = new ArrayDeque();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) queue.offer(Integer.parseInt(st.nextToken()));

            solution(queue);
            while (!queue.isEmpty()) sb.append(queue.poll()).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void solution(Queue<Integer> queue) {
        int num = 1;

        while (true) {
            int x = queue.poll() - num++;
            if (num == 6) num = 1;
            queue.offer(x <= 0 ? 0 : x);
            if (x <= 0) break;
        }
    }
}