import java.io.*;
import java.util.*;

/**
 */
public class Solution {
    static boolean[] visited;
    static int N, M;
    static ArrayList[] personList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i=1; i<= tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            personList = new ArrayList[N+1];
            for (int j=0; j< personList.length; j++){
                personList[j] = new ArrayList<Integer>();
            }

            visited = new boolean[N+1];
            // 받은 값 입력
            for (int j=0; j<M;j++){
                st = new StringTokenizer(br.readLine());
                int cur = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());

                personList[cur].add(next);
                personList[next].add(cur);
            }

            int answer = 0;
            // bfs
            for (int j = 1; j < personList.length; j++) {
                if (visited[j]) continue;
                answer++;
                dfs(j);
                visited[j] = true;
            }

            System.out.printf("#%d %d\n",i, answer);
        }
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        for(Integer p : (ArrayList<Integer>) personList[idx]){
            if(visited[p]) continue;
            dfs(p);
        }
    }
}