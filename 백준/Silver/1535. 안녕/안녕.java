import java.util.*;
import java.io.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 1~N명
 * 체력 MAX 100
 * 최대 한 사람한테 인사 1번
 * 인사 => -체력 +기쁨
 * 체력은 0이나 음수가되면 x
 * 최대 기쁨 얻을 수 있는 값 출력
 * line1 사람수
 * line2 -체력
 * line3 + 기쁨
 */
public class Main {
    static int answer, N;
    static int[] hpArr, happyArr;
    static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hpArr = new int[N];
        happyArr = new int[N];
        visited = new boolean[N];

        hpArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        happyArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        answer = Integer.MIN_VALUE;
        combination(0, 100);
        System.out.println(answer);
    }


    private static void combination(int startIdx, int curHp) {
        if (curHp > 0) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if(visited[i]){
                    sum += happyArr[i];
                }
            }
            if (answer < sum) {
                answer = sum;
            }
        }

        for (int i = startIdx; i < N; i++) {
            // hp 잃는 수치가 100이상이거나 방문했으면 다음 단계
            if (hpArr[i] >= 100 || visited[i]) continue;

            // 해당 idx 방문 체크
            visited[i] = true;
            combination(i+1, curHp - hpArr[i]);
            visited[i] = false;

        }
    }
}