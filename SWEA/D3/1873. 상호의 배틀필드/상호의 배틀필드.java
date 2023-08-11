import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1873. 상호의 배틀필드
 */
public class Solution {

    private static char[][] map;
    // 0번idx 탱크 문자정보 1번 idx row 정보,2번 idx col 정보
    private static char[] tankInfo;
    private static Map<Character, Integer> tankInit = new HashMap<>();

    static {
        tankInit.put('^', 0);
        tankInit.put('v', 1);
        tankInit.put('<', 2);
        tankInit.put('>', 3);
        tankInit.put('U', 0);
        tankInit.put('D', 1);
        tankInit.put('L', 2);
        tankInit.put('R', 3);
    }

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            tankInfo = new char[3];

            // 맵 구성
            for (int j = 0; j < H; j++) {
                char[] cArr = br.readLine().toCharArray();
                for (int k = 0; k < W; k++) {
                    char c = cArr[k];
                    map[j][k] = c;

                    if (tankInit.containsKey(c)) {
//                        tankInfo[0] = (char)(tankInit.get(c)+'0');
                        tankInfo[0] = c;
                        tankInfo[1] = (char) (j + '0');
                        tankInfo[2] = (char) (k + '0');

//                        tankStart.put(c, new int[]{j,k});
                    }

                }
            }

            // 명령어 입력
            int N = Integer.parseInt(br.readLine());
            char[] commands = br.readLine().toCharArray();

            processMap(commands);
            sb.append("#").append(i).append(' ');
            for (int a = 0; a < map.length; a++) {
                for (int b = 0; b < map[a].length; b++) {
                    sb.append(map[a][b]);
                }
                sb.append('\n');
            }

        }


        System.out.println(sb.toString());
    }

    private static void processMap(char[] commands) {
//        char tankDir = tankInfo[0];
//        int row = tankInfo[1], col = tankInfo[2];

        for (char c : commands) {
            if (c == 'S') {
                shoot();
            } else {
                moveTank(c);
            }

//            System.out.println("=========" + c + "=========");
//            for (int i = 0; i < map.length; i++) {
//                for (int j = 0; j < map[i].length; j++) {
//                    System.out.print(map[i][j]+"\t");
//                }
//                System.out.println();
//            }
//            System.out.println("=================================================");
        }
    }

    //    private static void shoot(char tankDir, int row, int col){
    private static void shoot() {
        // * - 벽돌로 만들어진벽은 파괴되고 평지로 변함
        // # - 강철로 만들어진벽은 아무런 변함 없음
        // 맵 밖에 나갈때까지 진행됨
//        int idx = tankInit.get(tankDir);
//        int r = row - dx[idx];
//        int c = col - dy[idx];

        int idx = tankInit.get(tankInfo[0]);
        int r = (tankInfo[1] - '0') + dx[idx];
        int c = (tankInfo[2] - '0') + dy[idx];

        while (true) {
            if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) break;
            if (map[r][c] == '#') break;
            if (map[r][c] == '*') {
                map[r][c] = '.';
                break;
            }

            r = r + dx[idx];
            c = c + dy[idx];

            // 평지일때 해당 방향으로 포탄전진
//            if (map[r][c] == '.' || ) {
//                r = r + dx[idx];
//                c = c + dy[idx];
//                continue;
//            }
        }
    }

    //    private static void moveTank(char tankDir, int row, int col){
    private static void moveTank(char dir) {
//        int idx = tankInit.get();
//        int r = row - dx[idx];
//        int c = col - dy[idx];

        int idx = tankInit.get(dir);

        switch (dir) {
            case 'U':
                map[tankInfo[1] - '0'][tankInfo[2] - '0'] = '^';
                tankInfo[0] = '^';
                break;
            case 'D':
                map[tankInfo[1] - '0'][tankInfo[2] - '0'] = 'v';
                tankInfo[0] = 'v';
                break;
            case 'L':
                map[tankInfo[1] - '0'][tankInfo[2] - '0'] = '<';
                tankInfo[0] = '<';
                break;
            case 'R': {
                map[tankInfo[1] - '0'][tankInfo[2] - '0'] = '>';
                tankInfo[0] = '>';
            }
            break;
        }


        int r = (tankInfo[1] - '0') + dx[idx];
        int c = (tankInfo[2] - '0') + dy[idx];

        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) return;

        if (map[r][c] == '.') {
            map[tankInfo[1] - '0'][tankInfo[2] - '0'] = '.';
            switch (dir) {
                case 'U':
                    map[r][c] = '^';
                    tankInfo[0] = '^';
                    break;
                case 'D':
                    map[r][c] = 'v';
                    tankInfo[0] = 'v';
                    break;
                case 'L':
                    map[r][c] = '<';
                    tankInfo[0] = '<';
                    break;
                case 'R': {
                    map[r][c] = '>';
                    tankInfo[0] = '>';
                }
                break;
            }
//            tankInfo[0] = dir;
            tankInfo[1] = (char) (r + '0');
            tankInfo[2] = (char) (c + '0');
        }

        ;

        // 평지인경우만 이동
//        while (true){
//            if (r < 0 || r >= map.length || c <0 || c >= map.length) break;
//            if (map[r][c] != '.') break;
//        }

    }


}