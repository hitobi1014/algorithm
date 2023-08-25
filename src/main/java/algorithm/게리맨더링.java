package algorithm;

import com.sun.java.accessibility.util.java.awt.ListTranslator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 *
 * line1. 구역 개수N
 * line2. 1~N구역 순서대로 인구수
 * line3. N개의 줄 각 구역과 인접한 구역의 정보
 *        - 첫번째 정수: 구역과 인접한 구역의 수
 *        - 두번째~ : 인접한 구역 번호
 *        A<->B 무향 그래프
 */
public class 게리맨더링 {
//    static class City{
//        int next; // 다음 정점
//        City city;
//        public City(int next, City city) {
//            this.next = next;
//            this.city = city;
//        }
//    }

    static  List[] cityList;
    static int N, totalAdjCnt, answer;
    static boolean[] visited;
    static int[] parents;

    static Map<Integer, Integer> people;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\MJ\\project\\algorithm\\src\\main\\java\\algorithm\\게리맨더링tc.txt"));

        // 정점 나누기 => 반으로 나눠서 인구수 차이가 최소가 되게
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 인구수
        people = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            people.put(i, Integer.parseInt(st.nextToken()));
        }

        // 노드 초기화
        cityList = new List[N + 1];
        visited = new boolean[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cityList[i] = new ArrayList<Integer>();
        }

        // 노드 간선정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int adjCnt = Integer.parseInt(st.nextToken());
            totalAdjCnt += adjCnt; // 총 간선수
            if(adjCnt == 0) continue; // 연결정보가 없으면 continue

            // 인접 정점 추가
            for (int j = 0; j < adjCnt; j++) {
                cityList[i].add(Integer.parseInt(st.nextToken()));
            }

        }

        answer = Integer.MAX_VALUE;
        // dfs
        for (int i = 1; i < cityList.length; i++) {
            make(N);
            dfs(i);
        }


        // 총 간선수는 앞자리 정수+= /2
        System.out.println();
    }

    private static boolean dfs(int start) {
        // 서로소 집합이 2개가 되었을때 minimum  구하기
        int[] arr = Arrays.stream(parents).distinct().toArray();
        if (arr.length == 3) {
            int a=0,b=0;
            for (int i = 1; i < parents.length; i++) {
                if (parents[i] == arr[1]) {
                    a += people.get(i);
                } else if (parents[i] == arr[2]) {
                    b += people.get(i);
                }
            }
            answer = Math.min(answer, Math.abs(a-b));
            return true;
        }

        ArrayList<Integer> getList = (ArrayList<Integer>) cityList[start];
        // 유도 파트
        for (int i = 0; i < getList.size(); i++) {
            int getVertex = getList.get(i);
            if(union(start,getVertex)){
                if(dfs(getVertex)) {
                    break;
                };
            };
        }
        return true;
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        // 노드가 더 작은쪽으로 합치기
        if (aRoot > bRoot) {
            parents[aRoot] = bRoot;
        } else {
            parents[bRoot] = aRoot;
        }
        return true;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void make(int x){
        parents = IntStream.iterate(0, i -> i + 1).limit(x+1).toArray();
    }

}
