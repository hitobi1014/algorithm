package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int line = 0;
        int num = 0;

        for (int i = 0; i < 9; i++) {
            num = Integer.parseInt(br.readLine());
            if (max < num) {
                max = num;
                line++;
            }
        }

        System.out.print(max + "\n" + line);
    }
}