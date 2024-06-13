import java.util.*;
import java.io.*;

public class Main {

    static int comCnt, netWork;
    static List[] list;
    static Set<Integer> answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        comCnt = Integer.parseInt(br.readLine());
        netWork = Integer.parseInt(br.readLine());

        list = new List[comCnt+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<netWork;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        answer = new HashSet<>();
        answer.add(1);

        solution();
        System.out.println(answer.size()-1);

    }

    static void solution() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while (!queue.isEmpty()){
            int idx = queue.poll();
            ArrayList<Integer> getList = (ArrayList) list[idx];
            for (int i = 0; i < getList.size(); i++) {
                int x = getList.get(i);
                if (answer.contains(x)) continue;
                answer.add(x);
                queue.offer(x);
            }
        }
    }
}