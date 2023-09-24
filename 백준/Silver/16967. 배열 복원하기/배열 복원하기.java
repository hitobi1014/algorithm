import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {
    static int H,W,X,Y;
    static int[][] A, B;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        A = new int[H][W];
        B = new int[H + X][W + Y];

        for (int i=0; i<B.length; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<B[i].length; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void answer(){
        // 겹치지 않는 부분
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = B[i][j];
            }
        }
        for (int i = X; i < H; i++) {
            for (int j = 0; j < Y; j++) {
                A[i][j] = B[i][j];
            }
        }

        // 겹치는 부분
        for (int i = X; i < H; i++) {
            for (int j = Y; j < W; j++) {
                A[i][j] = B[i][j] - A[i - X][j - Y];
            }
        }

    }
}