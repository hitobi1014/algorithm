import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer=Integer.MAX_VALUE, n;
    static boolean[] isSelected;
    static int[][] sbArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        sbArr = new int[n][2];
        isSelected = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sbArr[i][0] = Integer.parseInt(st.nextToken());
            sbArr[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(0,0,0,0);
        System.out.println(answer);
    }

    private static void solution(int multi, int sum, int cnt, int selectedCnt){
        if (cnt == n) {
            if (selectedCnt > 0) {
                answer = Math.min(answer, Math.abs(multi - sum));
            }
            return;
        }
        int s = sbArr[cnt][0];
        int b = sbArr[cnt][1];

        isSelected[cnt] = true;
        solution(multi != 0 ? multi*s : s, sum+b, cnt + 1, selectedCnt+1);
        isSelected[cnt] = false;
        solution(multi, sum, cnt + 1, selectedCnt);
    }

}