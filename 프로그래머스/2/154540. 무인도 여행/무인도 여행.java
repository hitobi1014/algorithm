import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Integer> answerList = new ArrayList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;

    static public int[] solution(String[] maps) {
        int[] answer = {};
        N = maps.length;
        M = maps[0].length();
        char[][] arr = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        // array init
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                char c = maps[i].charAt(j);
                arr[i][j] = c;
                if (c== 'X') visited[i][j] = true;
            }
        }


        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (visited[i][j]) continue;
                bfs(i,j, arr, visited);
            }
        }

        if (answerList.size() == 0) {
            answer = new int[]{-1};
        } else {
            Collections.sort(answerList);
            answer = new int[answerList.size()];
            for (int i=0; i<answer.length; i++){
                answer[i] = answerList.get(i);
            }
        }

        return answer;
    }

    static void bfs(int x, int y, char[][] arr, boolean[][] visited){
        int total = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        total += Character.getNumericValue(arr[x][y]);

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            for (int i=0; i<4;i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위 & 방문체크
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M
                        || visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                total += Character.getNumericValue(arr[nextX][nextY]);
                queue.offer(new int[]{nextX,nextY});

            }
        }

        if (total != 0){
            answerList.add(total);
        }
    }
}