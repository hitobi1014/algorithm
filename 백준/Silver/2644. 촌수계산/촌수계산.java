import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 촌수계산
 * n: 전체 사람수
 * m: 자식관계 개수
 * line 1. n
 * line 2. 찾아야 할 관계 (x,y) m
 * line 3. m개의 관계 개수 (x,y)
 */
public class Main {
    static int n, m, cnt, answer;
    static List[] relations;
    static boolean[] visited;
    static int x, y;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        n = sToN.apply(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 찾아야 할 관계
        x = sToN.apply(st.nextToken());
        y = sToN.apply(st.nextToken());
        visited = new boolean[n + 1];
        visited[x] = true;
        answer = -1;

        // 관계 수
        m = sToN.apply(br.readLine());
        // list 초기화
        relations = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            relations[i] = new LinkedList<Integer>();
        }

        // 관계 지정
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = sToN.apply(st.nextToken());
            int b = sToN.apply(st.nextToken());

            // 무향 그래프 값 넣기
            relations[a].add(b);
            relations[b].add(a);
        }

        dfs(x, 0);
        System.out.println(answer);

    }

    private static boolean dfs(int vertex, int cnt) {
        if (vertex == y) {
            answer = cnt;
            return true;
        }
        LinkedList<Integer> getList = (LinkedList<Integer>) relations[vertex];

        for (int i = 0; i < getList.size(); i++) {
            int getVertext = getList.get(i);
            if(!visited[getVertext]){
                visited[getVertext] = true;
                if (dfs(getVertext, cnt + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}