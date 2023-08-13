package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미로 탐색
 * https://www.acmicpc.net/problem/2178
 */
public class 백준 {


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\00.project\\algorithm\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * BFS
     * 처음부터 시작
     * 우측으로 열 조건판단 1이면 queue에 쌓기 아니면 밑으로
     */

}