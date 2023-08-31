package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * depth > 1 이면 return 하기
 * 방문체크, 방문하지 않았으면 카운트 증가와 dfs 보내기
 * line1. N
 * line2. N*N char 문자
 * 필요: char[][], 답 출력 answer
 */
public class 백준 {
    static char[][] friends;
    static int N;
    static LinkedList[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        friends = new char[N][N];
        list = new LinkedList[N];


        for (int i = 0; i < N; i++) {
            list[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char x = str.charAt(j);
                if (x == 'Y') {
                    list[i].add(j);
                }
            }
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i].size() > 0) {
                visited = new boolean[N];
                visited[i] = true;
                answer = Math.max(answer, dfs(i, 0, 0));
            }
        }
        System.out.println(answer);
    }

    private static int dfs(int idx, int depth, int accrue) {
        if (depth > 1) {
            return accrue;
        }
        LinkedList getList = list[idx];

        for (int i = 0; i < getList.size(); i++) {
            int curIdx = (int) getList.get(i);
            if(visited[curIdx]) continue;
            visited[curIdx] = true;
//            visited[idx] = false;
            accrue = dfs(curIdx, depth + 1, accrue + 1);
//            visited[curIdx] = false;
        }

        return accrue;
    }
}
