import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {

    static int answer, N, minVal;
    static List[] graph;
    static int[] population;
    static boolean[] selected; // 조합용
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        /**
         * line1. 구역개수 N
         * line2. 1~N 인구수
         * line3. N개의 줄 인접정보
         */

        N = Integer.parseInt(br.readLine()); // 구역개수
        st = new StringTokenizer(br.readLine());
        population = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            // 지역구별 인구수
            population[i] = Integer.parseInt(st.nextToken());
        }

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>(); // 구역수만큼 생성
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()); // 1번 구역부터 시작
            int connectionCnt = Integer.parseInt(st.nextToken()); // 연결된 지역개수

            for (int j = 0; j < connectionCnt; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        // logic
        minVal = Integer.MAX_VALUE;
        selected = new boolean[N + 1];

        // 부분조합
        partitialCombination(1);

        answer = minVal;
        if (minVal == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    static void partitialCombination(int cnt) {
        if (cnt == N + 1) {
            // 지역들을 2개의 구역으로 나눌 리스트
            ArrayList<Integer> aList = new ArrayList<>();
            ArrayList<Integer> bList = new ArrayList<>();

            // 2개 구역으로 나누기
            for (int i = 1; i <= N; i++) {
                if(selected[i]) {
                    aList.add(i);
                } else {
                    bList.add(i);
                }
            }

            if (aList.size() == 0 || bList.size() == 0) return;

            if (bfs(aList) && bfs(bList)) {

                // 인구수 차이 구하기
                int aPopulation = 0;
                int bPopulation = 0;

                for (int i = 1; i <= N; i++) {
                    if (selected[i]){
                        aPopulation += population[i];
                    } else {
                        bPopulation += population[i];
                    }
                }

                int diff = Math.abs(aPopulation - bPopulation);
                minVal = Math.min(diff, minVal);
            }

            return;
        }

        selected[cnt] = true;
        partitialCombination(cnt + 1);
        selected[cnt] = false;
        partitialCombination(cnt + 1);
    }

    static boolean bfs(ArrayList<Integer> list){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int cnt = 1;
        queue.offer(list.get(0));
        visited[list.get(0)] = true;

        while (!queue.isEmpty()){
            int currentZone = queue.poll();
            ArrayList<Integer> getList = (ArrayList<Integer>) graph[currentZone];

            for (int i = 0; i < getList.size(); i++) {
                int conn = getList.get(i);
                if (list.contains(conn) && !visited[conn]){
                    visited[conn] = true;
                    queue.offer(conn);
                    cnt++;
                }
            }
        }

        if (cnt == list.size()) {
            return true;
        }
        return false;
    }
}