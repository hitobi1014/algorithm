import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    static int N, M, cnt;
    static List[] list;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = sToN.apply(st.nextToken());
        M = sToN.apply(st.nextToken());
        list = new List[N];
        visited = new boolean[N];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = sToN.apply(st.nextToken());
            int b = sToN.apply(st.nextToken());

            list[a].add(new Integer(b));
            list[b].add(new Integer(a));
        }

//        int start = -1;
        int answer = 0;
        for (int i = 0; i < list.length; i++) {
//            if(list[i].size()>0){
//                start = i;
//                break;
//            }
            visited[i] = true;
            if(dfs(i)) {
                answer = 1;
                break;
            }
            visited[i] = false;
        }
//        int answer = dfs(start) ? 1 : 0;
        System.out.println(answer);
    }

    private static boolean dfs(int startIdx) {
        // 친구 연결고리 4개이상이면 true
        if (cnt >=4) return true;

        ArrayList<Integer> getList = (ArrayList<Integer>) list[startIdx];
        if (getList.size() < 1) return false;

        //        cnt++;
//        visited[startIdx] = true;

        for (int i = 0; i < getList.size(); i++) {
            int getVertex = getList.get(i);
            if (visited[getVertex]) continue;
            visited[getVertex] = true;
            cnt++;

            if(dfs(getVertex)) return true;

            visited[getVertex] = false;
            cnt--;
        }
        return false;
    }

}