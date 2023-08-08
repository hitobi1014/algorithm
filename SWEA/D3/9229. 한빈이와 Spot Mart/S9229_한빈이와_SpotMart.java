package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S9229_한빈이와_SpotMart {
    static int[] selectNum;
    static int max, limit;
    static List<Integer> list;
    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("D:\\00.project\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            max = Integer.MIN_VALUE;
            selectNum = new int[2];
            combination(0, 0);
            max = max < 0 ? -1 : max;
            sb.append("#").append(i).append(" ").append(max).append('\n');
        }

        System.out.println(sb);
    }

    static void combination(int cnt, int start) {
        if (cnt == 2) {
            int sum = 0;
            for (int x : selectNum) sum += x;
            if (max < sum && sum <= limit) max = sum;
            return;
        }

        for (int i = start; i < list.size(); i++) {
            selectNum[cnt] = list.get(i);
            combination(cnt + 1, i + 1);
        }
    }

}
