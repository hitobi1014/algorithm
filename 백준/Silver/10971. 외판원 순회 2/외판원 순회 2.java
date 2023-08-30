import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 총 N번만큼 반복문돌기
 * 다음 노드 + 비용
 * 반복문 돌때마다 최소 비용 .답과 비교해서 넣기
 *  - 반복문 들어가기전 현재 idx 같이 보내기 ,
 *  현재 depth가 node수와 같다면 보낸 현재 idx(for 문의 노드 idx)를 지금 탐색중인 노드에서 비용 찾기
 *
 */
public class Main {
    static class travel{
        int nextNode;
        int cost;

        public travel(int nextNode, int cost) {
            this.nextNode = nextNode;
            this.cost = cost;
        }
    }

    static int N, answer, currentIdx;
    static boolean[] visited;
    static ArrayList[] travelList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 리스트 생성
        travelList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            travelList[i] = new ArrayList<travel>();
        }

        // 값 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (i==j) continue;
                travelList[i].add(new travel(j, x));
            }
        }

        answer = Integer.MAX_VALUE;
        // 노드수 만큼 반복문 돌기
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            currentIdx = i;
            visited[currentIdx] = true;
            findTravelMinCost(1, currentIdx, 0);
        }

        System.out.println(answer);
    }

    private static void findTravelMinCost(int depth, int searchIdx, int cost) {
        ArrayList<travel> getList = travelList[searchIdx];

        // 기저조건
        if (depth == N) {
            int stCost = 0;
            for (int i = 0; i < getList.size(); i++) {
                if(getList.get(i).nextNode == currentIdx){
                    stCost = getList.get(i).cost;
                    break;
                }
            }
            if (stCost != 0)answer = Math.min(answer, (cost + stCost));
            return;
        }

        // 유도파트
        for (int i = 0; i < getList.size(); i++) {
            int nextIdx = getList.get(i).nextNode;
            int nextCost = getList.get(i).cost;
            if (visited[nextIdx] || nextCost == 0) continue;
            visited[nextIdx] = true;
            findTravelMinCost(depth + 1, nextIdx, cost + nextCost);
            visited[nextIdx] = false;
        }
    }
}