package ing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * plates: 초밥벨트 위 접시 수
 * kindSushi: 초밥 가짓수
 * continueEat: 연속해서 먹는 접시 수
 * cupon: 쿠폰번호
 * line 1 : N d k c
 * line 2 : N개의 줄 벨트의 한 위치부터 시작-> 회전 방향 따라갈때 초밥 종류 나타내는 1이상 d이하 정수가 각 줄마다 주어짐
 * ### 번호에 적힌 초밥이 없을 경우 요리사가 새로만들어 제공..
 * ### 서로 다른 초밥 먹기
 */
public class B15961_회전초밥 {
    static int plates, kindSushi, continueEat, cupon;
    static int[] sushi;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        plates = sToN.apply(st.nextToken());
        kindSushi = sToN.apply(st.nextToken());
        continueEat = sToN.apply(st.nextToken());
        cupon = sToN.apply(st.nextToken());

        sushi = new int[plates];
        for (int i = 0; i < plates; i++) {
            sushi[i] = sToN.apply(br.readLine());
        }
    }

    // 1. 쿠폰번호를 기준으로 쿠폰번호 개수만큼 돌기
    //  1.1 쿠폰번호가 없다면 lt, rt(lt+1) 부터 k연속만큼 먹을 수 있는지 확인하기 있다면 k출력
    private static void maxEat() {
        // 쿠폰번호가 포함 된 접시개수 찾기
        int cpIncludeCnt = (int) IntStream.of(sushi).filter(n-> n == cupon).count();

        // 쿠폰이 없으면 (1.1번 상황)
        if (cpIncludeCnt==0){
            int lt = 0, rt = lt + 1;
//            int eatCnt = 0;
            Set<Integer> setChk = new HashSet<>();

            while (setChk.size() <= continueEat && rangeCheck(lt,rt)) {
                if (sushi[lt]==sushi[rt]) {
                    lt++;
                    rt++;
                    continue;
                }
                setChk.add(sushi[lt]);
                setChk.add(sushi[rt]);
                // 다음..
            }
        } else {
            int lt,rt;
            for (int i = 0; i < cpIncludeCnt; i++) {


            }

        }
    }

    private static boolean rangeCheck(int lt, int rt) {
        if (lt < 0 || rt >= sushi.length || lt > rt) return false;
        return true;
    }

}