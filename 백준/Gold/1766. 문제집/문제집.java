import java.io.*;
import java.util.*;

public class Main {
    static int[] line, answer;
    static int N, M;
    static List[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 문제 수
        M = Integer.parseInt(st.nextToken()); // 정보 (간선)

        line = new int[N + 1];
        list = new List[N + 1]; // 1부터 시작

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // 간선정보 input
        for (int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine());
            int curVertex = Integer.parseInt(st.nextToken());
            int nextVertex = Integer.parseInt(st.nextToken());

            list[curVertex].add(nextVertex);
            line[nextVertex]++; // 진입차수 계산
        }

        // logic start
        answer = new int[N];
        find();
        // answer
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }

    static void find() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 진입차수가 0인것들 pq에 input
        for (int i = 1; i <= N; i++) {
            if (line[i] == 0) {
                pq.offer(i);
            }
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            answer[idx++] = poll;

            ArrayList<Integer> getList = (ArrayList<Integer>) list[poll];
            for (int i = 0; i < getList.size(); i++) {
                int curVertex = getList.get(i);
                line[curVertex]--; // 진입차수 감소
                if (line[curVertex] == 0) {
                    pq.offer(curVertex);
                }
            }
        }
    }
}