import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            list.add("0");
            for (int j = 0; j < N; j++) {
                list.add(br.readLine());
            }
            sb.append("#").append(i).append(' ').append(bfs(list) ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }


    /**
     * @return true면 계산 가능
     *         false면 계산 불가능
     */
    static boolean bfs(List<String > list) {
        // 순서를 정해주기 위해 queue 사용
        Queue<Integer> queue = new ArrayDeque<>();
        boolean answer = true;
        int lastIndex = list.size()-1;
        String[] str = list.get(1).split(" ");
        int root = Integer.parseInt(str[0]);
        String s = str[1];
        boolean prevStat = isNumber(s);
        // 루트노드 1 삽입
        queue.offer(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            if (isNumber(list.get(cur).split(" ")[1])) {
                if (cur * 2 <= lastIndex || cur*2+1 <= lastIndex) return false;
            } else {
                if (cur*2 > lastIndex) return false;

                if (cur * 2 <= lastIndex) queue.offer(cur * 2);
                if (cur * 2+1 <= lastIndex) queue.offer(cur * 2 + 1);
            }
        }
        return answer;
    }

    static boolean isNumber(String str) {
        return str != null && str.matches("^[0-9]*$");
    }

}
