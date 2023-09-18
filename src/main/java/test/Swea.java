package test;

import java.io.*;
import java.util.*;

/**
 */
public class Swea {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i=1; i<= tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List[] personList = new List[N+1];
            for (int j=0; j< personList.length; j++){
                personList[j] = new LinkedList<Integer>();
            }

            // 받은 값 입력
            for (int j=0; j<M;j++){
                st = new StringTokenizer(br.readLine());
                int cur = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());

                personList[cur].add(next);
                personList[next].add(cur);
            }
        }
    }
}