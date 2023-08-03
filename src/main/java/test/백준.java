package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 12891 - DNA 비밀번호
 */
public class 백준 {

    //DNA문자 => A C G T
    // 부분문자열 문자 개수가 특정 개수 이상이어야 사용 가능
    static char[] checkDna = {'A', 'C', 'G', 'T'};
    static char[] cArr;
    static int[] checkCnt = new int[4];
    static boolean[] isSelected;
    static int S,P, answer;
    static Map<Character, Integer> checkMap = new HashMap<>();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\MJ\\src\\main\\java\\test\\text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 임의로만든 문자열 길이
        S = Integer.parseInt(st.nextToken());
        // 비밀번호로 사용할 문자열 길이
        P = Integer.parseInt(st.nextToken());
        String dnaStr = br.readLine();
        st = new StringTokenizer(br.readLine());
        cArr = dnaStr.toCharArray();

        for (int i = 0; i < checkDna.length; i++) {
            checkMap.put(checkDna[i], Integer.parseInt(st.nextToken()));
        }

        solution();
        System.out.println(answer);

    }

    private static void solution(){
        char[] temp = new char[P];
        int lt=0,rt=P-1;
        for (int i = 0; i <= P; i++) {
            char x = cArr[i];
            if (x == checkDna[0]) checkCnt[0]++;
            if (x == checkDna[1]) checkCnt[1]++;
            if (x == checkDna[2]) checkCnt[2]++;
            if (x == checkDna[3]) checkCnt[3]++;
        }
//        static char[] checkDna = {'A', 'C', 'G', 'T'};
//        static char[] cArr;
//        static int[] checkCnt = new int[4]; ... 또륵


        while (rt-lt <= P) {
            String str = String.copyValueOf(temp);
            boolean flag = true;

            for (Map.Entry<Character, Integer> entry : checkMap.entrySet()) {
                int charCnt = str.length() - str.replace(String.valueOf(entry.getKey()), "").length();
                if (charCnt < entry.getValue()) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
            lt++;
            rt++;

            if (rt >= cArr.length) break;
            temp[0] = cArr[lt];
            temp[P-1] = cArr[rt];
        }

    }

    private static boolean checkDna() {

        return false;
    }

}
