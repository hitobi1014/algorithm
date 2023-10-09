import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List[] list;
    static int[] depth;
    static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        depth = new int[N+1];
        answer = new int[N+1];

        // 줄 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list[cur].add(next);
            depth[next]++; // 진입차수 증가
        }

        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int idx = 1;
        // 진입차수가 0인것들 q에 input
        for (int i = 1; i <= N; i++) {
            if (depth[i] == 0) {
                q.offer(i);
            }
        }


        while (!q.isEmpty()) {
            int curIdx = q.poll();
            ArrayList<Integer> getList = (ArrayList<Integer>) list[curIdx];
            answer[idx++] = curIdx;

            for (int i = 0; i < getList.size(); i++) {
                int nextIdx = getList.get(i);
                depth[nextIdx]--;
                if (depth[nextIdx] == 0) {
                    q.offer(nextIdx);
                }
            }
        }
    }
}