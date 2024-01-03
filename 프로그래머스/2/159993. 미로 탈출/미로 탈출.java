import java.util.*;

class Solution {
        static String[][] miro;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        miro = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];

        for (int i = 0; i < maps.length; i++) {
            String[] tmp = maps[i].split("");

            for (int j = 0; j < tmp.length; j++) {
                miro[i][j] = tmp[j];
                if ("S".equals(miro[i][j])) start = new int[]{i, j};
                if ("L".equals(miro[i][j])) lever = new int[]{i, j};
            }
        }

        int result = bfs(start, "L");
        int result2 = bfs(lever, "E");

        if (result == -1 || result2 == -1) return -1;

        return result + result2;
    }
    
        static int bfs(int[] start, String target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[miro.length][miro[0].length];

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int count = queue.peek()[2];
            visited[x][y] = true;

            if (miro[x][y].equals(target)) {
                return count;
            }

            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < miro.length && ny >= 0 && ny < miro[0].length && !visited[nx][ny]) {
                    if (!miro[nx][ny].equals("X")) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, count + 1});
                    }
                }
            }
        }

        return -1;
    }
}