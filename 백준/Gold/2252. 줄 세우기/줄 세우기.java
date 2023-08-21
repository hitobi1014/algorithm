import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Main {
    static int N, M, students[];
    static List[] vertexList;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> sToN = Integer::parseInt;

        // N:학생수 , M:비교한 횟수
        N = sToN.apply(st.nextToken());
        M = sToN.apply(st.nextToken());

        // M개줄 A, B => A<B (A는 B보다 작음)  .. 학생 번호 1~N
        vertexList = new List[N+1];
        visited = new boolean[N + 1];
        students = new int[N + 1];

        for (int i = 0; i < vertexList.length; i++) {
            vertexList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = sToN.apply(st.nextToken());
            int B = sToN.apply(st.nextToken());
            students[B] += 1;
            vertexList[A].add(B);
        }
        bfs();

        System.out.println();
    }

    private static void bfs() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        int start = 0;
        for (int i = 1; i < students.length; i++) {
            if(students[i] == 0){
                queue.offer(i);
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int curVertex = queue.poll();
            sb.append(curVertex).append(' ');

            ArrayList<Integer> getList = (ArrayList<Integer>) vertexList[curVertex];
            for (Integer val : getList) {
                students[val] -= 1; // 차수 -1
                if (students[val] == 0) {
                    queue.offer(val);
                    visited[val] = true;
                }
            }
        }
        System.out.println(sb.toString());
    }

}