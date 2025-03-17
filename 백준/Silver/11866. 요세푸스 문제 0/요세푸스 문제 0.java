import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb =new StringBuilder();
        sb.append("<");

        int cnt = 0;
        while (queue.size() != 1) {
            int poll = queue.poll();
            cnt++;
            if (cnt % K == 0) {
                sb.append(poll).append(", ");
            } else {
                queue.offer(poll);
            }
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }

}