package test;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 *
 */
public class 백준 {
    static int[][] arr;
    static int[] numMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        /**
         * 비교
         * 1. 행
         * 2. 열
         * 3. 영역
         */


    }

    static void 스도쿠(){
        Set<Integer> num = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            num.add(i);
        }

        // 행
        // 열은 나중에..
        for (int r = 0; r < 9; r++) {
            if(arr[r][1] != 0){
                num.remove(arr[r][1]);
            }
        }

        // 열
        for (int c = 0; c < 9; c++) {
            if(arr[1][c] != 0){
                num.remove(arr[1][c]);
            }
        }

        int row = 0; // 받은 row
        int col = 0; // 받은 col

        // 영역
        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                if(arr[i][j] != 0){
                    num.remove(arr[i][j]);
                }
            }
        }



    }
}