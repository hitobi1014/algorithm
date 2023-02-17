package baekjoon.bronze.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ACM호텔
 * https://www.acmicpc.net/problem/10250
 */
public class Bronze2_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        // 몫은 호수
        // 나머지는 층수
        for (int i = 0; i < testcase; i++) {
            String[] str = br.readLine().split(" ");
            int h = Integer.parseInt(str[0]);
            int n = Integer.parseInt(str[2]);

            int floor = n % h == 0 ? h : n % h;
            int room = n == h ? n / h : (n / h) + 1;
            String roomNumber = String.format("%02d", room);
            answer.append(floor).append(roomNumber).append("\n");
        }

        System.out.println(answer);
    }
}
