package 인프런.section5;

import java.io.*;
import java.util.*;

public class _06_공주구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=N; i++){
            queue.offer(i);
        }

        int cnt = 1;
        while (true){
            if (cnt == K){
                queue.poll();
                cnt = 1;
                continue;
            }
            if (queue.size() == 1) break;
            cnt++;
            int poll = queue.poll();
            queue.offer(poll);
        }

        System.out.println(queue.peek());
    }
}
