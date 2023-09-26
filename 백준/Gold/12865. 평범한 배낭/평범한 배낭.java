import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {
    static int N, K;
    static int[][] map;
    static class Bag {
        int weight;
        int value;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][K+1];

        Bag[] bags = new Bag[N+1];
        for (int i = 1; i < N+1; i++) {
            bags[i] = new Bag();
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            bags[i].weight = weight;
            bags[i].value = value;
        }

        knapsack(bags);

        System.out.println(map[N][K]);
    }

    static void knapsack(Bag[] bags){
        for (int i = 1; i < N+1; i++) {
            Bag getBag = bags[i];
            int weight= getBag.weight;
            int value = getBag.value;

            for (int j = 1; j < K+1; j++) {
                // 현재 가방의 무게가 최대무게를 넘을때
                if (j < weight){
                    map[i][j] = map[i-1][j];
                }
                else  {
                    map[i][j] = Math.max((value + map[i - 1][j-weight]), map[i - 1][j]);
                }
            }
        }
    }
}