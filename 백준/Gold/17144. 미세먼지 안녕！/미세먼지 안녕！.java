import java.io.*;
import java.util.*;

public class Main {
    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int R,C, T;
    static int[][] map, copyMap;
    static List<Pos> air, dustList;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // R=행, C=열, T=시간
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        copyMap = new int[R][C];
        air = new ArrayList<>();
        dustList = new ArrayList<>();
//        pos = new Pos[2];
        int idx = 0;
        // map input
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                // 공기청정기 위치
                if (val == -1) {
                    air.add(new Pos(i, j));
//                    pos[idx++] = new Pos(i, j);
                }
                // 먼지
                else if (val != 0) {
                    dustList.add(new Pos(i, j));
                }
            }
        }

        // T만큼 STEP 반복

        for (int t = 0; t < T; t++) {
            // STEP01.먼지 확산
            Queue<Pos> queue = new LinkedList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int val = map[i][j];
                    if (val != -1 && val != 0 && val >= 5) {

                        // 먼지가 있으면 순환
                        queue.offer(new Pos(i, j));
                    }
                }
            }
            cloneMap(map, copyMap); // copyMap에 원본 복사
            diffusionDust(queue);

            // STEP02. 공기청정기 순환
            airCondition();
            cloneMap(copyMap, map); //
        }

        // 먼지 계산
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] != -1) answer += map[i][j];
            }
        }
        System.out.println(answer);
    }

    /**
     * STEP01. 먼지 확산
     */
    static void diffusionDust(Queue<Pos> q) {

//        for (int i = 0; i < R; i++) {
//            copyMap[i] = map[i].clone();
//        }

        while (!q.isEmpty()) {
            Pos getP = q.poll();
            int curRow = getP.x;
            int curCol = getP.y;
            int cnt = 0; // 나중에 현재위치에서 확산된 먼지를 뺄 수치
            int curDust = map[curRow][curCol]/5; // 현재 먼지 수치

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dx[i];
                int nextCol = curCol + dy[i];

                // 범위 체크
                if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;
                // 공기청정기면 pass
                if (map[nextRow][nextCol] == -1) continue;

                cnt++;
                copyMap[nextRow][nextCol] += curDust;
            }

            copyMap[curRow][curCol] -= (cnt * curDust);
        }
    }

    /**
     * STEP02. 공기청정기 순환
     */
    static void airCondition() {
        // 공기청정기 위치
        Pos tPos = air.get(0);
        Pos bPos = air.get(1);

        // STEP1. 0열 처리
        // 1-1.상단부
        for (int t = tPos.x-1; t >= 0; t--) {
            int curDust = copyMap[t][0];
            copyMap[t][0] = 0;
            if (t+1 == tPos.x) continue;
            copyMap[t+1][0] = curDust;
        }

        // 1-2.하단부
        for (int b = bPos.x + 1; b < R; b++) {
            int curDust = copyMap[b][0];
            copyMap[b][0] = 0;
            if (b-1 == bPos.x) continue;
            copyMap[b-1][0] = curDust;
        }

        // STEP2. 0행, R-1행 처리
        for (int col = 1; col < C; col++) {
            int firstColDust = copyMap[0][col];
            int lastColDust = copyMap[R-1][col];
            copyMap[0][col] = 0;
            copyMap[R-1][col] = 0;

            copyMap[0][col-1] = firstColDust;
            copyMap[R-1][col-1] = lastColDust;
        }

        // STEP3. C-1열 처리
        // 3-1. 상단부
        for (int t = 1; t <= tPos.x; t++) {
            int curDust = copyMap[t][C-1];
            copyMap[t][C-1] = 0;
            copyMap[t-1][C-1] = curDust;
        }

        // 3-2. 하단부
        for (int b = R-2; b >= bPos.x; b--) {
            int curDust = copyMap[b][C-1];
            copyMap[b][C-1] = 0;
            copyMap[b+1][C-1] = curDust;
        }

        // STEP4. 상단부, 하단부 처리
        // 4-1. 상단부
        // 끝 열에 먼지가 있으면 이동하지 못하므로 pass
        for (int j = C - 2; j > 0; j--) {
            int curDust = copyMap[tPos.x][j];
            copyMap[tPos.x][j] = 0;
            copyMap[tPos.x][j+1] = curDust;
        }

        // 4-2. 하단부
        // 끝 열에 먼지가 있으면 이동하지 못하므로 pass
        for (int j = C - 2; j > 0; j--) {
            int curDust = copyMap[bPos.x][j];
            copyMap[bPos.x][j] = 0;
            copyMap[bPos.x][j+1] = curDust;
        }
    }

    static void cloneMap(int[][] origin, int[][] target) {
        for (int i = 0; i < R; i++) {
            target[i] = origin[i].clone();
        }
    }

}