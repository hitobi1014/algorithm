package test;

import java.io.*;
import java.util.*;

/**
 * line1. tc 개수
 * line2. 숫자 개수 N
 * line3. 연산 개수 => + - * / (순서대로 작성)
 * line4. N개의 숫자
 */
public class Swea {
    static int N, minN, maxN;
    static char[] ops, temp;
    static int[] numArr;
    static Deque<Integer> queue;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\MJ\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();

        for (int t=1; t<=tc; t++){
            N = Integer.parseInt(br.readLine()); // 숫자 개수
            StringTokenizer calcSt = new StringTokenizer(br.readLine());
            ops = new char[N-1]; // 연산자 개수
            temp = new char[N-1]; // 연산자 개수
            numArr = new int[N];
            queue = new ArrayDeque<>();

            int idx = 0;
            int cIdx = 0;
            while (calcSt.hasMoreTokens()){
                int num = Integer.parseInt(calcSt.nextToken());
                char c = ' ';
                if (idx == 0){
                    c = '+';
                } else if (idx == 1){
                    c = '-';
                } else if (idx == 2){
                    c = '*';
                } else {
                    c = '/';
                }
                for (int i=0; i<num; i++) {
                    ops[cIdx++] = c;
                }
                idx++;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 숫자 입력
            for (int i=0; i<N; i++){
                numArr[i] = Integer.parseInt(st.nextToken());
//                queue.offer(Integer.parseInt(st.nextToken()));
            }
            // 로직처리
            minN = Integer.MAX_VALUE;
            maxN = Integer.MIN_VALUE;

            boolean[] visited = new boolean[N-1];
            permutation(visited, 0);
            System.out.printf("#%d %d\n", t, (maxN - minN));
//            sb.append('#').append(t).append(maxN-minN).append('\n');
        }

//        System.out.println(sb.toString());
    }

    private static void permutation(boolean[] visited, int cnt){
        if (cnt == N-1) {
            // queue 입력
            for (int x : numArr) queue.offer(x);

            // 숫자 2개 poll => 연산 수행 => firstoffer
            for (int i=0; i<temp.length; i++){
                int a = queue.poll();
                int b = queue.poll();

                switch (temp[i]) {
                    case '+':
                        queue.offerFirst(a+b);
                        break;
                    case '-':
                        queue.offerFirst(a-b);
                        break;
                    case '*':
                        queue.offerFirst(a*b);
                        break;
                    case '/':
                        queue.offerFirst(a/b);
                        break;
                }
            }

            int poll = queue.poll();
            minN = Math.min(minN, poll);
            maxN = Math.max(maxN, poll);
            return;
        }

        // 같은 부호에 대해 중복 순열 처리
        for (int i = 0; i < N - 1; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            temp[cnt] = ops[i];

            permutation(visited, cnt+1);

            visited[i] = false;
        }
    }
}