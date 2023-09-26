import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {
    static int[][] arr;

    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if(arr[i][j]==0) list.add(new int[]{i, j});
            }
        }

        sudoku(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);


    }

    static boolean sudoku(int cnt){
        if (cnt == list.size()) return true;

        int x = list.get(cnt)[0];
        int y = list.get(cnt)[1];
        for (int i = 1; i < 10; i++) {
            arr[x][y] = i;
            if(isValid(x,y) && sudoku(cnt+1)) return true;
        }

        arr[x][y] = 0;
        return false;

    }

    static boolean isValid(int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (i !=k && arr[k][j]==arr[i][j]) return false;
            if (j!=k && arr[i][k] == arr[i][j])return false;
        }


        for (int nr = (i / 3) * 3, k = 0; k < 3; k++, nr++) {
            for (int nc = (j / 3) * 3, l = 0; l < 3; nc++, l++) {
                if(nr != i && nc != j && arr[nr][nc]==arr[i][j])return false;
            }
        }

        return true;
    }
}