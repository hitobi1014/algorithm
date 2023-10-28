import java.io.*;
import java.util.*;
import java.util.stream.*;

class Solution {
    static public int[] solution(String[][] places) {
        int[] answer = new int[5];

        //대기실정보 input, 대기실 5개, 5*5배열
        for (int i=0; i<5; i++){
            char[][] map = new char[5][5];
            ArrayList<int[]> positions = new ArrayList<>();

            for (int row=0; row<5; row++){
                String str = places[i][row];
                for (int col = 0; col < 5; col++) {
                    char c = str.charAt(col);
                    map[row][col] = c;
                    if (c == 'P') positions.add(new int[]{row, col});
                }
            }

            int size = positions.size();
            boolean[][] visited = new boolean[size][size];
            int num = 1;
            //응시자수만큼 반복
            for (int pIdx=0; pIdx<size; pIdx++){
                if(!checkPerson(pIdx, positions, visited, map)) {
                    num = 0;
                    break;
                };
            }
            answer[i] = num;

        }
        return answer;
    }

    static boolean checkPerson(int idx, ArrayList<int[]> ps, boolean[][] vis, char[][] map){
        int[] curPos = ps.get(idx);
        int curX = curPos[0];
        int curY = curPos[1];

        for (int i=idx+1; i<ps.size(); i++){
            int[] nextPos = ps.get(i);
            int nextX = nextPos[0];
            int nextY = nextPos[1];

            int diffX = Math.abs(curX - nextX);
            int diffY = Math.abs(curY - nextY);

            if(vis[idx][i]) continue; // 이미 양방향 체크가 된 상황이면 pass

            //STEP01. 맨해튼 거리 체크
            if (diffX+diffY <= 2)
            {
                //STEP02. 벽이 있는지 확인
                if (curX == nextX) {
                    if (map[curX][curY+1] != 'X') return false;

                } else if (curY == nextY) {
                    if (map[curX+1][curY] != 'X') return false;
                } else {

                    if(map[curX][nextY] != 'X'
                            || map[nextX][curY] != 'X') return false;
                }
            }
            vis[idx][i] = true;
            vis[i][idx] = true;
        }

        return true;
    }
}