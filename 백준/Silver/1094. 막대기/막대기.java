import java.util.Scanner;

public class Main {
    static int X, answer;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        int sumStick = 64; // 최초 길이
        answer = 1; // X가 64일때 막대 1개로도 가능하기때문에 1로 초기화
        
        while (true) {
            if (sumStick == X) break;
            int tmpStick = 0;

            if (sumStick > X) {
                tmpStick = sumStick >> 1;
                sumStick = tmpStick;
                if (tmpStick >= X) { // 자른 막대가 X보다 크거나 같으면 tmpStick 버림
                    continue;
                } else {
                    X -= tmpStick;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}