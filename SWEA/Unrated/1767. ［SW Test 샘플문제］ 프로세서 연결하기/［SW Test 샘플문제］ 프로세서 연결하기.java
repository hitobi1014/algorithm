import java.io.*;
import java.util.*;

/**
 */
public class Solution {
    static class Core{
        int x, y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;

    static int N, maxCore, answer;
    static List<Core> coreList;
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            coreList = new ArrayList<>();
            // 입력
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int cell = Integer.parseInt(st.nextToken());

                    // core가 있을때 map에 input
                    if (cell == 1) {
                        map[i][j] = cell;

                        // core 위치가 가장자리가 아닐때 해당 cell 리스트에 추가
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            coreList.add(new Core(i, j));
                        }
                    }
                }
            }

            maxCore = -1;
            answer = 1000000;
            dfs(0, 0, 0);
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

    static void dfs(int idx, int coreCnt, int wireCnt) {
        //
        if (idx == coreList.size()) {

            if (maxCore < coreCnt) {
                answer = wireCnt;
                maxCore = coreCnt;
            } else if (maxCore == coreCnt){
                answer = Math.min(answer, wireCnt);
            }
            return;
        }

        int curX = coreList.get(idx).x;
        int curY = coreList.get(idx).y;

        // 4방 탐색
        for (int i = 0; i < 4; i++) {
            int count=0, nextX=curX, nextY=curY;

            while (true) {
                nextX += dx[i];
                nextY += dy[i];

                if (!isVaild(nextX, nextY)) break;
                // map의 다른 코어나 전선이 존재할경우 break;
                if (map[nextX][nextY] == 1) {
                    count = 0;
                    break;
                }

                // 방해가 없을 경우 카운트 증가
                count++;
            }

//            int fillX = curX;
//            int fillY = curY;

            // 카운트 개수만큼 map 1로 채우기
            changeMap(true, count, curX, curY, i);
//            for (int j = 0; j < count; j++) {
//                fillX += dx[i];
//                fillY += dy[i];
//                map[fillX][fillY] = 1;
//            }

            if (count == 0) {
                dfs(idx + 1, coreCnt, wireCnt);
            } else {
                // 정상적으로 코어를 가장자리에 연결한 경우
                dfs(idx + 1, coreCnt + 1, wireCnt + count);

                // 원복
//                fillX = curX;
//                fillY = curY;
                changeMap(false, count, curX, curY,i);

            }
        }


    }

    /**
     * map 값 채우기
     * 전선으로 길 채울때는 flag == true
     * 원복은 flag == flase
     */
    static void changeMap(boolean flag, int count, int x, int y, int dir) {
        // 값 변경은 flag true, 원복은 false
        int value = flag ? 1 : 0;

        for (int i = 0; i < count; i++) {
            x += dx[dir];
            y += dy[dir];
            map[x][y] = value;
        }
    }


    // 현재 좌표가 맵 범위를 벗어나는지 체크
    static boolean isVaild(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        return true;
    }
}