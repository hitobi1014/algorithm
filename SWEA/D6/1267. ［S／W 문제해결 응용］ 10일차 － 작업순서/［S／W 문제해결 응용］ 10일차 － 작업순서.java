import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Solution {
    static int V, E;
    static int[] visited;
    static List[] list;
    static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
///
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new List[V + 1];
            visited = new int[V + 1];
            answer = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<Integer>();
            }

            st = new StringTokenizer(br.readLine());
            // 간선정보 입력
            for (int i = 0; i < E; i++) {
                int curVertex = Integer.parseInt(st.nextToken());
                int nextVertex = Integer.parseInt(st.nextToken());

                list[curVertex].add(nextVertex);///
                visited[nextVertex]++;
            }

            findProcess();
            sb.append('#').append(tc).append(' ');
            for (int i = 1; i <= V; i++) {
                sb.append(answer[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void findProcess() {
        Queue<Integer> queue = new LinkedList<>();
        int idx = 1;
        // 진입차수가 0인 정점들 작업에 넣기
        for (int i = 1; i <= V; i++) {
            int v = visited[i]; // 진입 차수
            if (v != 0) continue;
            queue.offer(i);
            answer[idx++] = i;
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            ArrayList<Integer> getList = (ArrayList<Integer>) list[poll];

            for (int i = 0; i < getList.size(); i++) {
                int nv = getList.get(i);

                if (--visited[nv] == 0) {
                    queue.offer(nv);
                    answer[idx++] = nv;
                }
            }

        }

    }
}