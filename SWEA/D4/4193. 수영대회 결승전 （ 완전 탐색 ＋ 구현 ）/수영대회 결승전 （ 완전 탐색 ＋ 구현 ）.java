import java.io.*;
import java.util.*;

/**
 * N*N 배열
 * 0 지나갈수있음
 * 1 장애물
 * 2 : 2초 주기 장애물 건너려면 2초기다림
 */
public class Solution {
    static class Data{
        int x, y;
        int cnt;

        public Data(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N, res, sx, sy, ex, ey;
    static int[][] map, temp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        // line1. 테케
        // line2. N 크기
        // line3. N개줄 배열값
        // line4. 시작위치 A,B
        // line5. 도착위치 C,D
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t=1; t<=tc; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N]; // 원본 배열
            temp = new int[N][N]; // 걸리는 시간 담을 배열
            StringTokenizer st = null;
            // 입력
            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            res = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            bfs();
            res = res == Integer.MAX_VALUE ? -1 : res;
            System.out.printf("#%d %d\n", t, res);

        }
    }

    private static void bfs(){
        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> (o1.cnt - o2.cnt));
        boolean[][] v = new boolean[N][N];
        pq.offer(new Data(sx,sy,0));
        v[sx][sy] = true;
        Data cur;
        while(!pq.isEmpty()) {
            cur = pq.poll();
            if (cur.x == ex && cur.y == ey){
                res = cur.cnt;
                return;
            }

            int nx, ny;
            for (int i = 0; i < dx.length; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (v[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;

                // 소용돌이 처리
                if (map[nx][ny] == 2) {
                    int time = 2 - (cur.cnt%3);
                    pq.offer(new Data(nx,ny, cur.cnt + 1 + time));
                    v[nx][ny] = true;
                    continue;
                }
                pq.offer(new Data(nx,ny, cur.cnt + 1));
                v[nx][ny] = true;

            }
        }

    }
}