import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private static Map<Character, Integer> tankInit = new HashMap<>(); // 전차 방향 기본 설정
    private static Map<Character, Character> cmdConnection = new HashMap<>(); // mapping

    static {
        // 방향 <-> 4방 인덱스 매핑
        tankInit.put('^', 0);
        tankInit.put('v', 1);
        tankInit.put('<', 2);
        tankInit.put('>', 3);
        // 명령어 <-> 방향 매핑
        cmdConnection.put('U', '^');
        cmdConnection.put('D', 'v');
        cmdConnection.put('L', '<');
        cmdConnection.put('R', '>');
    }

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\00.project\\algorithm\\src\\main\\java\\test\\text.txt"));
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
                        tankInfo[0] = c;
                        tankInfo[1] = (char) (j + '0');
                        tankInfo[2] = (char) (k + '0');
                    }

                }
            }

            // 명령어 입력
            int N = Integer.parseInt(br.readLine());
            char[] commands = br.readLine().toCharArray();

            // 명령어에 따라 맵 조작
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
        for (char c : commands) {
            if (c == 'S') {
                shoot();
            } else {
                moveTank(c);
            }
        }
    }

    private static void shoot() {
        // * - 벽돌로 만들어진벽은 파괴되고 평지로 변함
        // # - 강철로 만들어진벽은 아무런 변함 없음
        int idx = tankInit.get(tankInfo[0]);
        int r = (tankInfo[1] - '0') + dx[idx];
        int c = (tankInfo[2] - '0') + dy[idx];

        while (true) {
            // 범위가 맵 밖으로 나갈때 까지 진행
            if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) break;
            if (map[r][c] == '#') break;
            if (map[r][c] == '*') {
                map[r][c] = '.';
                break;
            }

            r = r + dx[idx];
            c = c + dy[idx];
        }
    }

    private static void moveTank(char dir) {
        char tankDir = cmdConnection.get(dir);
        int idx = tankInit.get(tankDir);

        // 현재 전차 위치에서 move명령에 맞는 방향 머리 돌리기
        map[tankInfo[1] - '0'][tankInfo[2] - '0'] = tankDir;
        tankInfo[0] = tankDir;

        int tRow = tankInfo[1] - '0';
        int tCol = tankInfo[2] - '0';

        int r = tRow + dx[idx];
        int c = tCol + dy[idx];

        // 맵을 벗어나면 return
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) return;

        // 1. 다음 전진 할 방향이 평지이면 해당 칸으로 이동
        // 2. 이전에 있던 위치는 평지로 매핑
        // 3. 이동 한 위치 tankInfo에 저장
        if (map[r][c] == '.') {
            map[tRow][tCol] = '.';
            map[r][c] = tankDir;
            tankInfo[0] = tankDir;
            tankInfo[1] = (char) (r + '0');
            tankInfo[2] = (char) (c + '0');
        }

    }


}



