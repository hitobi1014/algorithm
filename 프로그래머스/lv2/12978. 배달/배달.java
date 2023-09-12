import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int idx;
        int time;
        public Node(int idx, int time){
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }    
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Node>[] nodeList = new ArrayList[N+1];
        for (int i=0; i<=N;i++) nodeList[i] = new ArrayList<>();

        for(int i=0; i<road.length;i++){
            int a = road[i][0]; // 현재 마을
            int b = road[i][1]; // 다음 마을
            int c = road[i][2]; // 걸리는시간

            nodeList[a].add(new Node(b,c));
            nodeList[b].add(new Node(a,c));
        }

        answer = dijkstra(1, answer, nodeList, N, K);

        return answer;
    }
    
    private static int dijkstra(int start, int answer,List<Node>[] nodeList, int N, int K){
        int INF = Integer.MAX_VALUE;
        boolean[] check = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        // 1번부터 시작
        dist[start] = 0;

        Queue<Node> queue = new PriorityQueue<Node>();
        queue.offer(new Node(start,0));

        while (!queue.isEmpty()){
            Node getNode = queue.poll();
            int curIdx = getNode.idx;

            if(check[curIdx]) continue;
            check[curIdx] = true;

            for (Node node : nodeList[curIdx]){
                if(dist[node.idx]>dist[curIdx]+node.time){
                    dist[node.idx] = dist[curIdx]+node.time;

                    queue.offer(new Node(node.idx, dist[node.idx]));
                }
            }
        }

        for (int i=1; i<dist.length;i++){
            if (dist[i]<=K){
                answer++;
            }
        }
        return answer;
    }
}