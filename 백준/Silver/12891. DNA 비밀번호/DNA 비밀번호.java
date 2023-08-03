import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static char[] cArr;
    static int[] checkCnt = new int[4];
    static int[] my = new int[4];
    static boolean[] isSelected;
    static int S,P, answer;
    static Map<Character, Integer> checkMap = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        String dnaStr = br.readLine();
        cArr = dnaStr.toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < checkCnt.length; i++) {
            checkCnt[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.println(answer);

    }

    private static void solution(){
        for (int i = 0; i < P; i++) {
            if (cArr[i] == 'A') my[0]++;
            if (cArr[i] == 'C') my[1]++;
            if (cArr[i] == 'G') my[2]++;
            if (cArr[i] == 'T') my[3]++;
        }

        checkDna();

        for (int rt = P; rt < cArr.length; rt++) {
            int lt = rt - P;
            if (cArr[lt] == 'A') my[0]--;
            if (cArr[lt] == 'C') my[1]--;
            if (cArr[lt] == 'G') my[2]--;
            if (cArr[lt] == 'T') my[3]--;

            if (cArr[rt] == 'A') my[0]++;
            if (cArr[rt] == 'C') my[1]++;
            if (cArr[rt] == 'G') my[2]++;
            if (cArr[rt] == 'T') my[3]++;
            checkDna();
        }

    }

    private static void checkDna() {
        for (int i = 0; i < checkCnt.length; i++) {
            if (my[i] < checkCnt[i]) return;
        }
        answer++;
    }

}