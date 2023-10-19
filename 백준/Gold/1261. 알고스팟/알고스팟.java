import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x,y, weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }


    }
    static int col, row;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, copy;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        copy = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                copy[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0, 0, 0);
        System.out.println(copy[row-1][col-1]);
    }

    static void bfs(int x, int y, int count) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) -> o1.weight - o2.weight);
        pq.offer(new Node(x,y,count));
        copy[x][y] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.x == row - 1 && node.y == col - 1) {
                return;
            }
            //4방 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                //범위체크 && 방문체크
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) continue;
                
                if(copy[nextX][nextY] > copy[node.x][node.y] + map[nextX][nextY]) {
                    copy[nextX][nextY] = copy[node.x][node.y] + map[nextX][nextY];
                    pq.offer(new Node(nextX, nextY, copy[nextX][nextY]));
                }

            }
        }
    }
}