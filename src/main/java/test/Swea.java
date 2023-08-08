package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea {
    static int[][] bingo;
    static boolean[][] checkBingo;
    static int answer;
    static int call;

    // 상하좌우 좌상 좌하 우상 우하
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\MJ\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        bingo = new int[6][6];
        checkBingo = new boolean[6][6];

        for (int i = 1; i < bingo.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < bingo[i].length; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        A:for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int callNum = Integer.parseInt(st.nextToken());
                call++;
                modifyMap(callNum);
                if (answer>=3) break A;
            }
        }

        System.out.println(call);
    }

    static void modifyMap(int callNum) {
        for (int i = 1; i < checkBingo.length; i++) {
            for (int j = 1; j < checkBingo[i].length; j++) {
                if (bingo[i][j]==callNum){
                    checkBingo[i][j] = true;
                    checkMap(i, j);
                    return;
                }
            }
        }
    }

    static void checkMap(int row, int col) {
        int idx = 0;
        int trueCheck = 0;

        while (idx < 8) {
            int r = row - dx[idx];
            int c = col - dy[idx];

            if (r == 0 || r == 6 || c == 0 || c == 6 || !checkBingo[r][c]) {
                idx++;
                trueCheck = 0;
                continue;
            }

//            if(checkBingo[r][c]) break;
            ++trueCheck;
            System.out.println(trueCheck);
            if (trueCheck != 1 && 4 % trueCheck == 0) answer++;
        }


    }



}




