package 인프런.section4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/04-05
 */
public class _05_K번째큰수 {
    static int N;
    static int[] numArr;
    static int[] temp = new int[3];
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
    public static void main(String[] args) throws Exception{
        /*
        * 1~100 N장 카드
        * 같은 숫자 여러장
        * N장중 3장 드롭 => sum 값 기록
        * 3장뽑을 수 있는 모든 경우 기록
        * 기록한값중 K번째로 큰 수
        * ...=> 모든 경우의수의 합을 구한뒤 배열에 넣고 정렬 후 K-1 인덱스 뽑기
        * n! / (n-r)!
        *  */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        combination(0,0);
        int c = 1;
        int topNum = pq.poll();
        while (pq.peek()!=null) {
            if (c == 3) break;
            if (topNum != pq.peek()) {
                c++;
            }
            topNum = pq.poll();
        }
        c = c == 1 ? -1 : topNum;
        System.out.println(c);
    }

    static void combination(int cnt,int start) {
        if (cnt == 3) {
            int sum = 0;
            for (int x : temp) {
                sum += x;
            }
            pq.add(sum);
            return;
        }
        // n-1C3-1
        for (int i = start; i < N; i++) {
            temp[cnt] = numArr[i];
            combination(cnt + 1, i + 1);
        }
    }
}
