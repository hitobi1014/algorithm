import java.io.*;
import java.util.*;

class Solution {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] visited;
    static int ans;
    static int N, M;
    
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        visited = new int[N][M];
        
        ans = Integer.MAX_VALUE;
        bfs(maps);
        answer = visited[N-1][M-1] == 0 ? -1 : visited[N-1][M-1];
        
        return answer;
    }
    
    static void bfs(int[][] maps){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0,0));
        visited[0][0] = 1;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            // if(node.x == N-1 && node.y == M-1){
            //     ans = Math.min(ans, node.weight);
            //     continue;
            // }

            for (int i=0; i<4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                // 범위 체크
                if (ny < 0 || nx < 0 || ny>=N || nx>= M || maps[ny][nx]==0) continue;

                if (maps[ny][nx] == 1 && visited[ny][nx] == 0){
                    visited[ny][nx] = visited[node.y][node.x] + 1;
                    queue.offer(new Node(ny, nx));
                }
                
            }
        }

    }

    static class Node{
        private int y;
        private int x;


        public Node(int y, int x){
            this.y=y;
            this.x=x;

        }
    }
}