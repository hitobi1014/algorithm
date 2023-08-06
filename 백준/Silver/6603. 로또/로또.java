import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int k;
    static int[] s;
    static int[] result;
    static boolean[] isSelected;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            s = new int[k];
            for (int i = 0; i < k; i++) s[i] = Integer.parseInt(st.nextToken());
            // 비트마스킹
//            solution(k, s);
//            sb.append('\n');

            // 재귀
            result = new int[6];
            isSelected = new boolean[k];
            solution2(0,0);
            sb.append('\n');

        }
//        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }

    // 재귀이용
    static void solution2(int start, int depth) {
        if (depth == 6) {
            for (int x : result) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < k; i++) {
            if (isSelected[i]) continue;

            isSelected[i] = true;
            result[depth] = s[i];
            solution2(i, depth + 1);
            isSelected[i] = false;
        }

    }

//    static void solution(int k, int[] s) {
//        // i : 0부터 배열크기인 k개 시프트한 수까지 반복 (2의 k승 -1)
//        for (int i = 0; i < 1 << k; i++) {
//            // 6자리까지 비트마스킹을 하면 조건충족됐으므로 배열 인덱스에 맞는 수 추출
//            if (Integer.bitCount(i) == 6) {
//                for (int j = 0; j < s.length; j++) {
//                    if ((i & (1 << j)) > 0){
//                        sb.append(s[j]).append(' ');
//                    }
//                }
//                sb.append('\n');
//            }
//        }
//    }

}