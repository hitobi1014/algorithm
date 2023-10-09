import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {
    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, answer;
    static int[][] map, copyMap;
    static int[] selected;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<Pos> list = new ArrayList<>();
    static List<Pos> virusList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                // 빈 공간 list에 input
                if (val == 0) {
                    list.add(new Pos(i, j));
                } else if (val == 2) {
                    virusList.add(new Pos(i, j));
                }
            }
        }

        // logic start
        selected = new int[3];
        answer = Integer.MIN_VALUE;

        combination(0, 0);
        System.out.println(answer);

    }

    static void combination(int cnt, int start) {
        if (cnt == 3) {
            // map 복사
            copyMap = new int[N][M];
            for (int i = 0; i < map.length; i++) {
                copyMap[i] = map[i].clone();
            }
            // 벽 세우기
            for (int i = 0; i < 3; i++) {
                Pos pos = list.get(selected[i]);
                copyMap[pos.x][pos.y] = 1;
            }

            // 바이러스 fill
            bfs();

            // 안전 영역 크기 카운팅
            int safeCnt = safeAreaCount();
            answer = Math.max(safeCnt, answer);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            selected[cnt] = i;
            combination(cnt+1, i+1);
        }
    }

    static void bfs() {
        Queue<Pos> vq = new LinkedList<>();

        // 바이러스 수 만큼 queue input
        for (int i = 0; i < virusList.size(); i++) {
            vq.offer(virusList.get(i));
        }

        while (!vq.isEmpty()) {
            Pos getPos = vq.poll();

            // 4방 탐색
            for (int i = 0; i < 4; i++) {
                int nextRow = getPos.x + dx[i];
                int nextCol = getPos.y + dy[i];

                // 범위체크
                if (nextRow < 0 || nextRow >= N || nextCol <0 || nextCol >= M) continue;
                // 갈 수 있는 영역이라면 fill
                if (copyMap[nextRow][nextCol] == 0) {
                    copyMap[nextRow][nextCol] = 2;
                    vq.offer(new Pos(nextRow, nextCol));
                }

            }
        }
    }

    /**
     * 안전영역 카운팅
     */
    static int safeAreaCount() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyMap[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }
}