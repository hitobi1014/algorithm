import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1244 스위치 켜고끄기
 * 스위치 켜짐 =>1 /... 스위치 꺼짐 => 0
 * 남 => 자기가 받은 수의 배수면 스위치 상태 변경
 * 여 => 가장 많은 스위치를 포함하는 구간 상태 변경, 구간에 속한 스위치 개수 홀수
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] switchArr;

    public static void main(String[] args) throws Exception{
        /*
        * input1 스위치 개수
        * input2 스위치 상태
        * input3 학생수
        * input4~N 학생성별, 받은 수 남1, 여2
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCnt = Integer.parseInt(br.readLine());
        switchArr = new int[switchCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < switchCnt; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int getNum = Integer.parseInt(st.nextToken());
            solution(gender, getNum);

        }

        for (int i = 0; i < switchArr.length; i++) {
            sb.append(switchArr[i]).append(" ");
            if ((i+1) % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    static void solution(int gender, int getNum) {
        // 남자일때
        if (gender == 1) {
            for (int i = getNum-1; i < switchArr.length; i+=getNum) {
                switchArr[i] = switchArr[i] == 1 ? 0 : 1;
            }
        }

        // 여자일때
        if (gender == 2) {
            int idx = getNum - 1;
            int lt = idx - 1, rt = idx + 1;
            if (idx < 0) return;
            switchArr[idx] = switchArr[idx] == 1 ? 0 : 1;
            while (lt >= 0 && rt < switchArr.length) {
                if (switchArr[lt] != switchArr[rt]) break;
                switchArr[lt] = switchArr[lt] == 1 ? 0 : 1;
                switchArr[rt] = switchArr[rt] == 1 ? 0 : 1;
                lt--;
                rt++;
            }
        }

    }


}