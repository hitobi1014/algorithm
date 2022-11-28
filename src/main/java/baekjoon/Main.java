package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numArr = new int[10]; // 나머지 저장 배열
        int count = 0;
        boolean equal;

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(br.readLine()) % 42;
        }

        for (int i = 0; i < numArr.length; i++) {
            equal = false;
            for (int j = i + 1; j < numArr.length; j++) {
                if (numArr[i] == numArr[j]) {
                    equal = true;
                    break;
                }
            }
            if (!equal) count++;
        }

    }
}