package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Swea {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\MJ\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            int originPassLength = Integer.parseInt(br.readLine());
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int commandCnt = Integer.parseInt(br.readLine());

            String[] strArr = br.readLine().split("I");

            for (int j = 1; j < strArr.length; j++) {
                int[] numArr = Arrays.stream(strArr[j].trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println(Arrays.toString(numArr));
            }

        }

    }

}




