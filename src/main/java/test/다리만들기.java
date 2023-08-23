package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Stream;

public class 다리만들기 {
    static int N, M, answer, size, landNum = 1;
    static int[][] islands;
    static boolean[][] visited;
//    static List<Map>
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Island{
        int startRow, startCol, size, landId; // landId = > 섬 번호
        int from, to, weight;

        public Island(int startRow, int startCol, int size, int landId) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.size = size;
            this.landId = landId;
        }

        public int getFrom() {return from;}
        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getStartCol() {
            return startCol;
        }

        public void setStartCol(int startCol) {
            this.startCol = startCol;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getLandId() {
            return landId;
        }

        public void setLandId(int landId) {
            this.landId = landId;
        }
    }

    static List<Island> islandList;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\MJ\\project\\algorithm\\src\\main\\java\\testcase\\다리만들기TC.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = sToN.apply(st.nextToken());
        M = sToN.apply(st.nextToken());
        islands = new int[N][M];

        // 섬 input
        for (int i = 0; i < N; i++) {
            islands[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 다리길이: 격자 차지 칸 수
        // 다리를 통해 A -> B 이동 || 다리 양 끝은 섬과 인접한 바다위에 있어야 함
        // 다리 조건
        // 1. 다리의 방향이 중간에 바뀌면 안됨, => 가로 또는 세로 방향만 가능
        // 2. 다리 길이는 2이상

        /**## 작업 순서 ##
         * 1. 섬 위치, 개수, 크기 파악하기
         * 2. 섬 간 거리 구하기(가중치 파악) A->B 섬 A...->N 섬
         *   - A기준에서 다 구했으면 B섬은 A섬 체크 x (시작한섬은 방문체크를 통해 제외하기)
         * 3. 최소신장트리
         */

        // 1. 섬 정보 파악하기
        islandList = new ArrayList<>();
        for (int i = 0; i < islands.length; i++) {
            for (int j = 0; j < islands[i].length; j++) {
                if (islands[i][j] ==1) {
                    landNum++; // 섬 번호 증가
                    size = 1;
                    // 메서드 호출
                    findIslandsInfo(i, j);
                    // 섬 정보 저장
                    islandList.add(new Island(i, j, size,landNum));
                }
            }
        }

        // 2. 섬 간선 리스트 구하기
        for (int i = 0; i < islandList.size(); i++) {
            graph(islandList.get(i));
        }
        
        // 3. MST
    }

    /**
     * [1] 섬 정보 파악
     * @param size 섬 크기
     */
    private static void findIslandsInfo(int row, int col) {
        // 섬 넘버링
        islands[row][col] = landNum;

        // 8방 탐색
        for (int i = 0; i < dx.length; i++) {
            int curRow = row + dx[i];
            int curCol = col + dy[i];
            // 맵 범위 체크
            if (curRow < 0 || curCol < 0 || curRow >= N || curCol >= M || islands[curRow][curCol]==landNum) continue;

            if (islands[curRow][curCol] != 0) {
                size++;
                findIslandsInfo(curRow, curCol);
            }
        }
    }

    /**
     * 간선리스트 생성
     */
    private static void graph(Island island) {
        /**
         * 1. 4방 탐색하면서 같은 섬번호거나 맵 범위를 벗어나면 pass
         * 2. 탐색하면서 카운트 증가, 다른 섬번호가 나왔을때 간선리스트 기록
         *   - 단 카운트가 2이상인 경우에만 기록
         */
        int row = island.getStartRow();
        int col = island.getStartCol();
        int lNumber = island.getLandId();

        int dis2 = 0;

        A:for (int i = 0; i < dx.length; i++) {
            dis2 = 0;
            int curRow = row + dx[i];
            int curCol = col + dy[i];
            int nextIslandId = 0;
            while (true) {
                if (curRow < 0 || curCol < 0 || curRow >= N || curCol >= M || islands[curRow][curCol]==landNum) break;
                nextIslandId = islands[curRow][curCol];
                dis2++;
                curRow += dx[i];
                curCol += dy[i];
            }

            if (dis2 >1) {
                System.out.println("현재 섬 번호 : " + lNumber + " 인접 섬 : "+nextIslandId + " 거리 : " + dis2) ;
            }
        }
    }

}