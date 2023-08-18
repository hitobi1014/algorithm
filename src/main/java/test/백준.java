package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class 백준 {
    static int N, M, V;
    static List<ArrayList<Integer>> list;
    static boolean[] visited; // BFS 방문체크
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\MJ\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= M; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int firstVertext = Integer.parseInt(st.nextToken());
            int secondVertext = Integer.parseInt(st.nextToken());
            list.get(firstVertext).add(secondVertext);
//            list.add(firstVertext, new int[]{firstVertext, secondVertext});
        }

        bfs();
    }

    private static void bfs() {
        Queue<List> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        visited = new boolean[list.size()];
        // 1부터시작
        queue.offer(list.get(1));
        visited[1] = true;
        answer.add(list.get(1).get(1));

        while (!queue.isEmpty()) {
            ArrayList<Integer> getList = (ArrayList<Integer>) queue.poll();

            for (int i = 0; i < getList.size(); i++) {
                int next = getList.get(i);
                if(next != 0 && !visited[next]){
                    answer.add(next);
                    queue.offer(list.get(next));
                    visited[next] = true;
                }
            }
        }


        answer.forEach(System.out::println);

    }

    private static void dfs() {

    }



}
