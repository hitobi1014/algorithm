import java.io.*;
import java.util.*;

public class Main {
    static int N, distance[];
    static boolean isCycle, visited[];
    static Queue<Integer> queue = new LinkedList<Integer>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선정보 input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        // 싸이클 찾기
        dfs(list, 0, 1);

        // 순환선과 역 거리 구하기
        bfs(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(distance[i]).append(' ');
        }
        System.out.println(sb);
    }

    static void bfs(ArrayList<Integer>[] adj) {
        int cnt = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int tmp = queue.poll();
                // 연결된 구간 다음 탐색지에 추가
                for (int j : adj[tmp]) {
                    // 거리가 이미 구해진 역 제외
                    if (distance[j] != -1) continue;
                    distance[j] = cnt;
                    queue.add(j);
                }
            }
            cnt++; // 순환선과의 거리
        }
    }

    static void dfs(ArrayList<Integer>[] adj, int prev, int cur) {
        // 탐색하는 역 방문 체크
        visited[cur] = true;
        // 연결된 구간 탐색
        for (int next : adj[cur]) {
            // 직전 방문지가 아니면서 && 이미 방문한곳에 도착 => 싸이클 발생
            if (visited[next] && next != prev) {
                isCycle = true;
                distance[next] = 0;
                queue.add(next);
                break;
            } else if (!visited[next]) {
                // 아직 방문하지 않은 역 탐색
                dfs(adj, cur, next);
                // 사이클에 속하는 경우
                if (isCycle) {
                    // 이미 사이클에 속한곳 만남
                    if (distance[next] == 0) {
                        isCycle = false;
                    } else {
                        distance[next] = 0;
                        queue.add(next);
                    }
                    return;
                }
            }
        }
    }

}