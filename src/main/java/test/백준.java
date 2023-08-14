package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 백준 {
    private static int minDistance = Integer.MAX_VALUE;// 미로 1,1 ~ N,M 거리
    private static int[][] maze;
    private static int N, M;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\MJ\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N+1][M+1];

        for (int i = 1; i < maze.length; i++) {
            char[] numS = br.readLine().toCharArray();
            for (int j = 1; j < maze[i].length; j++) {
                maze[i][j] = numS[j-1]-'0';
            }
        }
        findMaze();
        System.out.println(minDistance);

    }

    private static void findMaze(){
        // 상하좌우 4방 dir
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // 1,1 출발
        // 상 하 좌 우 4방 탐색 => 1이면 queue에 offer
        // 위치가 N,M 도착했을때 distance 입력=> 최소 값 찾기
        Queue<int[]> queue = new ArrayDeque<>();
        // 0번:row | 1번:col | 2번 : distance
        queue.offer(new int[]{1, 1,1});

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int row = pos[0] + dx[i];
                int col = pos[1] + dy[i];

                if(row <= 0 || row >= maze.length || col <= 0 || col >= maze[i].length) continue;

                int distance = pos[2] + 1;
                if (maze[row][col] == 1) {
                    queue.offer(new int[]{row, col, distance});
//                    maze[pos[0]][pos[1]] = 0; // 방문한곳 0처리
//                    break;
                }

                if (row == N && col == M) {
                    minDistance = Math.min(queue.peek()[2], minDistance);
                }
            }

//            if (pos[0] == N && pos[1] == M) {
//                minDistance = Math.min(queue.peek()[2], minDistance);
//            }
            maze[pos[0]][pos[1]] = 0; // 방문한곳 0처리
        }

    }




}
