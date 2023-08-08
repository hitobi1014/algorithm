package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class 백준 {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\MJ\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] bingo = new int[5][5];

        for (int i = 1; i < bingo.length; i++) {
            bingo[i] = Stream.of(br.readLine(), " ").mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(Arrays.deepToString(bingo));
    }




}
