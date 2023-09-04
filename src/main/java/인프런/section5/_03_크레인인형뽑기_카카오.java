package 인프런.section5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 2차원 배열 board => 격자 상태
 * 크레인 위치 moves
 */
public class _03_크레인인형뽑기_카카오 {
    static int N, M;
    static int[][] board;
    static int[] moves;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N+1][N+1];

        // board 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // moves 입력
        M = Integer.parseInt(br.readLine());
        moves = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(someDolls());
    }

    private static int someDolls(){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        A:for (int k = 0; k < moves.length; k++) {
            int num = moves[k];
            for (int i = 1; i < N+1; i++) {
                int getN = board[i][num];
                if (getN == 0) continue;
                board[i][num] = 0;

                if (!stack.isEmpty() && stack.peek() == getN) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(getN);
                }
                continue A;
            }
        }

        return answer;
    }
}
