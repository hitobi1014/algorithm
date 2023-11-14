import java.io.*;
import java.util.*;

public class Solution {

    static class Pos implements Comparable<Pos>{
        int x;
        int y;
        int time;

        public Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o) {
            return Integer.compare(this.time, o.time);
        }
    }

    static boolean[][] visited;
    static int[][] map;
    static int N, answer;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j)-'0';
                }
            }

            answer = Integer.MAX_VALUE;
            bfs();
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }

    static void bfs() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.offer(new Pos(0,0,0));
        visited[0][0] = true;

        while(!pq.isEmpty()){
            Pos poll = pq.poll();
            int curX = poll.x;
            int curY = poll.y;
            int curT = poll.time;

            if (curX == N-1 && curY == N-1){
                answer = Math.min(answer, curT);
            }

            for (int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위 탐색
                if (nextX < 0 || nextX >= N || nextY <0 || nextY >= N) continue;

                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    int nextT = curT + map[nextX][nextY];
                    pq.offer(new Pos(nextX, nextY, nextT));
                }
            }

        }
    }

}