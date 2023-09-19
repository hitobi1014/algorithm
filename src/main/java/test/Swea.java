package test;

import java.io.*;
import java.util.*;

/**
 * N*N 배열
 * 0 지나갈수있음
 * 1 장애물
 * 2 : 2초 주기 장애물 건너려면 2초기다림
 */
public class Swea {
    static int N;
    static int[][] map, temp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        // line1. 테케
        // line2. N 크기
        // line3. N개줄 배열값
        // line4. 시작위치 A,B
        // line5. 도착위치 C,D
        System.setIn(new FileInputStream("D:\\MJ\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i=1; i<=tc; i++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N]; // 원본 배열
            temp = new int[N][N]; // 걸리는 시간 담을 배열
            for (int k = 0; k < N; k++) {
                Arrays.fill(temp[k], Integer.MAX_VALUE);
            }
            visited = new boolean[N][N]; // 걸리는 시간 담을 배열
            StringTokenizer st = null;
            // 입력
            for (int lc=0; lc<N; lc++){
                st = new StringTokenizer(br.readLine());
                for (int rc = 0; rc < N; rc++) {
                    map[lc][rc] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            int sLc = Integer.parseInt(st.nextToken());
            int sRc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int eLc = Integer.parseInt(st.nextToken());
            int eRc = Integer.parseInt(st.nextToken());

            bfs(sLc, sRc);
            System.out.printf("#%d %d\n", i, temp[eLc][eRc]);

        }
    }

    private static void bfs(int lc, int rc){
        // 시작위치에서
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{lc, rc, 0}); //0:row 1:col 2:time
        visited[lc][rc] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int curRow = poll[0];
            int curCol = poll[1];
            int time = poll[2];

            // 4방 탐색, 1은 못가고 2는 걸리는시간 +2초
            for (int i=0; i<dx.length;i++){
                int nextRow = curRow + dx[i];
                int nextCol = curCol + dy[i];

                // nR, nC가 map 범위를 벗어나거나 장애물(1)을 만나면 continue
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N
                    || map[nextRow][nextCol] == 1 || visited[nextRow][nextCol]) continue;

                // 소용돌이 만나면 +2, 아니면 1 증가
                if (map[nextRow][nextCol] == 2) {
                    time += 2;
                } else {
                    time += 1;
                }

                // 최소 시간
                int minTime = Math.min(temp[nextRow][nextCol], time);
                temp[nextRow][nextCol] = minTime;
                queue.offer(new int[]{nextRow, nextCol, minTime});
                visited[nextRow][nextCol] = true;

            }
        }
    }
}