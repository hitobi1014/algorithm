package 인프런.section4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/04-05
 */
public class _05_K번째큰수 {
    static int N, K;
    static int[] numArr;
    static boolean[] isCheck;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        /*
        * 1~100 N장 카드
        * 같은 숫자 여러장
        * N장중 3장 드롭 => sum 값 기록
        * 3장뽑을 수 있는 모든 경우 기록
        * 기록한값중 K번째로 큰 수
        * ...=> 모든 경우의수의 합을 구한뒤 배열에 넣고 정렬 후 K-1 인덱스 뽑기
        *  */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numArr = new int[N];
        isCheck = new boolean[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void permutation(int idx) {
        // n-1C3-1
        for (int i = 0; i < idx; i++) {
            if(isCheck[i]) continue;

        }
    }
}
