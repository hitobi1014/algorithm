package 인프런.section4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://cote.inflearn.com/contest/10/problem/04-05
 */
public class _05_K번째큰수 {
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
        System.setIn(new FileInputStream("D:\\00.project\\algorithm\\src\\main\\java\\인프런\\inflearn.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(infSolution(numArr,N,K));

//        combination(0,0);
//
//        int c = 1;
//        list.sort((o1, o2) -> Integer.compare(o2,o1));
//        int topNum = list.get(0);
//        while (list.get(0)!=null) {
//            if (c == 3) break;
//            if (topNum != list.get(0)) {
//                c++;
//            }
//            topNum = list.get(0);
//            list.remove(0);
//        }
//        c = c == 1 ? -1 : topNum;
//        System.out.println(c);
    }


    /**
     * 인프런 풀이 TreeSet 이용
     * 순서상관x => 조합 , 재귀함수이용x 반복문o
     */
    static int infSolution(int[] arr, int n, int K) {
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt=0;

        for (int x : Tset) {
            cnt++;
            if (cnt == K) return x;
        }
        return answer;
    }

//    static void combination(int cnt,int start) {
//        if (cnt == 3) {
//            int sum = 0;
//            for (int x : temp) {
//                sum += x;
//            }
//            list.add(sum);
//            return;
//        }
//        // n-1C3-1
//        for (int i = start; i < N; i++) {
//            temp[cnt] = numArr[i];
//            combination(cnt + 1, i + 1);
//        }
//    }
}
