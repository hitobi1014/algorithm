import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] friends;
    static int N, maxCnt;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        friends = new char[N][N];

        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            find(i);
        }
        System.out.println(maxCnt);

    }

    private static void find(int idx) {
        visited[idx] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);

        int depth = 0;
        int cnt = 0;

        // 한 다리 건너 친구 아는경우까지만 카운트
        while (depth < 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int n = queue.poll();
                for (int j = 0; j < N; j++) {
                    if (friends[n][j] == 'Y' && !visited[j]) {
                        queue.offer(j);
                        cnt++;
                        visited[j] = true;
                    }
                }
            }
            depth++;
        }

        if (maxCnt < cnt) {
            maxCnt = cnt;
        }
    }
}